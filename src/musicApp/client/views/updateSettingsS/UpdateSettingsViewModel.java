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
  public boolean updateUserData()
  {
    try
    {
      if (password.get().equals(""))
      {
        error.set("Password should not be null!");
        return false;
      }

      if (email.get().equals(""))
      {
        error.set("Email should not be null!");
        return false;
      }

      if (password.get().length() < 8)
      {
        error.set("Password must contain at least 8 characters!");
        return false;
      }

      if (noDigits())
      {
        error.set("Password must contain at least one digit!");
        return false;
      }

      if (noUpper())
      {
        error.set("Password must contain at least one uppercase!");
        return false;
      }

      if(emailNotValid())
      {
        error.set("Email is not valid!");
        return false;

      }
      //mainModel.getUpdateSettingsManager();
      return true;
    }
    catch (Exception e)
    {
      return false;
    }
  }

  private boolean emailNotValid()
  {
    return mainModel.getSignUpManager().emailNotValid(email.get());
  }

  public boolean noDigits()
  {
    return mainModel.getSignUpManager().noDigits(password.get());
  }

  public boolean noUpper()
  {
    return mainModel.getSignUpManager().noUpper(password.get());
  }
}
