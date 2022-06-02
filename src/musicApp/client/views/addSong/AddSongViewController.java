package musicApp.client.views.addSong;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;

import java.io.File;

public class AddSongViewController implements ViewController {
    @FXML
    private ListView<String> list;
    @FXML
    private TextField title;
    @FXML
    private Label error;
    @FXML
    private Label fileName;
    
    private ViewHandler viewHandler;
    private AddSongViewModel viewModel;

    /**
     * The init function is the constructor of this. It calls the bindings from the viewModel
     * and initialize the viewModel and viewHandler.
     * @param vh
     * @param vmf
     * @param args
     */
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf,
                     Object... args) {
        viewHandler = vh;
        viewModel = vmf.getAddSongViewModel();
        viewModel.bindError(error.textProperty());
        viewModel.bindList(list.itemsProperty());
        viewModel.bindTitle(title.textProperty());
        viewModel.bindFileName(fileName.textProperty());
        viewModel.reset();
    }

    /**
     * This method is linked to a button that on action will open the main menu
     */
    @FXML
    public void backToProfile() {
        viewHandler.openMainMenu();
    }

    /**
     * This method is linked to a button that on action will open the File Chooser and make the user choose an .m4a file
     * and pass to the view model
     */
    @FXML
    public void chooseFileButtonPressed() {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("M4A", "*.m4a")
        );
        File file = chooser.showOpenDialog(viewHandler.getStage());
        if (file != null)
            viewModel.chooseFile(file);
    }
    /**
     * This method is linked to a button that on action will send the selected index of the list to the view model in order to create a song
     */
    @FXML
    protected void createButtonPressed() {
        viewModel.addSong(list.getSelectionModel().getSelectedIndex());
    }
}

