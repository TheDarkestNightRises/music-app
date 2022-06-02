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
import musicApp.client.views.followList.ContactItemController;
import musicApp.client.views.single.SingleController;
import musicApp.client.views.song.SongController;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * The ViewHandler is responsible for loading all the views in the application.Some views can be
 * cached in this class for better performance. The stage remains the same while scenes are being swapped.
 */
public class ViewHandler {

    private Scene profileScene;
    private Scene mainMenuScene;
    private Scene mediaPlayerScene;
    private Stage stage;
    private ViewModelFactory vmf;

    /**
     * The constructor for the ViewHandler class.
     * @param vmf each view has a reference to it's viewModel that's why the viewHandler needs this factory
     */
    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
    }

    /**
     * This is the start method. The start method will initialize the stage and open the first window(login)
     */
    public void start() {
        stage = new Stage();
        openLogin();
    }

    /**
     * This method returns the current stage
     * @return stage
     */

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * This method will load the fxml for the ChatView. After loading it and initializing the controller
     * this will open the chat view
     */
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


    /**
     * This method will load the fxml for the LogView. After loading it and initializing the controller
     * this will open the log view.
     */
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

    /**
     * This method will load the fxml for the LoginMain. After loading it and initializing the controller
     * this will open the login view.
     */
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

    /**
     * This method will load the fxml for the ArtistProfileView. After loading it and initializing the controller
     * this will open the artist profile view.It takes a user as a parameter because to open this view
     * you need the user's info, playlists,albums etc.
     */
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

    /**
     * This method will load the fxml for the SignUpView. After loading it and initializing the controller
     * this will open the signup view.
     */
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

    /**
     * This method will load the fxml for the MusicPlayer. After loading it and initializing the controller
     * this will open the artist music player view. It takes a playlist to open a music player because
     * the window needs to play playlist
     */
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

    /**
     * This method will load the music player scene cached in the viewHandler.
     * Must be used only when you want to go back to this window.
     * this will open the artist music player view.
     */
    public void openMusicPlayer() {
        stage.setTitle("Music Player");
        stage.setScene(mediaPlayerScene);
        stage.show();
        stage.setResizable(false);
        stage.centerOnScreen();
    }

    /**
     * This method will load the fxml for the ProfileView. After loading it and initializing the controller
     * this will open the users profile view.It takes a user as a parameter because to open this view
     * you need the user's info, playlists etc.
     */
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

    /**
     * This method will load the profile scene cached in the viewHandler.
     * Must be used only when you want to go back to this window.
     * This will open the profile view.
     */
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
    /**
     * This method will load the fxml for the FollowList. After loading it and initializing the controller
     * this will open the follow list.
     */
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
    /**
     * This method will load the fxml for the UpdateSettingsView. After loading it
     * and initializing the controller this will open the update settings view.
     * It takes a user as a parameter because to open this view
     * you need the user's info, profile picture,description etc.
     */
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

    /**
     * This method will load the fxml for the SearchView. After loading it and initializing the controller
     * this will open the search view.
     */
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

    /**
     * This method will load the fxml for the ArtistSignUpView. After loading it and initializing the controller
     * this will open the artist signup.
     */
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

    /**
     * This method will read and initialize the fxml that is given to it.
     * @param path of the fxml file
     * @param args to pass objects if the view needs objects to be initialized.
     * @return Parent to set the new Scene
     * @throws IOException because it's loading the fxml from a file
     */
    private Parent loadFXML(String path, Object... args) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();
        ViewController ctrl = loader.getController();
        ctrl.init(this, vmf, args);
        return root;
    }

    /**
     * This method will load the fxml for the SongView into a vbox to be used as a component.
     * After loading it and initializing the controller this will open the song view.
     * @param song to init the song details
     */
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
        songController.init(this, vmf, song);
        return vBox;
    }


    /**
     * This method will load the fxml for the SingleView into a vbox to be used as a component.
     * After loading it and initializing the controller this will open the single view.
     * @param song to init the single details
     */
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

    /**
     * This method will load the fxml for the MainMenuView. After loading it and initializing the controller
     * this will open the artist main menu.
     */
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

    /**
     * This method will load the fxml for the RemoveAlbumView. After loading it and initializing the controller
     * this will open the remove album view.
     */
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

    /**
     * This method will load the fxml for the RemoveAlbumView. After loading it and initializing the controller
     * this will open the remove playlist view.
     */
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


    /**
     * This method will load the fxml for the AlbumView into a vbox to be used as a component.
     * After loading it and initializing the controller this will open the album view.
     * @param album to init the album details
     */
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

    /**
     * This method will load the fxml for the AlbumView into a HBox to be used as a subView.
     * After loading it and initializing the controller this will open the album view.
     * @param user to init the user's details
     */
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

    /**
     * This method will load the fxml for the ProfileCardView.
     * After loading it and initializing the controller this will open the album view.
     */
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

    /**
     * This method will load the fxml for the CreatePlaylistView.
     * After loading it and initializing the controller this will open the create playlist view.
     */
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

    /**
     * This method will load the fxml for the AddToPlaylistView.
     * After loading it and initializing the controller this will open the add to playlist view.
     */
    public void openAddToPlaylist(Song song) {
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

    /**
     * This method will load the fxml for the AddAlbumView.
     * After loading it and initializing the controller this will open the add to album view.
     */
    public void openAddAlbum() {
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

    /**
     * This method will load the fxml for the DeleteSongView.
     * After loading it and initializing the controller this will open the delete song view.
     */
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


    /**
     * This method will load the fxml for the UploadSongView.
     * After loading it and initializing the controller this will open upload song view.
     */
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

    /**
     * This method will load the fxml for the NavigationView.
     * After loading it and initializing the controller this will open navigation view.
     */
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

    /**
     * This method will load the fxml for the contact_item into a HBox to be used as a component.
     * After loading it and initializing the controller this will open the album view.
     * @param user to init the user's details
     */

    public HBox openContact(User user)
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../views/followList/contact_item.fxml"));
        HBox hBox = null;
        try {
            hBox = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ContactItemController contactItemController = fxmlLoader.getController();
        contactItemController.init(this, vmf, user);
        return hBox;
    }
}

