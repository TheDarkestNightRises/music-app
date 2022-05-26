package musicApp.client.views.deleteSong;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import musicApp.client.model.MainModel;

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
    //songTitles.setAll(getArtistSongsTitles(mainModel.getLogInManager().getUser()));//TODO
  }

  public void bindError(StringProperty property)
  {
    error.bindBidirectional(property);
  }
  public void bindList(ObjectProperty<ObservableList<String>> property)
  {
    property.bind(songTitles);
  }
}
