package musicApp.client.views.updateSettings;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import musicApp.client.model.login.LogInManager;
import musicApp.client.model.profile.ProfileManager;
import musicApp.client.model.register.SignUpManager;
import musicApp.client.model.updateSettings.UpdateSettingsManager;
import musicApp.server.model.domainModel.User;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;

public class UpdateSettingsViewModel
{
  private final StringProperty password;
  private final StringProperty error;
  private final StringProperty error1;
  private final StringProperty email;
  private final StringProperty nickaname;
  private StringProperty description;
  private final ProfileManager profileManager;
  private final LogInManager logInManager;
  private final UpdateSettingsManager updateSettingsManager;
  private final SignUpManager signUpManager;
  private ObjectProperty<Image> profilePicture;
  private FileInputStream tempImgStream;
  private File imgFile;

  /**
   * constructor that initialises the view handler, the view model, the managers and the properties
   * @param logInManager
   * @param profileManager
   * @param updateSettingsManager
   * @param signUpManager
   */
  public UpdateSettingsViewModel(LogInManager logInManager, ProfileManager profileManager,
                                 UpdateSettingsManager updateSettingsManager, SignUpManager signUpManager)
  {
    this.profileManager = profileManager;
    this.logInManager = logInManager;
    this.updateSettingsManager = updateSettingsManager;
    this.signUpManager = signUpManager;
    password = new SimpleStringProperty("");
    error = new SimpleStringProperty("");
    error1 = new SimpleStringProperty("");
    email = new SimpleStringProperty("");
    nickaname = new SimpleStringProperty("");
    description = new SimpleStringProperty("");
    profilePicture = new SimpleObjectProperty<Image>();
    tempImgStream = null;
    imgFile = null;
  }

  /**
   * resets the view with current user info and profile picture
   */

  public void reset()
  {
    password.set(logInManager.getUser().getPassword());
    error.set("");
    email.set(logInManager.getUser().getEmail());
    nickaname.set(logInManager.getUser().getNickname());
    description.set(logInManager.getUser().getDescription());
    tempImgStream = null;
    imgFile = null;

    try
    {

      Image image = new Image(new ByteArrayInputStream(profileManager.fetchProfilePicture(logInManager.getUser().getProfile_picture())));
      profilePicture.setValue(image);//TODO: add link
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * validates user info, updates cached logged in user , delegates updating user in server to Update Settings Manager
   */
  public void submit()
  {
    if(validateUserData())
    {
      try
      {
        updateSettingsManager
            .updateUserInfo(logInManager.getUser().getUsername(), password.get(), email.get(),
                nickaname.get(), description.get());
        logInManager.getUser().setPassword(password.get());
        logInManager.getUser().setEmail(email.get());
        logInManager.getUser().setNickname(nickaname.get());
        logInManager.getUser().setDescription(description.get());
        error.set("Settings changed successfully");
      }
      catch (Exception e)
      {
        error.set(e.getMessage());
      }
    }
  }

  /**
   * sets the image property of profile picture to the picture from the picture file, and sets imgFile to pictureFile
   * @param pictureFile
   */
  public void choosePicture(File pictureFile)
  {
    try
    {
      error1.set("");
      tempImgStream = new FileInputStream(pictureFile);
      profilePicture.setValue(new Image(tempImgStream));
      imgFile = pictureFile;
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * converts the image to byte array and delegates updating the profile picture to UpdateSettingsManager
   * sets appropriate error if the image cannot be updated
   */
  public void uploadPicture()
  {
    if(tempImgStream != null)
    {
      try
      {
        BufferedImage image = ImageIO.read(imgFile);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ImageIO.write((RenderedImage) image, "png", byteArrayOutputStream);
        String uploaded = updateSettingsManager.uploadImage(logInManager.getUser().getUsername(), byteArrayOutputStream.toByteArray());
        if(uploaded != null)
        {
        logInManager.getUser().setProfile_picture(uploaded);
        error1.set("Avatar changed successfully");}
        else
        error1.set("Could not upload image");
      }
      catch (IOException e)
      {
        e.printStackTrace();
        error1.set("Could not upload image");
      }

    }
  }

  /**
   * validates user data
   * sets appropriate error if data is no valid
   * @return true if password, email, nickaname are valid, false otherwise
   */
  public boolean validateUserData()
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
      if(nicknameNotValid())
      {
        error.set("Nickname cannot be empty");
      }
      return true;
    }
    catch (Exception e)
    {
      return false;
    }
  }

  private boolean nicknameNotValid()
  {
    return updateSettingsManager.nicknameNotValid(nickaname.get());
  }

  private boolean emailNotValid()
  {
    return signUpManager.emailNotValid(email.get());
  }

  public boolean noDigits()
  {
    return signUpManager.noDigits(password.get());
  }

  public boolean noUpper()
  {
    return signUpManager.noUpper(password.get());
  }
  public void bindPassword(StringProperty property)
  {
    password.bindBidirectional(property);
  }

  public void bindError(StringProperty property)
  {
    error.bindBidirectional(property);
  }

  public void bindError1(StringProperty property)
  {
    error1.bindBidirectional(property);
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

  public void bindDescription(StringProperty property)
  {
    description.bindBidirectional(property);
  }
}
