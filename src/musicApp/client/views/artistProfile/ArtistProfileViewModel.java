package musicApp.client.views.artistProfile;

import musicApp.client.model.login.LogInManager;
import musicApp.client.model.profile.ProfileManager;
import musicApp.server.model.domainModel.*;
import musicApp.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ArtistProfileViewModel implements Subject
{
  private PropertyChangeSupport support;
  private ProfileManager profileManager;
  private LogInManager logInManager;

  public ArtistProfileViewModel(ProfileManager profileManager, LogInManager loginManager) {
    this.support = new PropertyChangeSupport(this);
    this.logInManager = loginManager;
    this.profileManager = profileManager;
    profileManager.addListener("newSongAddedToPlaylist", this::updatePlaylist);
    profileManager.addListener("newPlaylist", this::onNewPlaylist);
  }

  private void onNewPlaylist(PropertyChangeEvent event) {
    support.firePropertyChange("newPlaylist", null, event.getNewValue());
  }

  private void updatePlaylist(PropertyChangeEvent event) {
    System.out.println("Fired from profile view model");
    support.firePropertyChange("newSongAddedToPlaylist", null, event.getNewValue());
  }

  public ArrayList<Playlist> fetchPlaylistsForUser(User user) {
    return profileManager.fetchPlaylistsForUser(user);
  }

  public ArrayList<Song> fetchSongsForPlaylist(Playlist playlist) {
    return profileManager.fetchSongsForPlaylist(playlist);
  }

  public byte[] fetchProfilePicture(String profile_picture) {
    return profileManager.fetchProfilePicture(profile_picture);
  }

  public User fetchUser() {
    return logInManager.getUser();
  }

  @Override
  public void addListener(String eventName, PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override
  public void removeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName, listener);
  }

  public ArrayList<Album> fetchArtistAlbums(User user)
  {
    return profileManager.fetchArtistAlbums(user);
  }

  public void follow(User user)
  {
    User user0 = fetchUser();
    profileManager.follow(user0,user);
  }

  public void unfollow(User user)
  {
    User user0 = fetchUser();
    profileManager.unfollow(user0,user);
  }
}
