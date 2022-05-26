package musicApp.client.views.addSong;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import musicApp.client.model.MainModel;

public class AddSongViewModel
{
  private final MainModel mainModel;
  private final StringProperty error;
  private final SimpleListProperty<String> albumTitles;
  private StringProperty title;

  public AddSongViewModel(MainModel model)
  {
    this.mainModel = model;
    this.title = new SimpleStringProperty("");
    this.error = new SimpleStringProperty("");
    albumTitles = new SimpleListProperty<>(FXCollections.observableArrayList());

  }

  public void reset()
  {
    error.set("");
    title.set("");
    //albumTitles.setAll(getArtistSongsTitles(mainModel.getLogInManager().getUser()));//TODO
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
}
