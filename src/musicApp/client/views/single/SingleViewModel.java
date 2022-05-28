package musicApp.client.views.single;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import musicApp.server.model.domainModel.Song;

import java.io.ByteArrayInputStream;

public class SingleViewModel {

    private StringProperty songProperty;
    private StringProperty artistProperty;
    private ObjectProperty<Image> albumPictureProperty;
    private final MainModel mainModel;

    public SingleViewModel(MainModel mainModel) {
        this.artistProperty = new SimpleStringProperty();
        this.songProperty = new SimpleStringProperty();
        this.albumPictureProperty = new SimpleObjectProperty<>();
        this.mainModel = mainModel;
    }

    public void init(Song song) {
        songProperty.set(song.getTitle());
        artistProperty.set(song.getArtist().getName());
        String picturePath = song.getAlbum().getPicturePath();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mainModel.getMusicPlayerManager().fetchAlbumCover(picturePath));
        Image image = new Image(byteArrayInputStream);
        albumPictureProperty.set(image);
    }

    public void bindArtist(StringProperty textProperty) {
        artistProperty.bindBidirectional(textProperty);
    }

    public void bindSongName(StringProperty textProperty) {
        songProperty.bindBidirectional(textProperty);
    }

    public void bindImage(ObjectProperty<Image> imageProperty) {
        albumPictureProperty.bindBidirectional(imageProperty);
    }
}
