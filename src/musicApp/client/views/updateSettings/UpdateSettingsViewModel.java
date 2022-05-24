package musicApp.client.views.updateSettings;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import musicApp.client.model.MainModel;
import musicApp.server.model.domainModel.User;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;

public class UpdateSettingsViewModel
{
  private final MainModel mainModel;
  private final StringProperty password;
  private final StringProperty error;
  private final StringProperty email;
  private final StringProperty nickaname;
  private ObjectProperty<Image> profilePicture;
  private FileInputStream tempImgStream;
  private File imgFile;

  public UpdateSettingsViewModel(MainModel mainModel)
  {
    this.mainModel = mainModel;
    password = new SimpleStringProperty("");
    error = new SimpleStringProperty("");
    email = new SimpleStringProperty("");
    nickaname = new SimpleStringProperty("");
    profilePicture = new SimpleObjectProperty<Image>();
    tempImgStream = null;
    imgFile = null;
  }


  public void reset()
  {
    password.set(mainModel.getLogInManager().getUser().getPassword());
    error.set("");
    email.set(mainModel.getLogInManager().getUser().getEmail());
    nickaname.set(mainModel.getLogInManager().getUser().getNickname());
    tempImgStream = null;
    imgFile = null;
    //InputStream stream = null;
    try
    {
//      String imgPath = mainModel.getLogInManager().getUser().getProfile_picture();
//      if(imgPath == null || imgPath.equals(""))
//        imgPath = "default_pfp.jpg";
//      stream = new FileInputStream("src/musicApp/server/serverData/ProfilePictures/" + imgPath);
//      Image image = new Image(stream);
      Image image = new Image(new ByteArrayInputStream(mainModel.getProfileManager().fetchProfilePicture(mainModel.getLogInManager().getUser().getProfile_picture())));
      profilePicture.setValue(image);//TODO: add link
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  public void submit()
  {
    if(validateUserData())
    {
      try
      {
        mainModel.getUpdateSettingsManager()
            .updateUserInfo(mainModel.getLogInManager().getUser().getUsername(), password.get(), email.get(),
                nickaname.get());
        mainModel.getLogInManager().getUser().setPassword(password.get());
        mainModel.getLogInManager().getUser().setEmail(email.get());
        mainModel.getLogInManager().getUser().setNickname(nickaname.get());
        error.set("Settings changed successfully");
      }
      catch (Exception e)
      {
        error.set(e.getMessage());
      }
    }
  }
  public void choosePicture(File pictureFile)
  {
    try
    {
      tempImgStream = new FileInputStream(pictureFile);
      profilePicture.setValue(new Image(tempImgStream));
      imgFile = pictureFile;
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
  }
  public void uploadPicture()
  {
    if(tempImgStream != null)
    {
      try
      {
        BufferedImage image = ImageIO.read(imgFile);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ImageIO.write((RenderedImage) image, "png", byteArrayOutputStream);
        String uploaded = mainModel.getUpdateSettingsManager().uploadImage(mainModel.getLogInManager().getUser().getUsername(), byteArrayOutputStream.toByteArray());
        //String uploaded = mainModel.getUpdateSettingsManager().uploadImage(mainModel.getLogInManager().getUser().getUsername(), tempImgStream.readAllBytes());
        if(uploaded != null)
        mainModel.getLogInManager().getUser().setProfile_picture(uploaded);
        else 
        error.set("Could not upload image");
      }
      catch (IOException e)
      {
        e.printStackTrace();
        error.set("Could not upload image");
      }

    }
  }
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


      //mainModel.getLogInManager().updateUserInfo(password.get(), email.get(), nickaname.get());
      return true;
    }
    catch (Exception e)
    {
      return false;
    }
  }

  private boolean nicknameNotValid()
  {
    return mainModel.getUpdateSettingsManager().nicknameNotValid(nickaname.get());
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

  public User fetchUser()
  {
    return mainModel.getLogInManager().getUser();
  }
}
