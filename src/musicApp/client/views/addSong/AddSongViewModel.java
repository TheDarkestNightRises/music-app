package musicApp.client.views.addSong;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import musicApp.client.model.addSong.AddSongManager;
import musicApp.client.model.login.LogInManager;

import java.io.File;

public class AddSongViewModel {
    private final StringProperty error;
    private final SimpleListProperty<String> albumTitles;
    private final LogInManager loginManager;
    private final AddSongManager addSongManager;
    private StringProperty title;
    private StringProperty fileName;
    private File songFile;

    public AddSongViewModel(LogInManager loginManager, AddSongManager addSongManager) {
        this.loginManager = loginManager;
        this.addSongManager = addSongManager;
        this.title = new SimpleStringProperty("");
        this.error = new SimpleStringProperty("");
        this.fileName = new SimpleStringProperty("");
        albumTitles = new SimpleListProperty<>(FXCollections.observableArrayList());
    }

    public void chooseFile(File file) {
        try {
            songFile = file;
            fileName.set(file.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reset() {
        error.set("");
        title.set("");
        songFile = null;
        try {
            albumTitles.setAll(addSongManager.getAlbumTitles(loginManager.getUser()));//TODO
        } catch (Exception e) {
            error.set(e.getMessage());
        }

    }

    public void bindError(StringProperty property) {
        error.bindBidirectional(property);
    }

    public void bindList(ObjectProperty<ObservableList<String>> property) {
        property.bind(albumTitles);
    }

    public void bindTitle(StringProperty property) {
        property.bindBidirectional(title);
    }

    public void addSong(int index) {
        if (title.get().equals("")) {
            error.set("Title cannot be empty");
        } else if (fileName == null) {
            error.set("No file chosen");
        } else if (index < 0) {
            error.set("No album selected");
        } else {
            try {
                addSongManager.addSong(title.get(), songFile, index, loginManager.getUser());
                error.set("Song uploaded successfully");
            } catch (Exception ex) {
                error.set(ex.getMessage());
            }
        }

    }

    public void bindFileName(StringProperty property) {
        fileName.bindBidirectional(property);
    }
}

