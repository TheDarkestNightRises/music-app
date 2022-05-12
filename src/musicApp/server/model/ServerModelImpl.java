package musicApp.server.model;

import musicApp.server.model.chat.ServerModelChat;
import musicApp.server.model.chat.ServerModelChatImpl;
import musicApp.server.model.login.ServerModelLogin;
import musicApp.server.model.login.ServerModelLoginImpl;
import musicApp.server.model.musicplayer.ServerModelMusic;
import musicApp.server.model.musicplayer.ServerModelMusicImpl;
import musicApp.server.model.profile.ServerModelProfile;
import musicApp.server.model.profile.ServerModelProfileImpl;
import musicApp.server.model.register.ServerModelSignUp;
import musicApp.server.model.register.ServerModelSignUpImpl;
import musicApp.server.model.updateSettings.ServerModelUpdateSettings;
import musicApp.server.model.updateSettings.ServerModelUpdateSettingsImpl;

import java.beans.PropertyChangeSupport;

public class ServerModelImpl implements ServerModel
{

  private final ServerModelProfile modelProfile;
  private ServerModelChat modelChat;
  private ServerModelLogin modelLogin;
  private ServerModelMusic modelMusic;
  private ServerModelSignUp modelSignUp;
  private ServerModelUpdateSettings modelUpdateSettings;

  private PropertyChangeSupport support;

  public ServerModelImpl()
  {
    this.modelChat = new ServerModelChatImpl();
    this.modelLogin = new ServerModelLoginImpl();
    this.modelMusic = new ServerModelMusicImpl();
    this.modelSignUp = new ServerModelSignUpImpl();
    this.modelProfile = new ServerModelProfileImpl();
    this.modelUpdateSettings = new ServerModelUpdateSettingsImpl();
  }

  public ServerModelChat getModelChat()
  {
    return modelChat;
  }

  public ServerModelLogin getModelLogin()
  {
    return modelLogin;
  }

  public ServerModelMusic getModelMusic()
  {
    return modelMusic;
  }

  public ServerModelSignUp getModelSignUp()
  {
    return modelSignUp;
  }

  public ServerModelProfile getModelProfile() {
    return modelProfile;
  }

  public ServerModelUpdateSettings getModelUpdateSettings()
  {
    return modelUpdateSettings;
  }
}
