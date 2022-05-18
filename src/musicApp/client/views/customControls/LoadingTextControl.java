package musicApp.client.views.customControls;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LoadingTextControl extends Text {
    private Text text;

    public LoadingTextControl() {
        initCustomLook();
    }

    private void initCustomLook() {
        text = new Text("Loading...");
        text.setFont(Font.font("System", FontWeight.BOLD, 18));
        text.setFill(Color.WHITE);
    }

    public void setTextForLoading(String text) {
        this.text.setText(text);
    }

    public Text getTextFromControl() {
        return text;
    }
}
