package musicApp.client.views.loadingScreen;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class LoadingScreenViewController {
    @FXML
    public Text progress;

    public void setTextProgress(String text) {
        progress.setText(text);
    }
}
