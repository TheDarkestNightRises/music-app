package musicApp.client.views.addSong;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.views.deleteSong.DeleteSongViewModel;
import musicApp.server.model.domainModel.User;

import java.io.File;

public class AddSongViewController implements ViewController {
    @FXML
    private ListView<String> list;
    @FXML
    private TextField title;
    @FXML
    private Label errorLabel;
    @FXML
    private Label fileNameLabel;
    private ViewHandler viewHandler;
    private AddSongViewModel viewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf,
                     Object... args) {
        viewHandler = vh;
        viewModel = vmf.getAddSongViewModel();
        viewModel.bindError(errorLabel.textProperty());
        viewModel.bindList(list.itemsProperty());
        viewModel.bindTitle(title.textProperty());
        viewModel.bindFileName(fileNameLabel.textProperty());
        viewModel.reset();
    }

    @FXML
    public void backToProfile() {
        viewHandler.openMainMenu();
    }

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

    @FXML
    protected void createButtonPressed() {
        viewModel.addSong(list.getSelectionModel().getSelectedIndex());
    }
}

