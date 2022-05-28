package musicApp.client.views.artistProfile;

import musicApp.client.model.MainModel;
import musicApp.database.artist.ArtistDAOImpl;
import musicApp.server.model.domainModel.*;
import musicApp.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArtistProfileViewModel implements Subject
{
  private MainModel mainModel;
  private PropertyChangeSupport support;


  public ArtistProfileViewModel(MainModel mainModel) {
    this.mainModel = mainModel;
    this.support = new PropertyChangeSupport(this);
    this.mainModel.getProfileManager().addListener("newSongAddedToPlaylist", this::updatePlaylist);
    this.mainModel.getProfileManager().addListener("newPlaylist", this::onNewPlaylist);
  }

  private void onNewPlaylist(PropertyChangeEvent event) {
    support.firePropertyChange("newPlaylist", null, event.getNewValue());
  }

  private void updatePlaylist(PropertyChangeEvent event) {
    System.out.println("Fired from profile view model");
    support.firePropertyChange("newSongAddedToPlaylist", null, event.getNewValue());
  }

  public ArrayList<Playlist> fetchPlaylistsForUser(User user) {
    return mainModel.getProfileManager().fetchPlaylistsForUser(user);
  }

  public ArrayList<Song> fetchSongsForPlaylist(Playlist playlist) {
    return mainModel.getProfileManager().fetchSongsForPlaylist(playlist);
  }

  public byte[] fetchProfilePicture(String profile_picture) {
    return mainModel.getProfileManager().fetchProfilePicture(profile_picture);
  }

  public User fetchUser() {
    return mainModel.getLogInManager().getUser();
  }

  @Override
  public void addListener(String eventName, PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override
  public void removeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName, listener);
  }

  public ArrayList<Album> fetchArtistAlbums()
  {
    User user = mainModel.getLogInManager().getUser();
    return mainModel.getProfileManager().fetchArtistAlbums(user);
  }

  public void follow(User user)
  {
    User user0 = fetchUser();
    mainModel.getProfileManager().follow(user0,user);
  }

  public void unfollow(User user)
  {
    User user0 = fetchUser();
    mainModel.getProfileManager().unfollow(user0,user);
  }
}
