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

public class AddAlbumViewController implements ViewController
{
  @FXML
  public TextField albumName;
  @FXML
  public ImageView albumPicture;
  @FXML
  public HBox createAlbum;
  private ViewHandler viewHandler;
  private AddAlbumViewModel viewModel;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Object... args)
  {
    this.viewHandler = vh;
    viewModel = vmf.getAddAlbumViewModel();
    viewModel.bindAlbumName(albumName.textProperty());
    viewModel.bindImage(albumPicture.imageProperty());
  }

  @FXML
  public void submitButtonPressed()
  {
    viewModel.submit();
    viewHandler.openMainMenu();
  }


  @FXML
  public void choosePictureButtonPressed()
  {
    FileChooser chooser = new FileChooser();
    chooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("JPG", "*.jpg"),
        new FileChooser.ExtensionFilter("PNG", "*.png")
    );
    File file = chooser.showOpenDialog(viewHandler.getStage());
    if(file != null)
      viewModel.choosePicture(file);
  }

  @FXML
  public void backButtonPressed()
  {
    viewHandler.openMainMenu();
  }


}
