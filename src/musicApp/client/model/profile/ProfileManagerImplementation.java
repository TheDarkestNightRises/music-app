package musicApp.client.model.profile;

import musicApp.client.network.Client;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ProfileManagerImplementation implements ProfileManager{
    private Client client;
    private PropertyChangeSupport support;

    public ProfileManagerImplementation(Client client) {
        this.client = client;
        this.support = new PropertyChangeSupport(this);
        client.addListener("newPlaylist", this::onNewPlaylist);
        client.addListener("newSongAddedToPlaylist", this::onNewSongAdded);
    }

    @Override
    public ArrayList<Playlist> fetchPlaylistsForUser(User user) {
        return client.getProfileClient().fetchPlaylistsForUser(user);
    }

    @Override
    public ArrayList<Song> fetchSongsForPlaylist(Playlist playlist) {
        return client.getProfileClient().fetchSongsForPlaylist(playlist);
    }

    @Override
    public byte[] fetchProfilePicture(String profile_picture) {
        return client.getProfileClient().fetchProfilePicture(profile_picture);
    }

    @Override public ArrayList<Album> fetchArtistAlbums(User user)
    {
        return client.getProfileClient().fetchArtistAlbums(user);
    }

    @Override public boolean isArtist(User user)
    {
        return client.getProfileClient().isArtist(user);
    }

    @Override public void follow(User user0, User user)
    {
        client.getProfileClient().follow(user0,user);
    }

    @Override public void unfollow(User user0, User user)
    {
        client.getProfileClient().unfollow(user0,user);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName,listener);
    }

    private void onNewSongAdded(PropertyChangeEvent propertyChangeEvent)
    {
        System.out.println("Fired from profile model");
        support.firePropertyChange("newSongAddedToPlaylist",null,propertyChangeEvent.getNewValue());
    }

    private void onNewPlaylist(PropertyChangeEvent propertyChangeEvent)
    {
        support.firePropertyChange("newPlaylist",null,propertyChangeEvent.getNewValue());
    }
}
