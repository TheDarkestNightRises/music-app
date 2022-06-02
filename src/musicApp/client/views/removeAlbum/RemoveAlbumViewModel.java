package musicApp.client.views.removeAlbum;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import musicApp.client.model.login.LogInManager;
import musicApp.client.model.profile.ProfileManager;
import musicApp.client.model.removeAlbum.RemoveAlbumManager;
import musicApp.server.model.domainModel.*;

import java.util.ArrayList;


/**
 * Remove album view model responsible for removing an album from the system
 */
public class RemoveAlbumViewModel
{
  private final SimpleListProperty<String> albumTitles;
  private final ProfileManager profileManager;
  private final LogInManager loginManager;
  private final RemoveAlbumManager removeAlbumManager;
  private ArrayList<Album> tempAlbums;
  private StringProperty error;

  /**
   * This is the constructor of the RemoveAlbumViewModel
   * @param profileManager to fetch the artist albums
   * @param loginManager to get the current user
   * @param removeAlbumManager to delete the album
   */
  public RemoveAlbumViewModel(ProfileManager profileManager, LogInManager loginManager,
                              RemoveAlbumManager removeAlbumManager) {
    this.profileManager = profileManager;
    this.loginManager = loginManager;
    this.removeAlbumManager = removeAlbumManager;
    albumTitles = new SimpleListProperty<>(FXCollections.observableArrayList());
    tempAlbums = new ArrayList<>();
    error = new SimpleStringProperty("");
  }

  /**
   * This is used to reinitialize the albums once a change is made
   */
  public void reset()
  {
    albumTitles.setAll(getAlbumsTitles());
    error.set("");
  }

  /**
   * This method is used to create a list with all the albums titles
   * @return the titles of all albums from the current artist
   */
  public ArrayList<String> getAlbumsTitles()
  {
    User user = loginManager.getUser();
    tempAlbums = profileManager.fetchArtistAlbums(user);
    ArrayList<String> titles = new ArrayList<>();
    if (tempAlbums.size() != 0)
      for (int i = 0; i < tempAlbums.size(); i++)
      {
        titles.add(tempAlbums.get(i).getTitle());
      }
    return titles;
  }

  /**
   * This method is used to remove an album by selecting one
   * @param selectedIndex is the index of the selected album
   */
    public void removeAlbum(int selectedIndex)
    {
      try
      {
        Album album = tempAlbums.get(selectedIndex);
        removeAlbumManager.deleteAlbum(album);
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
