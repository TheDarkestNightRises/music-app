package musicApp.server.model;

import musicApp.client.model.User;
import musicApp.server.model.chat.ServerModelChat;
import musicApp.server.model.chat.ServerModelChatImpl;
import musicApp.server.model.chat.log.DefaultLog;
import musicApp.server.model.login.ServerModelLogin;
import musicApp.server.model.login.ServerModelLoginImpl;
import musicApp.server.model.musicplayer.ServerModelMusic;
import musicApp.server.model.musicplayer.ServerModelMusicImpl;
import musicApp.server.model.register.ServerModelSignUp;
import musicApp.server.model.register.ServerModelSignUpImpl;
import musicApp.shared.LogEntry;
import musicApp.shared.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerModelImpl implements ServerModel
{

  private ServerModelChat modelChat;
  private ServerModelLogin modelLogin;
  private ServerModelMusic modelMusic;
  private ServerModelSignUp modelSignUp;

  private PropertyChangeSupport support;

  public ServerModelImpl()
  {
    this.modelChat = new ServerModelChatImpl();
    this.modelLogin = new ServerModelLoginImpl();
    this.modelMusic = new ServerModelMusicImpl();
    this.modelSignUp = new ServerModelSignUpImpl();

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

}
