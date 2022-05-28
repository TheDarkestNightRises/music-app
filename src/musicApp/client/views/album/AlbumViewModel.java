package musicApp.client.views.album;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import musicApp.client.model.MainModel;
import musicApp.server.model.domainModel.Album;

import java.io.ByteArrayInputStream;

public class AlbumViewModel {

    private StringProperty artistProperty;
    private StringProperty albumProperty;
    private ObjectProperty<Image> albumPictureProperty;
    private final MainModel mainModel;

    public AlbumViewModel(MainModel mainModel) {
        this.artistProperty = new SimpleStringProperty();
        this.albumProperty = new SimpleStringProperty();
        this.albumPictureProperty = new SimpleObjectProperty<>();
        this.mainModel = mainModel;
    }

    public void init(Album album) {
        albumProperty.set(album.getTitle());
        artistProperty.set(album.getArtist().getName());
        Image image = new Image(new ByteArrayInputStream(mainModel.getMusicPlayerManager().fetchAlbumCover(album.getPicturePath())));
        albumPictureProperty.set(image);
    }

    public void bindArtist(StringProperty textProperty) {
        artistProperty.bindBidirectional(textProperty);
    }

    public void bindAlbumName(StringProperty textProperty) {
        albumProperty.bindBidirectional(textProperty);
    }

    public void bindImage(ObjectProperty<Image> imageProperty) {
        albumPictureProperty.bindBidirectional(imageProperty);
    }
}
