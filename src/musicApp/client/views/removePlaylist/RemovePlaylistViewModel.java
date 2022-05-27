package musicApp.client.views.removePlaylist;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import musicApp.client.model.MainModel;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.User;

import java.util.ArrayList;

public class RemovePlaylistViewModel
{
  private final MainModel mainModel;
  private final SimpleListProperty<String> playlistTitles;
  private ArrayList<Playlist> tempPlaylist;
  private StringProperty error;

  public RemovePlaylistViewModel(MainModel model)
  {
    this.mainModel = model;
    playlistTitles = new SimpleListProperty<>(FXCollections.observableArrayList());
    tempPlaylist = new ArrayList<>();
    error = new SimpleStringProperty("");
  }

  public void reset()
  {
    playlistTitles.setAll(getPlaylistTitles());
    error.set("");
  }

  public ArrayList<String> getPlaylistTitles()
  {
    User user = mainModel.getLogInManager().getUser();
    tempPlaylist = mainModel.getProfileManager().fetchPlaylistsForUser(user);
    ArrayList<String> titles = new ArrayList<>();
    if (tempPlaylist.size() != 0)
      for (int i = 0; i < tempPlaylist.size(); i++)
      {
        titles.add(tempPlaylist.get(i).getTitle());
      }
    return titles;
  }

  public void removePlaylist(int selectedIndex)
  {
    try
    {
      Playlist playlist = tempPlaylist.get(selectedIndex);
      mainModel.getRemovePlaylistManager().deletePlaylist(playlist);
      error.set("The playlist has been removed!");
      playlistTitles.remove(selectedIndex);
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
    property.bind(playlistTitles);
  }
}
