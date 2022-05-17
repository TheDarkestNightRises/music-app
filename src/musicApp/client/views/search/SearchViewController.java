package musicApp.client.views.search;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;

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
    }


}
