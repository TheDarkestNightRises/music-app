package musicApp.client.core;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import musicApp.client.views.profile.SongController;
import musicApp.server.model.Playlist;
import musicApp.server.model.Song;
import musicApp.server.model.User;

import java.io.IOException;
import java.util.ArrayList;

public class ViewHandler {

    private Scene chatScene;
    private Stage stage;
    private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
    }

    public void start() {
        stage = new Stage();
        openLogin();
    }

    public void openChat() {
        if (chatScene == null) {
            try {
                Parent root = loadFXML("../views/chat/ChatView.fxml");
                stage.setTitle("Chat");
                chatScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setTitle("Chat");
        stage.setScene(chatScene);
        stage.show();
        stage.setResizable(false);
        stage.centerOnScreen();
    }

    public void openLog() {
        try {
            Parent root = loadFXML("../views/log/LogView.fxml");
            Scene logScene = new Scene(root);
            stage.setTitle("Log");
            stage.setScene(logScene);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openLogin() {
        try {
            Parent root = loadFXML("../views/login/LoginMain.fxml");
            Scene loginScene = new Scene(root);
            stage.setTitle("Login");
            stage.setScene(loginScene);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openSignUp() {
        try {
            Parent root = loadFXML("../views/signup/SignUpView.fxml");
            Scene signUp = new Scene(root);
            stage.setTitle("Sign Up");
            stage.setScene(signUp);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openMusicPlayer(Playlist songs) {
        try {
            Parent root = loadFXML("../views/musicPlayer/MusicPlayer.fxml", songs);
            Scene signUp = new Scene(root);
            stage.setTitle("Music Player");
            stage.setScene(signUp);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openProfile(User user) {
        try {
            Parent root = loadFXML("../views/profile/ProfileView.fxml", user);
            Scene profile = new Scene(root);
            stage.setTitle("Profile");
            stage.setScene(profile);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void openFollowList() {
        try {
            Parent root = loadFXML("../views/followList/FollowList.fxml");
            Scene signUp = new Scene(root);
            stage.setTitle("FollowList");
            stage.setScene(signUp);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openUpdateSettings() {
        try {
            Parent root = loadFXML("../views/updateSettingsS/UpdateSettingsView.fxml");
            Scene settingsScene = new Scene(root);
            stage.setTitle("Update settings");
            stage.setScene(settingsScene);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Parent loadFXML(String path, Object... args) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();
        ViewController ctrl = loader.getController();
        ctrl.init(this, vmf, args);
        return root;
    }

    public VBox generateView(ArrayList<Song> songs) {
        VBox vBoxContainer = new VBox();
        vBoxContainer.setSpacing(10);
        Platform.runLater(() -> {
            if (songs.size() > 0) {
                vBoxContainer.getChildren().add(generatePlayButton(songs));
                HBox hBox = new HBox();
                hBox.setSpacing(10);
                for (Song song : songs) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("../views/profile/song.fxml"));
                    VBox vBox = null;
                    try {
                        vBox = fxmlLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    SongController songController = fxmlLoader.getController();
                    songController.setData(song);
                    hBox.getChildren().add(vBox);
                }
                vBoxContainer.getChildren().add(hBox);
            }
        });
        return vBoxContainer;
    }

    public Text generateLoadingText(){
        Text text = new Text("Loading...");
        text.setFont(Font.font("System", FontWeight.BOLD, 18));
        text.setFill(Color.WHITE);
        return text;
    }

    public Button generatePlayButton(ArrayList<Song> songs) {
        Button button = new Button();
        button.setText("Play");
        button.setOnAction(event -> this.openMusicPlayer(new Playlist(songs)));
        return button;
    }

}

