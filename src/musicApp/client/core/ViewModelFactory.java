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

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public ChatViewModel getChatViewModel() {
        if (chatViewModel == null)
            chatViewModel = new ChatViewModel(modelFactory.getLoginManager(),modelFactory.getChatManager());
        return chatViewModel;
    }

    public LogViewModel getLogViewModel() {
        if (logViewModel == null)
            logViewModel = new LogViewModel(modelFactory.getChatManager());
        return logViewModel;
    }

    public SignUpViewModel getSignUpViewModel() {
        if (signUpViewModel == null)
            signUpViewModel = new SignUpViewModel(modelFactory.getMainModel());
        return signUpViewModel;
    }

    public LoginMainViewModel getLoginMainViewModel() {
        if (loginMainViewModel == null)
            loginMainViewModel = new LoginMainViewModel(modelFactory.getLoginManager());
        return loginMainViewModel;
    }

    public MusicPlayerViewModel getMusicPlayerViewModel() {
        if (musicPlayerViewModel == null)
            musicPlayerViewModel = new MusicPlayerViewModel(modelFactory.getMainModel());
        return musicPlayerViewModel;
    }

    public ProfileViewModel getProfileViewModel() {
        if (profileViewModel == null)
            profileViewModel = new ProfileViewModel(modelFactory.getMainModel());
        return profileViewModel;
    }

    public FollowListViewModel getFollowListViewModel() {
        if (followListViewModel == null)
            followListViewModel = new FollowListViewModel(modelFactory.getLoginManager(),modelFactory.getFollowListManager());
        return followListViewModel;
    }

    public UpdateSettingsViewModel getUpdateSettingsViewModel() {
        if (updateSettingsViewModel == null)
            updateSettingsViewModel = new UpdateSettingsViewModel(modelFactory.getMainModel());
        return updateSettingsViewModel;
    }

    public SearchViewModel getSearchViewModel() {
        if (searchViewModel == null)
            searchViewModel = new SearchViewModel(modelFactory.getMainModel());
        return searchViewModel;
    }

    public MainMenuViewModel getMainMenuViewModel() {
        if (mainMenuViewModel == null) {
            mainMenuViewModel = new MainMenuViewModel(modelFactory.getMainMenuManager(),modelFactory.getLoginManager());
        }
        return mainMenuViewModel;
    }

    public ArtistSignUpViewModel getArtistSignUpViewModel() {
        if (artistSignUpViewModel == null) {
            artistSignUpViewModel = new ArtistSignUpViewModel(modelFactory.getSignUpManager());
        }
        return artistSignUpViewModel;
    }

    public CreatePlaylistViewModel getCreatePlaylistViewModel() {
        if (createPlaylistViewModel == null)
            createPlaylistViewModel = new CreatePlaylistViewModel(
                    modelFactory.getLoginManager(),modelFactory.getCreatePlaylistManager());
        return createPlaylistViewModel;
    }

    public AddToPlaylistViewModel getAddToPlaylistViewModel() {
        if (addToPlaylistViewModel == null)
            addToPlaylistViewModel = new AddToPlaylistViewModel(
                    modelFactory.getAddToPlaylistManager(), modelFactory.getProfileManager(), modelFactory.getLoginManager());
        return addToPlaylistViewModel;
    }

    public ArtistProfileViewModel getArtistProfileViewModel() {
        if (artistProfileViewModel == null) {
            artistProfileViewModel = new ArtistProfileViewModel(modelFactory.getProfileManager(),modelFactory.getLoginManager());
        }
        return artistProfileViewModel;
    }

    public AddAlbumViewModel getAddAlbumViewModel() {
        if (addAlbumViewModel == null) {
            addAlbumViewModel = new AddAlbumViewModel(modelFactory.getAddAlbumManager(), modelFactory.getLoginManager());
        }
        return addAlbumViewModel;
    }

    public DeleteSongViewModel getDeleteSongViewModel() {
        if (deleteSongViewModel == null) {
            deleteSongViewModel = new DeleteSongViewModel(modelFactory.getLoginManager(),modelFactory.getDeleteSongManager());
        }
        return deleteSongViewModel;
    }

    public AddSongViewModel getAddSongViewModel() {
        if (addSongViewModel == null) {
            addSongViewModel = new AddSongViewModel(modelFactory.getLoginManager(), modelFactory.getAddSongManager());
        }
        return addSongViewModel;
    }

    public RemoveAlbumViewModel getRemoveAlbumViewModel() {
        if (removeAlbumViewModel == null) {
            removeAlbumViewModel = new RemoveAlbumViewModel(modelFactory.getMainModel());
        }
        return removeAlbumViewModel;
    }

    public RemovePlaylistViewModel getRemovePlaylistViewModel() {
        if (removePlaylistViewModel == null) {
            removePlaylistViewModel = new RemovePlaylistViewModel(modelFactory.getMainModel());
        }
        return removePlaylistViewModel;
    }

    public AlbumViewModel getAlbumViewModel() {
        albumViewModel = new AlbumViewModel(modelFactory.getMusicManager());
        return albumViewModel;
    }

    public SongViewModel getSongViewModel() {
        songViewModel = new SongViewModel(modelFactory.getMainModel());
        return songViewModel;
    }

    public SingleViewModel getSingleViewModel() {
        singleViewModel = new SingleViewModel(modelFactory.getMainModel());
        return singleViewModel;
    }

    public UserCardViewModel getUserCardViewModel() {
        userCardViewModel = new UserCardViewModel(modelFactory.getProfileManager());
        return userCardViewModel;
    }

    public NavigationViewModel getNavigationViewModel() {
        if (navigationViewModel == null) {
            navigationViewModel = new NavigationViewModel(modelFactory.getMainModel());
        }
        return navigationViewModel;
    }

    public ContactItemViewModel getContactItemViewModel() {
        contactItemViewModel = new ContactItemViewModel(modelFactory.getProfileManager(),modelFactory.getFollowListManager());
        return contactItemViewModel;
    }

    public ProfileCardViewModel getProfileCardViewModel() {
        if (profileCardViewModel == null) {
            profileCardViewModel = new ProfileCardViewModel(modelFactory.getMainModel());
        }
        return profileCardViewModel;
    }
}

