package musicApp.client.views.search;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import musicApp.client.model.MainModel;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.server.model.search.SongPredicate;
import musicApp.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class SearchViewModel implements Subject {
    private ObservableList<Song> songs;
    private SimpleStringProperty search;
    private PropertyChangeSupport support;

    private MainModel mainModel;

    public SearchViewModel(MainModel mainModel) {
        this.mainModel = mainModel;
        this.songs = new SimpleListProperty<>(FXCollections.observableArrayList(fetchSortedList()));
        this.search = new SimpleStringProperty();
        this.support = new PropertyChangeSupport(this);
        this.mainModel.getSearchManager().addListener("newSearch", this::updateSearch);
    }

    private void updateSearch(PropertyChangeEvent event) {
        support.firePropertyChange("newSearch", null, event.getNewValue());
    }

    public void init() {
//        FilteredList<Song> filteredData = new FilteredList<>(songs);
//        search.addListener(((observable, oldValue, newValue) -> {
//            if (newValue.isEmpty() || newValue.isBlank()) return;
//            filteredData.setPredicate(p -> p.getTitle().contains(search.get()));
//            support.firePropertyChange("newSearch", null, filteredData);
//            System.out.println(filteredData);
//        }));
    }

    public void bindSearch(StringProperty property) {
        search.bindBidirectional(property);
    }

    public ArrayList<Song> fetchSortedList() {
        return mainModel.getSearchManager().fetchSortedList();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    public void search(String text) {
        mainModel.getSearchManager().search(text);
    }


    public User fetchUser() {
        return mainModel.getLogInManager().getUser();
    }
}
