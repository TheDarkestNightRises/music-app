package musicApp.client.views.search;

import javafx.application.Platform;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import musicApp.client.model.login.LogInManager;
import musicApp.client.model.search.SearchManager;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class   SearchViewModel implements Subject {
    private final SearchManager searchManager;
    private SimpleStringProperty search;
    private SimpleStringProperty searchStatus;
    private PropertyChangeSupport support;
    private ObservableList<SearchComboBoxChoices> searchComboBoxChoices;



    public SearchViewModel(SearchManager searchManager) {
        this.searchManager = searchManager;
        this.search = new SimpleStringProperty();
        this.searchStatus = new SimpleStringProperty();
        this.support = new PropertyChangeSupport(this);
        searchManager.addListener("newSearchSong", this::updateSearchSong);
        searchManager.addListener("newSearchAlbum", this::updateSearchAlbum);
        searchManager.addListener("newSearchProfile", this::updateSearchProfile);
    }

    private void updateSearchSong(PropertyChangeEvent event) {
        ArrayList<Song> songs = (ArrayList<Song>) event.getNewValue();
        Platform.runLater(()->{
            if (songs.isEmpty()) searchStatus.set("No songs found");
        });
        support.firePropertyChange(event);
    }

    private void updateSearchAlbum(PropertyChangeEvent event) {
        ArrayList<Album> albums = (ArrayList<Album>) event.getNewValue();
        Platform.runLater(()->{
            if (albums.isEmpty()) searchStatus.set("No albums found");
        });
        support.firePropertyChange(event);
    }

    private void updateSearchProfile(PropertyChangeEvent event) {
        ArrayList<User> users = (ArrayList<User>) event.getNewValue();
        Platform.runLater(()->{
            if (users.isEmpty()) searchStatus.set("No users found");
        });
        support.firePropertyChange(event);
    }

    public void init() {
        loadComboBox();
    }


    public void bindSearch(StringProperty property) {
        search.bindBidirectional(property);
    }

    public void bindSearchText(StringProperty textProperty) {
        searchStatus.bindBidirectional(textProperty);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    public void search(SearchComboBoxChoices selectedItem) {
        if (inputIsCorrect(selectedItem)) {
            switch (selectedItem) {
                case Album -> searchManager.searchAlbum(search.get());
                case Profile -> searchManager.searchProfile(search.get());
                default -> searchManager.searchSong(search.get());
            }
        }
    }

    public boolean inputIsCorrect(SearchComboBoxChoices selectedItem) {
        searchStatus.set("Search");
        if (selectedItem == null) {
            searchStatus.set("Select a category");
            return false;
        }
        String searchInput = search.get();
        if (searchInput == null || "".equals(searchInput)) {
            searchStatus.set("Input a value");
            return false;
        }
        return true;
    }


    private void loadComboBox() {
        searchComboBoxChoices = FXCollections.observableArrayList(SearchComboBoxChoices.Album, SearchComboBoxChoices.Song, SearchComboBoxChoices.Profile);
    }


    public ObservableList<SearchComboBoxChoices> getComboBoxChoices() {
        return searchComboBoxChoices;
    }
}
