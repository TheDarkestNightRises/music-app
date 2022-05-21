package musicApp.client.views.createPlaylist;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import musicApp.client.model.MainModel;
import musicApp.server.model.domainModel.User;

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
      mainModel.getCreatePlaylistManager().createPlaylist(title.get(), description.get(), mainModel.getLogInManager().getUser());
      error.set("Playlist created successfully");
    }
    catch (Exception e)
    {
      error.set(""+e.getMessage());
      e.printStackTrace();
    }
  }
  public User fetchUser() {
    return mainModel.getLogInManager().getUser();
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
    //error.bind(property);
    property.bind(error);
  }

  public StringProperty getErrorProperty()
  {
    return error;
  }
}
