package musicApp.client.views.createPlaylist;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import musicApp.client.model.MainModel;

public class CreatePlaylistViewModel
{
  private final MainModel mainModel;
  private final StringProperty title;
  private final StringProperty description;
  private final StringProperty error;


  public CreatePlaylistViewModel(MainModel model)
  {
    this.mainModel = model;
    this.title = new SimpleStringProperty("");
    this.description = new SimpleStringProperty("");
    this.error = new SimpleStringProperty("");
  }
  public void createPlaylist()
  {
    try {
      mainModel.getCreatePlaylistManager();
    }
    catch (Exception e)
    {
      error.set(e.getMessage());
    }
  }
  public void bindTitle(StringProperty property)
  {
    title.bindBidirectional(property);
  }

  public void bindDescription(StringProperty property)
  {
    description.bindBidirectional(property);
  }

  public void bindError(StringProperty property)
  {
    error.bind(property);
  }
}
