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
import musicApp.client.views.cardForUserSearch.UserCardViewController;
import musicApp.client.views.album.AlbumViewController;
import musicApp.client.views.single.SingleController;
import musicApp.client.views.song.SongController;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ViewHandler {

    private Scene profileScene;
    private Scene mainMenuScene;
    private Scene mediaPlayerScene;
    private Stage stage;
    private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
    }

    public void start() {
        stage = new Stage();
        openLogin();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
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

    public void openArtistProfile(User user) {
        try {
            Parent root = loadFXML("../views/artistProfile/ArtistProfileView.fxml", user);
            stage.setTitle("Chat");
            profileScene = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Profile");
        stage.setScene(profileScene);
        stage.show();
        stage.setResizable(false);
        stage.centerOnScreen();
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

    public void openMusicPlayer(Playlist playlist) {
        try {
            Parent root = loadFXML("../views/musicPlayer/MusicPlayer.fxml", playlist);
            mediaPlayerScene = new Scene(root);
            stage.setTitle("Music Player");
            stage.setScene(mediaPlayerScene);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openMusicPlayer() {
        stage.setTitle("Music Player");
        stage.setScene(mediaPlayerScene);
        stage.show();
        stage.setResizable(false);
        stage.centerOnScreen();
    }

    public void openProfile(User user) {
        try {
            Parent root = loadFXML("../views/profile/ProfileView.fxml", user);
            stage.setTitle("Chat");
            profileScene = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
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

    public Parent openFollowListSubView() {
        try {
            Parent root = loadFXML("../views/followList/FollowList.fxml");
            Scene signUp = new Scene(root);
            stage.setTitle("FollowList");
            stage.setScene(signUp);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void openUpdateSettings(User user) {
        try {
            Parent root = loadFXML("../views/updateSettings/UpdateSettingsView.fxml", user);
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

    public void openSearch() {
        try {
            Parent root = loadFXML("../views/search/SearchView.fxml");
            Scene scene = new Scene(root);
            stage.setTitle("Search");
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openArtistSignUp() {
        try {
            Parent root = loadFXML("../views/artistSignUp/ArtistSignUpView.fxml");
            Scene scene = new Scene(root);
            stage.setTitle("Search");
            stage.setScene(scene);
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

    public VBox openSongView(Song song) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../views/song/SongView.fxml"));
        VBox vBox = null;
        try {
            vBox = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SongController songController = fxmlLoader.getController();
        songController.init(this, vmf);
        return vBox;
    }

    public VBox openSingleView(Song song) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../views/single/SingleView.fxml"));
        VBox vBox = null;
        try {
            vBox = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SingleController singlesController = fxmlLoader.getController();
        singlesController.init(this, vmf, song);
        return vBox;
    }

    public void openMainMenu() {

        try {
            Parent root = loadFXML("../views/mainMenu/MainMenuView.fxml");
            stage.setTitle("Main menu");
            mainMenuScene = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(mainMenuScene);
        stage.show();
        stage.setResizable(false);
        stage.centerOnScreen();
    }

    public void openRemoveAlbum() {

        try {
            Parent root = loadFXML("../views/removeAlbum/RemoveAlbumView.fxml");
            stage.setTitle("Remove Album");
            mainMenuScene = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(mainMenuScene);
        stage.show();
        stage.setResizable(false);
        stage.centerOnScreen();
    }

    public void openRemovePlaylist() {

        try {
            Parent root = loadFXML("../views/removePlaylist/RemovePlaylistView.fxml");
            stage.setTitle("Remove Playlist");
            mainMenuScene = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(mainMenuScene);
        stage.show();
        stage.setResizable(false);
        stage.centerOnScreen();
    }




    public VBox openAlbumView(Album album) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../views/album/AlbumView.fxml"));
        VBox vBox = null;
        try {
            vBox = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AlbumViewController albumViewController = fxmlLoader.getController();
        albumViewController.init(this, vmf, album);
        return vBox;
    }

    public HBox openProfileCardView(User user) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../views/cardForUserSearch/UserCardView.fxml"));
        HBox hBox = null;
        try {
            hBox = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserCardViewController userCardViewController = fxmlLoader.getController();
        userCardViewController.init(this, vmf, user);
        return hBox;
    }

    public Parent openProfileCard() {
        try {
            Parent root = loadFXML("../views/profileCard/ProfileCardView.fxml");
            Scene signUp = new Scene(root);
            stage.setTitle("FollowList");
            stage.setScene(signUp);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // -------------------- THIS CODE WAS USED FOR GENERATION DON'T DELETE , ITS FOR REFERENCE---------------
    public VBox generateView(ArrayList<Song> songs) {
        VBox vBoxContainer = new VBox();
        vBoxContainer.setSpacing(10);
        vBoxContainer.setPadding(new Insets(10));
        Platform.runLater(() -> {
            if (songs.size() > 0) {
                vBoxContainer.getChildren().add(generatePlayButton(songs));
                HBox hBox = new HBox();
                hBox.setSpacing(10);
                int counterUntilSpace = 0;
                for (Song song : songs) {
                    counterUntilSpace++;
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("../views/profile/SongView.fxml"));
                    VBox vBox = null;
                    try {
                        vBox = fxmlLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    SongController songController = fxmlLoader.getController();
                    songController.init(this, vmf);
                    hBox.getChildren().add(vBox);
                    if (counterUntilSpace == 4) {
                        vBoxContainer.getChildren().add(hBox);
                        hBox = new HBox();
                        hBox.setSpacing(10);
                    }
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

    public void openCreatePlaylist() {
        try {
            Parent root = loadFXML("../views/createPlaylist/CreatePlaylistView.fxml");
            Scene signUp = new Scene(root);
            stage.setTitle("Create playlist");
            stage.setScene(signUp);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openAddToPlaylist(Song song)
    {
        try {
            Parent root = loadFXML("../views/addToPlaylist/AddToPlaylistView.fxml", song);
            Scene signUp = new Scene(root);
            stage.setTitle("Add song to playlist playlist");
            stage.setScene(signUp);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  public void openAddAlbum()
  {
      try {
          Parent root = loadFXML("../views/addAlbum/AddAlbumView.fxml");
          Scene signUp = new Scene(root);
          stage.setTitle("Add song to playlist playlist");
          stage.setScene(signUp);
          stage.show();
          stage.setResizable(false);
          stage.centerOnScreen();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
    public void openDeleteSong() {
        try {
            Parent root = loadFXML("../views/deleteSong/DeleteSongView.fxml");
            Scene signUp = new Scene(root);
            stage.setTitle("Delete songs");
            stage.setScene(signUp);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openAddSong() {
        try {
            Parent root = loadFXML("../views/addSong/UploadSongView.fxml");
            Scene signUp = new Scene(root);
            stage.setTitle("Add a song");
            stage.setScene(signUp);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Parent openNavigation() {
        try {
            Parent root = loadFXML("../views/navigationBar/NavigationView.fxml");
            Scene signUp = new Scene(root);
            stage.setScene(signUp);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

