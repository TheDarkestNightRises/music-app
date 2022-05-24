package musicApp.client.model.search;

import musicApp.client.network.Client;
import musicApp.server.model.domainModel.Song;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class SearchManagerImplementation implements SearchManager {
    private final Client client;
    private PropertyChangeSupport support;

    public SearchManagerImplementation(Client client) {
        this.client = client;
        this.support = new PropertyChangeSupport(this);
        client.addListener("newSearch", this::onNewSearch);
    }

    @Override
    public ArrayList<Song> fetchSortedList() {
        return client.getSearchClient().fetchSortedList();
    }

    @Override
    public void searchSong(String search) {
        client.getSearchClient().searchSong(search);
    }

    @Override
    public void searchAlbum(String search) {
        client.getSearchClient().searchAlbum(search);
    }

    @Override
    public void searchProfile(String search) {
        client.getSearchClient().searchProfile(search);
    }

    @Override
    public void onNewSearch(PropertyChangeEvent event) {
        support.firePropertyChange("newSearch", null, event.getNewValue());
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
