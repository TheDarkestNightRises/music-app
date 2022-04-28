package musicApp.client.core;

import musicApp.client.views.chat.ChatViewModel;
import musicApp.client.views.log.LogViewModel;
import musicApp.client.views.login.LoginMainViewModel;
import musicApp.client.views.musicPlayer.MusicPlayerViewModel;
import musicApp.client.views.signup.SignUpViewModel;


public class ViewModelFactory {
    private ModelFactory modelFactory;
    private ChatViewModel chatViewModel;
    private LogViewModel logViewModel;
    private SignUpViewModel signUpViewModel;
    private LoginMainViewModel loginMainViewModel;
    private MusicPlayerViewModel musicPlayerViewModel;


    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public ChatViewModel getChatViewModel() {
        if (chatViewModel == null)
            chatViewModel = new ChatViewModel(modelFactory.getMainModel());
        return chatViewModel;
    }

    public LogViewModel getLogViewModel() {
        if (logViewModel == null)
            logViewModel = new LogViewModel(modelFactory.getMainModel());
        return logViewModel;
    }

    public SignUpViewModel getSignUpViewModel() {
        if (signUpViewModel == null)
            signUpViewModel = new SignUpViewModel(modelFactory.getMainModel());
        return signUpViewModel;
    }

  public LoginMainViewModel getLoginMainViewModel()
  {
      if (loginMainViewModel == null)
          loginMainViewModel = new LoginMainViewModel(modelFactory.getMainModel());
      return loginMainViewModel;
  }

    public MusicPlayerViewModel getMusicPlayerViewModel() {
        if (musicPlayerViewModel == null)
            musicPlayerViewModel = new MusicPlayerViewModel(modelFactory.getMainModel());
        return musicPlayerViewModel;
    }
}
