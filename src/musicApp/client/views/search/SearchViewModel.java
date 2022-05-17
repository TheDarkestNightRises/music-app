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
import musicApp.util.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchViewModel implements Subject {
    private ObservableList<Song> songs;
    private SimpleStringProperty search;
    private PropertyChangeSupport support;

    private MainModel mainModel;

    public SearchViewModel(MainModel mainModel) {
        this.mainModel = mainModel;
        this.songs = new SimpleListProperty<>(FXCollections.observableArrayList());
    }

    public void init() {
        FilteredList<Song> filteredData = new FilteredList<>(songs);
        SortedList<Song> sortedList = new SortedList<>(filteredData);//Fetch sorted list
        //bind sorted list
        fetchSortedList().comparatorProperty().bind(songs.sorted().comparatorProperty());
    }

    public void bindSearch(StringProperty property)
    {
        search.bindBidirectional(property);
    }

    public SortedList<Song> fetchSortedList() {
        return mainModel.getSearchManager().fetchSortedList();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }
}
