package musicApp.client.views.addToPlaylist;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import musicApp.client.model.MainModel;
import musicApp.server.model.domainModel.Playlist;

import java.util.ArrayList;

public class AddToPlaylistViewModel
{
  private final MainModel mainModel;
  private final SimpleListProperty<String> playlists;

  public AddToPlaylistViewModel(MainModel model)
  {
    this.mainModel = model;
    playlists = new SimpleListProperty<>(FXCollections.observableArrayList());


  }
  public void reset()
  {
    playlists.setAll(getPlaylistTitles());
  }

  public ArrayList<String> getPlaylistTitles()
  {
    ArrayList<Playlist> playlists = mainModel.getProfileManager()
        .fetchPlaylistsForUser(mainModel.getLogInManager().getUser());
    ArrayList<String> titles = new ArrayList<>();
    if(playlists.size() != 0)
    for (int i = 0; i < playlists.size(); i++)
    {
      titles.add( playlists.get(i).getTitle());
    }
    return titles;
  }

  public void bindLogs(ObjectProperty<ObservableList<String>> property) {
    property.bind(playlists);
  }

  public void addToPlaylist(int selectedIndex)
  {
    //System.out.println(selectedIndex);

  }
}
