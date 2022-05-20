package musicApp.client.core;

import musicApp.client.views.artistSignUp.ArtistSignUpViewModel;
import musicApp.client.views.chat.ChatViewModel;
import musicApp.client.views.followList.FollowListViewModel;
import musicApp.client.views.log.LogViewModel;
import musicApp.client.views.login.LoginMainViewModel;
import musicApp.client.views.mainMenu.MainMenuViewModel;
import musicApp.client.views.musicPlayer.MusicPlayerViewModel;
import musicApp.client.views.profile.ProfileViewModel;
import musicApp.client.views.search.SearchViewModel;
import musicApp.client.views.signup.SignUpViewModel;
import musicApp.client.views.updateSettingsS.UpdateSettingsViewModel;

public class ViewModelFactory {
    private ModelFactory modelFactory;
    private ChatViewModel chatViewModel;
    private LogViewModel logViewModel;
    private SignUpViewModel signUpViewModel;
    private LoginMainViewModel loginMainViewModel;
    private MusicPlayerViewModel musicPlayerViewModel;
    private ProfileViewModel profileViewModel;
    private FollowListViewModel followListViewModel;
    private UpdateSettingsViewModel updateSettingsViewModel;
    private SearchViewModel searchViewModel;
    private MainMenuViewModel mainMenuViewModel;
    private ArtistSignUpViewModel artistSignUpViewModel;

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

    public ProfileViewModel getProfileViewModel() {
        if ( profileViewModel == null)
            profileViewModel = new ProfileViewModel(modelFactory.getMainModel());
        return profileViewModel;
    }

    public FollowListViewModel getFollowListViewModel()
    {
      if ( followListViewModel == null)
        followListViewModel = new FollowListViewModel(modelFactory.getMainModel());
      return followListViewModel;
    }

  public UpdateSettingsViewModel getUpdateSettingsViewModel()
  {
    if ( updateSettingsViewModel == null)
      updateSettingsViewModel = new UpdateSettingsViewModel(modelFactory.getMainModel());
    return updateSettingsViewModel;
  }

    public SearchViewModel getSearchViewModel() {
        if ( searchViewModel == null)
            searchViewModel = new SearchViewModel(modelFactory.getMainModel());
        return searchViewModel;
    }

    public MainMenuViewModel getMainMenuViewModel() {
        if (mainMenuViewModel == null) {
            mainMenuViewModel = new MainMenuViewModel(modelFactory.getMainModel());
        }
        return mainMenuViewModel;
    }

  public ArtistSignUpViewModel getArtistSignUpViewModel()
  {
    if (artistSignUpViewModel == null) {
      artistSignUpViewModel = new ArtistSignUpViewModel(modelFactory.getMainModel());
    }
    return artistSignUpViewModel;
  }
}

