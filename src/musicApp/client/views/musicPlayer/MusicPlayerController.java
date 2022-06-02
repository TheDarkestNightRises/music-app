package musicApp.client.views.musicPlayer;

import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

/**
 * The music player controller is responsible for controlling the media player and showing
 * information about the current song. note: this class breaks S from solid because it has too
 * much responsibility. Also, it doesn't have bindings for everything.
 */
public class MusicPlayerController implements ViewController {
    private Media media;
    private MediaPlayer mediaPlayer;

    @FXML
    public ImageView albumCover;
    @FXML
    private Slider sliderTime;
    @FXML
    private Slider volumeSlider;
    @FXML
    private Label songLabel;

    private ViewHandler viewHandler;
    private MusicPlayerViewModel musicPlayerViewModel;

    /**
     * The constructor of this controller. It calls the view model to do bindings
     * @param vh to open views
     * @param vmf to initialize the view Model
     * @param args to initialize the playlist when opened
     */
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf,Object... args) {
        this.viewHandler = vh;
        this.musicPlayerViewModel = vmf.getMusicPlayerViewModel();
        songLabel.textProperty().bind(musicPlayerViewModel.currentSongLabelProperty());
        volumeSlider.valueProperty().addListener(this::changeVolume);
        sliderTime.maxProperty().bind(musicPlayerViewModel.getMaxProperty());
        musicPlayerViewModel.bindImage(albumCover.imageProperty());
        musicPlayerViewModel.init(args);
        changeSong(musicPlayerViewModel.currentSong());
    }

    /**
     * This method will change the volume of the media player when the
     * slider changes its value
     * @param observable slider new value
     */
    private void changeVolume(Observable observable) {
        mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
    }

    /**
     * This method will change the curent song and play it
     * @param file song file
     */
    private void changeSong(File file)  {
        if (mediaPlayer != null) mediaPlayer.stop();
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        setTimeSliderListeners();
        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(this::nextMedia);
        mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
    }

    /**
     * This method will play the media inside the player
     */
    public void playMedia() {
        mediaPlayer.play();
    }

    /**
     * This method will pause the media inside the player
     */
    public void pauseMedia() {
        mediaPlayer.pause();
    }

    /**
     * This method will reset the current song to the start
     */
    public void resetMedia() {
        mediaPlayer.seek(Duration.seconds(0));
    }

    /**
     * This method will call for the view model to fetch the previous song from the list and change
     * the media player
     */
    public void previousMedia() {
        changeSong(musicPlayerViewModel.previousMedia());
    }

    /**
     * This method will call for the view model to fetch the next song from the list and change
     * the media player
     */
    public void nextMedia() {
        changeSong(musicPlayerViewModel.nextMedia());
    }

    /**
     * Time slider listeners .
     * It listens to the totalDuration of the media player
     * so the slider can have different values depending on the song
     * It listens to the currentTime , it can show how much the media player spend playing
     * It listens to the
     */
    private void setTimeSliderListeners() {
        //Change the volume slider max value

        mediaPlayer.totalDurationProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration oldValue, Duration newValue) {
                System.out.println(newValue);
//                sliderTime.setMax(newValue.toSeconds() - 1);
                musicPlayerViewModel.setMaximumDuration(newValue.toSeconds() - 1);
            }
        });
        //Change the current value in the volume slider
        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration oldValue, Duration newValue) {
                sliderTime.setValue(newValue.toSeconds());
            }
        });
        //If the user changes the value change the time slider
        sliderTime.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                double currentTime = mediaPlayer.getCurrentTime().toSeconds();
                if (Math.abs(currentTime - newValue.doubleValue()) > 0.8) {
                    mediaPlayer.seek(Duration.seconds(newValue.doubleValue()));
                }
            }
        });
    }

    /**
     * This method is linked to the like button. On action it will add the current song from the
     * liked songs playlist. It delegates responsability to view model
     */
    @FXML public void addToLikedSongs(){
    musicPlayerViewModel.addToLikedSongs();
    }

    /**
     * This method is linked to the dislike button. On action it will remove the current song from the
     * liked songs playlist. It delegates responsability to view model
     */
    @FXML public void removeFromLikedSongs(){
        musicPlayerViewModel.removeToLikedSongs();
    }

    /**
     * This method opens the main menu and closes the media player
     */
    public void onBackButton() {
        mediaPlayer.stop();
        viewHandler.openMainMenu();
    }

    /**
     * This method opens the add to playlist window (the song will still play)
     */
    public void addToPlaylistButtonPressed()
    {
        viewHandler.openAddToPlaylist(musicPlayerViewModel.fetchCurrentSong());
    }
}
