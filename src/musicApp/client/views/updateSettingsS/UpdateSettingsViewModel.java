package musicApp.client.views.updateSettingsS;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import musicApp.client.model.MainModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class UpdateSettingsViewModel
{
  private final MainModel mainModel;
  private final StringProperty password;
  private final StringProperty error;
  private final StringProperty email;
  private final StringProperty nickaname;
  private ObjectProperty<Image> profilePicture;

  public UpdateSettingsViewModel(MainModel mainModel)
  {
    this.mainModel = mainModel;
    password = new SimpleStringProperty("");
    error = new SimpleStringProperty("");
    email = new SimpleStringProperty("");
    nickaname = new SimpleStringProperty("");
    profilePicture = new SimpleObjectProperty<Image>();
  }
  public void bindPassword(StringProperty property)
  {
    password.bindBidirectional(property);
  }

  public void bindError(StringProperty property)
  {
    error.bindBidirectional(property);
  }
  public void bindEmail(StringProperty property)
  {
    email.bindBidirectional(property);
  }

  public void bindNickname(StringProperty property)
  {
    nickaname.bindBidirectional(property);
  }

  public void bindImage(ObjectProperty<Image> property)
  {
    profilePicture.bindBidirectional(property);
  }
  public void reset()
  {
    password.set(mainModel.getLogInManager().getUser().getPassword());
    error.set("");
    email.set(mainModel.getLogInManager().getUser().getEmail());
    nickaname.set(mainModel.getLogInManager().getUser().getNickname());
    InputStream stream = null;
    try
    {
      String imgPath = mainModel.getLogInManager().getUser().getProfile_picture();
      if(imgPath == null || imgPath.equals(""))
        imgPath = "default_pfp.jpg";
      stream = new FileInputStream("src/musicApp/server/serverData/ProfilePictures/" + imgPath);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    Image image = new Image(stream);
    profilePicture.setValue(image);//TODO: add link
    //System.out.println(mainModel.getLogInManager().getUser().getPassword());

  }
  public void submit()
  {

  }
  public void submitPassword()
  {

  }
  public void submitNickname()
  {

  }
  public void submitEmail()
  {

  }
}
