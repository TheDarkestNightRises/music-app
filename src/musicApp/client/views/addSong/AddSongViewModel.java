package musicApp.client.views.addSong;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import musicApp.client.model.addSong.AddSongManager;
import musicApp.client.model.login.LogInManager;

import java.io.File;

/**
 * This is the Add Song View Model
 */
public class AddSongViewModel {
    private final StringProperty error;
    private final SimpleListProperty<String> albumTitles;
    private final LogInManager loginManager;
    private final AddSongManager addSongManager;
    private StringProperty title;
    private StringProperty fileName;
    private File songFile;

    /**
     * Constructor for AddSongVIewModel
     * initialises managers and properties
     * @param loginManager
     * @param addSongManager
     */
    public AddSongViewModel(LogInManager loginManager, AddSongManager addSongManager) {
        this.loginManager = loginManager;
        this.addSongManager = addSongManager;
        this.title = new SimpleStringProperty("");
        this.error = new SimpleStringProperty("");
        this.fileName = new SimpleStringProperty("");
        albumTitles = new SimpleListProperty<>(FXCollections.observableArrayList());
    }

    /**
     * sets songFile to file and fileName String to the name so that the name of the file can be displayed
     * @param file
     */
    public void chooseFile(File file) {
        try {
            songFile = file;
            fileName.set(file.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * resets the view model to the initial state
     */
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

    /**
     * bidirectional binding for error
     * @param property
     */
    public void bindError(StringProperty property) {
        error.bindBidirectional(property);
    }

    /**
     * binding for albumTitles list
     * @param property
     */
    public void bindList(ObjectProperty<ObservableList<String>> property) {
        property.bind(albumTitles);
    }

    /**
     * bidirectional binding for title
     * @param property
     */
    public void bindTitle(StringProperty property) {
        property.bindBidirectional(title);
    }

    /**
     * This method validates the title, the file, and if an album has been selected
     * @param index
     */
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

    /**
     * binding for fileNme
     * @param property
     */
    public void bindFileName(StringProperty property) {
        fileName.bindBidirectional(property);
    }
}

