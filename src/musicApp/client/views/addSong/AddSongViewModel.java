package musicApp.client.views.addSong;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import musicApp.client.model.MainModel;

import java.io.File;

public class AddSongViewModel
{
  private final MainModel mainModel;
  private final StringProperty error;
  private final SimpleListProperty<String> albumTitles;
  private StringProperty title;
  private StringProperty fileName;
  private File songFile;

  public AddSongViewModel(MainModel model)
  {
    this.mainModel = model;
    this.title = new SimpleStringProperty("");
    this.error = new SimpleStringProperty("");
    this.fileName = new SimpleStringProperty("");
    albumTitles = new SimpleListProperty<>(FXCollections.observableArrayList());

  }
  public void chooseFile(File file)
  {
    try
    {
      songFile = file;
      fileName.set(file.getName());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void reset()
  {
    error.set("");
    title.set("");
    songFile = null;
    try{
      albumTitles.setAll(mainModel.getAddSongManager().getAlbumTitles(mainModel.getLogInManager().getUser()));//TODO
    }catch (Exception e)
    {
      error.set(e.getMessage());
    }

  }

  public void bindError(StringProperty property)
  {
    error.bindBidirectional(property);
  }
  public void bindList(ObjectProperty<ObservableList<String>> property)
  {
    property.bind(albumTitles);
  }

  public void bindTitle(StringProperty property)
  {
    property.bindBidirectional(title);
  }

  public void addSong(int index)
  {
    if(title.get().equals(""))
    {
      error.set("Title cannot be empty");
    }
    else if(fileName == null)
    {
      error.set("No file chosen");
    }
    else if(index < 0)
    {
      error.set("No album selected");
    }
    else
    {
      try{
        mainModel.getAddSongManager().addSong(title.get(), songFile, index, mainModel.getLogInManager().getUser());
        error.set("SOng uploaded successfully");
      }catch (Exception ex){
        error.set(ex.getMessage());
      }
    }

  }

  public void bindFileName(StringProperty property)
  {
    fileName.bindBidirectional(property);
  }
}

