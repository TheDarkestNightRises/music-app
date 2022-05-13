package musicApp.client.views.profile;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.server.model.Playlist;
import musicApp.server.model.Song;
import musicApp.server.model.User;

import java.awt.*;
import java.util.ArrayList;

public class ProfileViewController implements ViewController {
    @FXML
    public VBox profileContainer;
    @FXML
    private HBox recentlyPlayedContainer;

    @FXML
    private HBox favoriteContainer;

    private ViewHandler vh;
    private ProfileViewModel viewModel;

    @Override public void init(ViewHandler vh, ViewModelFactory vmf,Object... args)
    {
        this.vh = vh;
        this.viewModel = vmf.getProfileViewModel();
        ArrayList<Playlist> playlists = null;
        for (Object object: args) {
            playlists = viewModel.fetchPlaylistsForUser((User) object);
        }
        System.out.println(playlists);
        assert playlists != null;
        for (Playlist playlist: playlists) {
            //Make text
            //Make scrollPane
            //Make Hbox
            //Put songs inside hbox
            Text text = new Text(playlist.getTitle());
            text.setFont(Font.font ("System", FontWeight.BOLD, 18));
            text.setFill(Color.WHITE);
            profileContainer.getChildren().add(text);
            HBox hBox = new HBox();
            profileContainer.getChildren().add(hBox);
            ArrayList<Song> songs = viewModel.fetchSongsForPlaylist();
        }
    }

    //    @Override
//    public void init(ViewHandler vh, ViewModelFactory vmf) {
//        this.vh = vh;
//        this.viewModel = vmf.getProfileViewModel();
//        // ----------------------------------SEGREGATE PLZ-----------------------------------
//        recentlyPlayed = new ArrayList<>(getRecentlyPlayed());
//        favorites = new ArrayList<>(getFavorites());
//
//        try {
//            for (Song song : recentlyPlayed) {
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                fxmlLoader.setLocation(getClass().getResource("song.fxml"));
//
//                VBox vBox = fxmlLoader.load();
//                SongController songController = fxmlLoader.getController();
//                songController.setData(song);
//
//                recentlyPlayedContainer.getChildren().add(vBox);
//            }
//
//            for (Song song : favorites) {
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                fxmlLoader.setLocation(getClass().getResource("song.fxml"));
//
//                VBox vBox = fxmlLoader.load();
//                SongController songController = fxmlLoader.getController();
//                songController.setData(song);
//
//                favoriteContainer.getChildren().add(vBox);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//
//    // ----------------------------------DUMMY DATA-----------------------------------
//    private List<Song> getRecentlyPlayed() {
//        List<Song> ls = new ArrayList<>();
//
//        Song song = new Song();
//        song.setTitle("In The Name Of Love");
//
//        song.setPicture_path("../img/In_the_Name_of_Love.jpeg");
//        ls.add(song);
//
//        song = new Song();
//        song.setTitle("Emri Olur");
//
//        song.setPicture_path("../img/emri_olur.jpg");
//        ls.add(song);
//
//        song = new Song();
//        song.setTitle("You are my sunshine");
//
//        song.setPicture_path("../img/jasmin_thompson.jpg");
//        ls.add(song);
//
//        song = new Song();
//        song.setTitle("On My Way");
//
//        song.setPicture_path("../img/on_my_way.jpg");
//        ls.add(song);
//
//        song = new Song();
//        song.setTitle("Let Me Love You");
//
//        song.setPicture_path("../img/let_me_love_you.jpg");
//        ls.add(song);
//
//        song = new Song();
//        song.setTitle("It Ain't Me");
//
//        song.setPicture_path("../img/It-Ain-t-Me.jpg");
//        ls.add(song);
//
//        song = new Song();
//        song.setTitle("One Dance");
//
//        song.setPicture_path("../img/one_dance.jpg");
//        ls.add(song);
//
//        song = new Song();
//        song.setTitle("Faded");
//
//        song.setPicture_path("../img/faded.jpg");
//        ls.add(song);
//
//        return ls;
//    }
//
//    public List<Song> getFavorites() {
//        List<Song> ls = new ArrayList<>();
//
//        Song song = new Song();
//        song.setTitle("Mühür");
//
//        song.setPicture_path("../img/mühür.jpg");
//        ls.add(song);
//
//        song = new Song();
//        song.setTitle("Faded");
//
//        song.setPicture_path("../img/faded.jpg");
//        ls.add(song);
//
//        song = new Song();
//        song.setTitle("Señorita");
//
//        song.setPicture_path("../img/seniorita.jpg");
//        ls.add(song);
//
//        song = new Song();
//        song.setTitle("Can't Help Falling in love");
//
//        song.setPicture_path("../img/cant_help_falling_in_love.jpg");
//        ls.add(song);
//
//        song = new Song();
//        song.setTitle("Friend");
//
//        song.setPicture_path("../img/friendjpg.jpg");
//        ls.add(song);
//
//        song = new Song();
//        song.setTitle("No Time To Die");
//
//        song.setPicture_path("../img/no_time_to_die.jpg");
//        ls.add(song);
//
//        song = new Song();
//        song.setTitle("Emri Olur");
//
//        song.setPicture_path("../img/emri_olur.jpg");
//        ls.add(song);
//
//        song = new Song();
//        song.setTitle("Wolves");
//
//        song.setPicture_path("../img/wolves.jpg");
//        ls.add(song);
//
//        return ls;
//    }
}
