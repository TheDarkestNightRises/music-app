package musicApp.client.core;

import musicApp.client.views.addAlbum.AddAlbumViewModel;
import musicApp.client.views.addSong.AddSongViewModel;
import musicApp.client.views.addToPlaylist.AddToPlaylistViewModel;
import musicApp.client.views.album.AlbumViewModel;
import musicApp.client.views.artistProfile.ArtistProfileViewModel;
import musicApp.client.views.artistSignUp.ArtistSignUpViewModel;
import musicApp.client.views.cardForUserSearch.UserCardViewModel;
import musicApp.client.views.chat.ChatViewModel;
import musicApp.client.views.createPlaylist.CreatePlaylistViewModel;
import musicApp.client.views.followList.ContactItemViewModel;
import musicApp.client.views.followList.FollowListViewModel;
import musicApp.client.views.log.LogViewModel;
import musicApp.client.views.login.LoginMainViewModel;
import musicApp.client.views.mainMenu.MainMenuViewModel;
import musicApp.client.views.deleteSong.DeleteSongViewModel;
import musicApp.client.views.musicPlayer.MusicPlayerViewModel;
import musicApp.client.views.navigationBar.NavigationViewModel;
import musicApp.client.views.notification.NotificationViewModel;
import musicApp.client.views.profile.ProfileViewModel;
import musicApp.client.views.profileCard.ProfileCardViewModel;
import musicApp.client.views.removeAlbum.RemoveAlbumViewModel;
import musicApp.client.views.removePlaylist.RemovePlaylistViewModel;
import musicApp.client.views.search.SearchViewModel;
import musicApp.client.views.signup.SignUpViewModel;
import musicApp.client.views.single.SingleViewModel;
import musicApp.client.views.song.SongViewModel;
import musicApp.client.views.updateSettings.UpdateSettingsViewModel;

/**
 * The view model factory is responsible for creating the view models. It uses the factory design pattern
 */
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
    private DeleteSongViewModel deleteSongViewModel;
    private AddSongViewModel addSongViewModel;
    private RemoveAlbumViewModel removeAlbumViewModel;
    private RemovePlaylistViewModel removePlaylistViewModel;
    private AlbumViewModel albumViewModel;
    private SongViewModel songViewModel;
    private SingleViewModel singleViewModel;
    private NotificationViewModel notificationViewModel;
    private NavigationViewModel navigationViewModel;
    private UserCardViewModel userCardViewModel;
    private ContactItemViewModel contactItemViewModel;
    private ProfileCardViewModel profileCardViewModel;

    /**
     * This is the constructor for the ViewModelFactory
     * @param modelFactory because each viewModel has a reference to the model to delegate
     */
    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    /**
     *  This method returns the ChatViewModel (lazy instantiation)
     * @return ChatViewModel
     */
    public ChatViewModel getChatViewModel() {
        if (chatViewModel == null)
            chatViewModel = new ChatViewModel(modelFactory.getLoginManager(),modelFactory.getChatManager());
        return chatViewModel;
    }

    /**
     *  This method returns the LogViewModel (lazy instantiation)
     * @return LogViewModel
     */
    public LogViewModel getLogViewModel() {
        if (logViewModel == null)
            logViewModel = new LogViewModel(modelFactory.getChatManager());
        return logViewModel;
    }

    /**
     *  This method returns the SignUpViewModel (lazy instantiation)
     * @return SignUpViewModel
     */
    public SignUpViewModel getSignUpViewModel() {
        if (signUpViewModel == null)
            signUpViewModel = new SignUpViewModel(modelFactory.getSignUpManager());
        return signUpViewModel;
    }

    /**
     *  This method returns the LoginMainViewModel (lazy instantiation)
     * @return LoginMainViewModel
     */
    public LoginMainViewModel getLoginMainViewModel() {
        if (loginMainViewModel == null)
            loginMainViewModel = new LoginMainViewModel(modelFactory.getLoginManager());
        return loginMainViewModel;
    }

    /**
     *  This method returns the MusicPlayerViewModel (lazy instantiation)
     * @return MusicPlayerViewModel
     */
    public MusicPlayerViewModel getMusicPlayerViewModel() {
        if (musicPlayerViewModel == null)
            musicPlayerViewModel = new MusicPlayerViewModel(modelFactory.getLoginManager(),modelFactory.getMusicManager());
        return musicPlayerViewModel;
    }

    /**
     *  This method returns the ProfileViewModel (lazy instantiation)
     * @return ProfileViewModel
     */
    public ProfileViewModel getProfileViewModel() {
        if (profileViewModel == null)
            profileViewModel = new ProfileViewModel(modelFactory.getLoginManager(),modelFactory.getProfileManager());
        return profileViewModel;
    }

    /**
     *  This method returns the FollowListViewModel (lazy instantiation)
     * @return FollowListViewModel
     */
    public FollowListViewModel getFollowListViewModel() {
        if (followListViewModel == null)
            followListViewModel = new FollowListViewModel(modelFactory.getLoginManager(),modelFactory.getFollowListManager());
        return followListViewModel;
    }

    /**
     *  This method returns the UpdateSettingsViewModel (lazy instantiation)
     * @return UpdateSettingsViewModel
     */
    public UpdateSettingsViewModel getUpdateSettingsViewModel() {
        if (updateSettingsViewModel == null)
            updateSettingsViewModel = new UpdateSettingsViewModel(modelFactory.getLoginManager(),modelFactory.getProfileManager(),modelFactory.getUpdateSettingsManager(),modelFactory.getSignUpManager());
        return updateSettingsViewModel;
    }

    /**
     *  This method returns the SearchViewModel (lazy instantiation)
     * @return SearchViewModel
     */
    public SearchViewModel getSearchViewModel() {
        if (searchViewModel == null)
            searchViewModel = new SearchViewModel(modelFactory.getSearchManager());
        return searchViewModel;
    }

    /**
     *  This method returns the MainMenuViewModel (lazy instantiation)
     * @return MainMenuViewModel
     */

    public MainMenuViewModel getMainMenuViewModel() {
        if (mainMenuViewModel == null) {
            mainMenuViewModel = new MainMenuViewModel(modelFactory.getMainMenuManager(),modelFactory.getLoginManager());
        }
        return mainMenuViewModel;
    }

    /**
     *  This method returns the ArtistSignUpViewModel (lazy instantiation)
     * @return ArtistSignUpViewModel
     */
    public ArtistSignUpViewModel getArtistSignUpViewModel() {
        if (artistSignUpViewModel == null) {
            artistSignUpViewModel = new ArtistSignUpViewModel(modelFactory.getSignUpManager());
        }
        return artistSignUpViewModel;
    }

    /**
     *  This method returns the CreatePlaylistViewModel (lazy instantiation)
     * @return CreatePlaylistViewModel
     */
    public CreatePlaylistViewModel getCreatePlaylistViewModel() {
        if (createPlaylistViewModel == null)
            createPlaylistViewModel = new CreatePlaylistViewModel(
                    modelFactory.getLoginManager(),modelFactory.getCreatePlaylistManager());
        return createPlaylistViewModel;
    }

    /**
     *  This method returns the AddToPlaylistViewModel (lazy instantiation)
     * @return AddToPlaylistViewModel
     */
    public AddToPlaylistViewModel getAddToPlaylistViewModel() {
        if (addToPlaylistViewModel == null)
            addToPlaylistViewModel = new AddToPlaylistViewModel(
                    modelFactory.getAddToPlaylistManager(), modelFactory.getProfileManager(), modelFactory.getLoginManager());
        return addToPlaylistViewModel;
    }


    /**
     *  This method returns the ArtistProfileViewModel (lazy instantiation)
     * @return ArtistProfileViewModel
     */
    public ArtistProfileViewModel getArtistProfileViewModel() {
        if (artistProfileViewModel == null) {
            artistProfileViewModel = new ArtistProfileViewModel(modelFactory.getProfileManager(),modelFactory.getLoginManager());
        }
        return artistProfileViewModel;
    }

    /**
     *  This method returns the AddAlbumViewModel (lazy instantiation)
     * @return AddAlbumViewModel
     */
    public AddAlbumViewModel getAddAlbumViewModel() {
        if (addAlbumViewModel == null) {
            addAlbumViewModel = new AddAlbumViewModel(modelFactory.getAddAlbumManager(), modelFactory.getLoginManager());
        }
        return addAlbumViewModel;
    }

    /**
     *  This method returns the DeleteSongViewModel (lazy instantiation)
     * @return DeleteSongViewModel
     */
    public DeleteSongViewModel getDeleteSongViewModel() {
        if (deleteSongViewModel == null) {
            deleteSongViewModel = new DeleteSongViewModel(modelFactory.getLoginManager(),modelFactory.getDeleteSongManager());
        }
        return deleteSongViewModel;
    }

    /**
     *  This method returns the AddSongViewModel (lazy instantiation)
     * @return AddSongViewModel
     */
    public AddSongViewModel getAddSongViewModel() {
        if (addSongViewModel == null) {
            addSongViewModel = new AddSongViewModel(modelFactory.getLoginManager(), modelFactory.getAddSongManager());
        }
        return addSongViewModel;
    }

    /**
     *  This method returns the RemoveAlbumViewModel (lazy instantiation)
     * @return RemoveAlbumViewModel
     */
    public RemoveAlbumViewModel getRemoveAlbumViewModel() {
        if (removeAlbumViewModel == null) {
            removeAlbumViewModel = new RemoveAlbumViewModel(modelFactory.getProfileManager(),modelFactory.getLoginManager(),modelFactory.getRemoveAlbumManager());
        }
        return removeAlbumViewModel;
    }

    /**
     *  This method returns the RemovePlaylistViewModel (lazy instantiation)
     * @return RemovePlaylistViewModel
     */
    public RemovePlaylistViewModel getRemovePlaylistViewModel() {
        if (removePlaylistViewModel == null) {
            removePlaylistViewModel = new RemovePlaylistViewModel(modelFactory.getProfileManager(),modelFactory.getRemovePlaylistManager(),modelFactory.getLoginManager());
        }
        return removePlaylistViewModel;
    }

    /**
     *  This method returns the AlbumViewModel (lazy instantiation)
     * @return AlbumViewModel
     */
    public AlbumViewModel getAlbumViewModel() {
        albumViewModel = new AlbumViewModel(modelFactory.getMusicManager());
        return albumViewModel;
    }

    /**
     *  This method returns the SongViewModel.It doesn't return the cached in song view model
     *  because there are multiple song views.
     * @return SongViewModel
     */
    public SongViewModel getSongViewModel() {
        songViewModel = new SongViewModel(modelFactory.getMusicManager());
        return songViewModel;
    }

    /**
     *  This method returns the SingleViewModel. It doesn't return the cached in song view model
     * because there are multiple single views.
     * @return SingleViewModel
     */
    public SingleViewModel getSingleViewModel() {
        singleViewModel = new SingleViewModel(modelFactory.getMusicManager());
        return singleViewModel;
    }


    /**
     *  This method returns the UserCardViewModel . It doesn't return the cached in song view model
     *  because there are multiple single views.
     * @return UserCardViewModel
     */
    public UserCardViewModel getUserCardViewModel() {
        userCardViewModel = new UserCardViewModel(modelFactory.getProfileManager());
        return userCardViewModel;
    }

    /**
     *  This method returns the NavigationViewModel (lazy instantiation)
     * @return NavigationViewModel
     */
    public NavigationViewModel getNavigationViewModel() {
        if (navigationViewModel == null) {
            navigationViewModel = new NavigationViewModel(modelFactory.getLoginManager(),modelFactory.getProfileManager());
        }
        return navigationViewModel;
    }

    /**
     *  This method returns the ContactItemViewModel (lazy instantiation)
     * @return ContactItemViewModel
     */
    public ContactItemViewModel getContactItemViewModel() {
        contactItemViewModel = new ContactItemViewModel(modelFactory.getProfileManager(),modelFactory.getFollowListManager());
        return contactItemViewModel;
    }


    /**
     *  This method returns the ProfileCardViewModel (lazy instantiation)
     * @return ProfileCardViewModel
     */
    public ProfileCardViewModel getProfileCardViewModel() {
        if (profileCardViewModel == null) {
            profileCardViewModel = new ProfileCardViewModel(modelFactory.getProfileManager(),modelFactory.getLoginManager());
        }
        return profileCardViewModel;
    }
}

