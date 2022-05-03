package musicApp.client.views.loadingScreen;

import javafx.scene.text.Text;

public class LoadingScreenViewController {
    public Text progress;

    public void setTextProgress(String text) {
        progress.setText(text);
    }
}
