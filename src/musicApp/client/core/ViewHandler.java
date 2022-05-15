package musicApp.client.core;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import java.net.URL;
import java.util.ArrayList;

public class ViewHandler {

    private Scene profileScene;
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
        try {
            Parent root = loadFXML("../views/chat/ChatView.fxml");
            stage.setTitle("Chat");
            Scene scene = new Scene(root);
            stage.setTitle("Chat");
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        if (profileScene == null) {
            try {
                Parent root = loadFXML("../views/profile/ProfileView.fxml",user);
                stage.setTitle("Chat");
                profileScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setTitle("Profile");
        stage.setScene(profileScene);
        stage.show();
        stage.setResizable(false);
        stage.centerOnScreen();
    }

    public void openProfile() {
        //This method is used after profile has been generated.
        stage.setTitle("Profile");
        stage.setScene(profileScene);
        stage.show();
        stage.setResizable(false);
        stage.centerOnScreen();
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
        vBoxContainer.setPadding(new Insets(10));
        Platform.runLater(() -> {
            if (songs.size() > 0) {
//                vBoxContainer.getChildren().add(generatePlayButton(songs));
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
                    songController.init(this, vmf);
                    songController.setData(song);
                    hBox.getChildren().add(vBox);
                }
                vBoxContainer.getChildren().add(hBox);
            }
        });
        return vBoxContainer;
    }

    public Text generateLoadingText() {
        Text text = new Text("Loading...");
        text.setFont(Font.font("System", FontWeight.BOLD, 18));
        text.setFill(Color.WHITE);
        return text;
    }

    public Hyperlink generatePlayButton(ArrayList<Song> songs) {
        Hyperlink button = new Hyperlink();
        URL url = getClass().getResource("../views/img/ic_play.png");
        Image image = new Image(String.valueOf(url));
        ImageView imageView = new ImageView(image);
        button.setGraphic(imageView);
        button.setOnAction(event -> this.openMusicPlayer(new Playlist(songs)));
        return button;
    }

    public HBox generateTitleHBox(ArrayList<Song> songs) {
        HBox titleHBox = new HBox();
        titleHBox.setSpacing(10);
        if (songs.size() > 0) {
            Hyperlink button = this.generatePlayButton(songs);
            titleHBox.getChildren().add(button);
        }
        return titleHBox;
    }
}

