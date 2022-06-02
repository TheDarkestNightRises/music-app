package musicApp.client.views.addAlbum;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.client.views.updateSettings.UpdateSettingsViewModel;

import java.io.File;

/**
 * This is the add album view controller
 */
public class AddAlbumViewController implements ViewController {
    @FXML
    public TextField albumName;
    @FXML
    public ImageView albumPicture;

    private ViewHandler viewHandler;
    private AddAlbumViewModel viewModel;

    /** The init function is the constructor of this. It calls the bindings from the viewModel
     * and initialize the viewModel and viewHandler
     * @param vh for opening windows
     */
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.viewHandler = vh;
        viewModel = vmf.getAddAlbumViewModel();
        viewModel.bindAlbumName(albumName.textProperty());
        viewModel.bindImage(albumPicture.imageProperty());
    }

    /**
     *This methods check if the input is valid and if it is valid, it will create an album
     * and right after that the main menu will open
     */
    @FXML
    public void submitButtonPressed() {
        if (viewModel.Validate()) {
            viewModel.submit();
            viewHandler.openMainMenu();
        }
    }

    /**
     * This method is used to import a picture from the computer
     */
    @FXML
    public void choosePictureButtonPressed() {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        File file = chooser.showOpenDialog(viewHandler.getStage());
        if (file != null)
            viewModel.choosePicture(file);
    }

    /**
     * This method is linked to a button that on action will open the main menu
     */
    @FXML
    public void backButtonPressed() {
        viewHandler.openMainMenu();
    }


}
