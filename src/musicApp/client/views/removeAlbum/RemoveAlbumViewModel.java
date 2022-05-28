package musicApp.client.views.removeAlbum;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import musicApp.server.model.domainModel.*;

import java.util.ArrayList;

public class RemoveAlbumViewModel
{
  private final MainModel mainModel;
  private final SimpleListProperty<String> albumTitles;
  private ArrayList<Album> tempAlbums;
  private StringProperty error;

  public RemoveAlbumViewModel(MainModel model)
  {
    this.mainModel = model;
    albumTitles = new SimpleListProperty<>(FXCollections.observableArrayList());
    tempAlbums = new ArrayList<>();
    error = new SimpleStringProperty("");
  }

  public void reset()
  {
    albumTitles.setAll(getAlbumsTitles());
    error.set("");
  }

  public ArrayList<String> getAlbumsTitles()
  {
    User user = mainModel.getLogInManager().getUser();
    tempAlbums = mainModel.getProfileManager().fetchArtistAlbums(user);
    ArrayList<String> titles = new ArrayList<>();
    if (tempAlbums.size() != 0)
      for (int i = 0; i < tempAlbums.size(); i++)
      {
        titles.add(tempAlbums.get(i).getTitle());
      }
    return titles;
  }

    public void removeAlbum(int selectedIndex)
    {
      try
      {
        Album album = tempAlbums.get(selectedIndex);
        mainModel.getRemoveAlbumManager().deleteAlbum(album);
        error.set("The album has been removed!");
        albumTitles.remove(selectedIndex);
      }
      catch (Exception e)
      {
        error.set(e.getMessage());
      }
    }

  public void bindError(StringProperty property)
  {
    property.bind(error);
  }

  public void bindList(ObjectProperty<ObservableList<String>> property)
  {
    property.bind(albumTitles);
  }

}
