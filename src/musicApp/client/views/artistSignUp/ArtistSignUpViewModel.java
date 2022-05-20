package musicApp.client.views.artistSignUp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import musicApp.client.model.MainModel;

public class ArtistSignUpViewModel
{
  private final MainModel mainModel;
  private final StringProperty username;
  private final StringProperty password;
  private final StringProperty error;
  private final StringProperty email;
  private final StringProperty repeatPassword;

  public ArtistSignUpViewModel(MainModel model)
  {
    this.mainModel = model;
    this.username = new SimpleStringProperty("");
    this.password = new SimpleStringProperty("");
    this.error = new SimpleStringProperty("");
    this.email = new SimpleStringProperty("");
    this.repeatPassword = new SimpleStringProperty("");

  }

  public boolean createArtistUser()
  {
    try
    {
      registerValidation();
      mainModel.getSignUpManager().addArtist(username.get(), password.get(), email.get());
      reset();
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

  public boolean UsernameExists()
  {
    return mainModel.getSignUpManager().usernameExists(username.get());
  }

  public boolean noDigits()
  {
    return mainModel.getSignUpManager().noDigits(password.get());
  }

  public boolean noUpper()
  {
    return mainModel.getSignUpManager().noUpper(password.get());
  }

  public void bindUsername(StringProperty property)
  {
    username.bindBidirectional(property);
  }

  public void bindPassword(StringProperty property)
  {
    password.bindBidirectional(property);
  }

  public void bindError(StringProperty property)
  {
    error.bindBidirectional(property);
  }

  public void reset()
  {
    username.set("");
    password.set("");
    error.set("");
    repeatPassword.set("");
    email.set("");
  }

  public void bindRepeatPassword(StringProperty property)
  {
    repeatPassword.bindBidirectional(property);
  }

  public void bindEmail(StringProperty property)
  {
    email.bindBidirectional(property);
  }

  public boolean canCreateArtistUser()
  {
    return createArtistUser();
  }

  public boolean registerValidation()
  {
    if (UsernameExists())
    {
      error.set("Username already exists!");
      return false;
    }

    if (password.get().equals("") && username.get().equals("") && email.get().equals("") && repeatPassword.get().equals(""))
    {
      error.set("No data inserted!");
      return false;
    }

    if (username.get().equals(""))
    {
      error.set("Username should not be null!");
      return false;
    }

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

    if(!password.toString().equals(repeatPassword.toString()))
    {
      error.set("Password does not match!");
      password.set("");
      repeatPassword.set("");
      return false;
    }
    return true;
  }
}
