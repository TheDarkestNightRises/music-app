package musicApp.client.views.search;


import javafx.application.Platform;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.server.model.domainModel.Song;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class SearchViewController implements ViewController {

    @FXML
    public VBox searchContainer;
    @FXML
    public TextField searchTextField;

    private SearchViewModel searchViewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
       this.viewHandler = vh;
       this.searchViewModel = vmf.getSearchViewModel();
       searchViewModel.bindSearch(searchTextField.textProperty());
       searchViewModel.init();
       searchViewModel.addListener("newSearch",this::showSearchResults);
    }

    private void showSearchResults(PropertyChangeEvent event) {
        new Thread(()->{
            FilteredList<Song> filteredList = (FilteredList<Song>) event.getNewValue();
            ArrayList<Song> songs = new ArrayList<>(filteredList);
            Platform.runLater(()->{
                searchContainer.getChildren().clear();
                searchContainer.getChildren().add(viewHandler.generateView(songs));
            });
        }).start();
    }


}
