package musicApp.client.core;

import musicApp.client.views.addAlbum.AddAlbumViewModel;
import musicApp.client.views.addToPlaylist.AddToPlaylistViewModel;
import musicApp.client.views.artistProfile.ArtistProfileViewModel;
import musicApp.client.views.artistSignUp.ArtistSignUpViewModel;
import musicApp.client.views.chat.ChatViewModel;
import musicApp.client.views.createPlaylist.CreatePlaylistViewModel;
import musicApp.client.views.followList.FollowListViewModel;
import musicApp.client.views.log.LogViewModel;
import musicApp.client.views.login.LoginMainViewModel;
import musicApp.client.views.mainMenu.MainMenuViewModel;
import musicApp.client.views.musicPlayer.MusicPlayerViewModel;
import musicApp.client.views.profile.ProfileViewModel;
import musicApp.client.views.search.SearchViewModel;
import musicApp.client.views.signup.SignUpViewModel;
import musicApp.client.views.updateSettings.UpdateSettingsViewModel;

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
    private CreatePlaylistViewModel createPlaylistViewModel;
    private AddToPlaylistViewModel addToPlaylistViewModel;
    private ArtistProfileViewModel artistProfileViewModel;
    private AddAlbumViewModel addAlbumViewModel;

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

  public CreatePlaylistViewModel getCreatePlaylistViewModel()
  {
    if(createPlaylistViewModel == null)
      createPlaylistViewModel = new CreatePlaylistViewModel(
          modelFactory.getMainModel());
    return createPlaylistViewModel;
  }

  public AddToPlaylistViewModel getAddToPlaylistViewModel()
  {
    if(addToPlaylistViewModel == null)
      addToPlaylistViewModel = new AddToPlaylistViewModel(
          modelFactory.getMainModel());
    return addToPlaylistViewModel;
  }

  public ArtistProfileViewModel getArtistProfileViewModel()
  {
    if (artistProfileViewModel == null) {
      artistProfileViewModel = new ArtistProfileViewModel(modelFactory.getMainModel());
    }
    return artistProfileViewModel;
  }

  public AddAlbumViewModel getAddAlbumViewModel()
  {
    if (addAlbumViewModel == null) {
      addAlbumViewModel = new AddAlbumViewModel(modelFactory.getMainModel());
    }
    return addAlbumViewModel;
  }
}

