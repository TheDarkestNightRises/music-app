package musicApp.client.views.deleteSong;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import musicApp.client.model.MainModel;

import java.util.Optional;

public class DeleteSongViewModel
{
  private final MainModel mainModel;
  private final StringProperty error;
  private final SimpleListProperty<String> songTitles;

  public DeleteSongViewModel(MainModel model)
  {
    this.mainModel = model;

    this.error = new SimpleStringProperty("");
    songTitles = new SimpleListProperty<>(FXCollections.observableArrayList());

  }

//  public ArrayList<String> getArtistSongsTitles(User user)
//  {
//    return mainModel.getDeleteSongManager().;
//  }

  public void reset()
  {
    error.set("");
    try
    {
      songTitles.setAll(mainModel.getDeleteSongManager().getArtistSongsTitles(mainModel.getLogInManager().getUser()));//TODO
    }catch (Exception e)
    {
      e.printStackTrace();
      error.set("Could not retrieve songs from server");
    }
  }

  public void bindError(StringProperty property)
  {
    error.bindBidirectional(property);
  }
  public void bindList(ObjectProperty<ObservableList<String>> property)
  {
    property.bind(songTitles);
  }

  public boolean deleteSong(int selectedIndex)
  {

    if(selectedIndex < 0)
    {
      error.set("Please select a song");
      return false;
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setContentText("Are you sure that you want to delete this song?");
      Optional<ButtonType> result = alert.showAndWait();
      if (result.isPresent() && result.get() == ButtonType.OK)
      {
        try{
          mainModel.getDeleteSongManager().deleteSong(selectedIndex);
          error.set("Song deleted successfully");
          return true;
        }catch (Exception e)
        {
          e.printStackTrace();
          return false;
        }
      }
      return false;
    }
  }
}
