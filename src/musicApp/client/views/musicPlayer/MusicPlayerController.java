package musicApp.client.views.musicPlayer;

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

    private void changeVolume(Observable observable) {
        mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
    }

    private void changeSong(File file)  {
        if (mediaPlayer != null) mediaPlayer.stop();
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        setTimeSliderListeners();
        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(this::nextMedia);
        mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
    }

    public void playMedia() {
        mediaPlayer.play();
    }

    public void pauseMedia() {
        mediaPlayer.pause();
    }

    public void resetMedia() {
        mediaPlayer.seek(Duration.seconds(0));
    }

    public void previousMedia() {
        changeSong(musicPlayerViewModel.previousMedia());
    }

    public void nextMedia() {
        changeSong(musicPlayerViewModel.nextMedia());
    }

    private void setTimeSliderListeners() {
        //Change the volume slider max value

        mediaPlayer.totalDurationProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration oldValue, Duration newValue) {
//todo call method on vm to set max time on property PROPERTIES ARE READ ONLY
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

    @FXML public void addToLikedSongs(){
    musicPlayerViewModel.addToLikedSongs();
    }

    @FXML public void removeFromLikedSongs(){
        musicPlayerViewModel.removeToLikedSongs();
    }

    public void onBackButton() {
        mediaPlayer.stop();
        viewHandler.openProfile();
    }
}
