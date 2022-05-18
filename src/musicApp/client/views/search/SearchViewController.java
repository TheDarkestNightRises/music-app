package musicApp.client.views.search;


import javafx.application.Platform;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.views.customControls.LoadingTextControl;
import musicApp.client.views.customControls.PlaylistTitleControl;
import musicApp.client.views.customControls.SongsHBoxControl;
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
        Platform.runLater(()->{
            LoadingTextControl loadingTextControl = new LoadingTextControl();
            HBox containerHBox = new HBox();
            containerHBox.setAlignment(Pos.CENTER_LEFT);
            containerHBox.setPadding(new Insets(10));
            containerHBox.setSpacing(10);
            containerHBox.getChildren().add(loadingTextControl.getTextFromControl());
            searchContainer.getChildren().add(containerHBox);
            VBox vBoxContainer = new VBox();
            searchContainer.getChildren().add(vBoxContainer);
        });
        new Thread(()->{
            System.out.println(event.getNewValue());
            ArrayList<Song> songs = (ArrayList<Song>) event.getNewValue();
            Platform.runLater(()->{
                searchContainer.getChildren().clear();
                SongsHBoxControl songsHBoxControl = new SongsHBoxControl(songs, viewHandler, searchContainer);
            });
        }).start();
    }

    public void search() {
        searchViewModel.search(searchTextField.getText());
    }
}
