package musicApp.client.model;

import musicApp.client.model.addAlbum.AddAlbumManager;
import musicApp.client.model.addSong.AddSongManager;
import musicApp.client.model.addToPlaylist.AddToPlaylistManager;
import musicApp.client.model.createPlaylist.CreatePlaylistManager;
import musicApp.client.model.chat.ChatManager;
import musicApp.client.model.deleteSong.DeleteSongManager;
import musicApp.client.model.followList.FollowListManager;
import musicApp.client.model.login.LogInManager;
import musicApp.client.model.mainMenu.MainMenuManager;
import musicApp.client.model.music.MusicManager;
import musicApp.client.model.profile.ProfileManager;
import musicApp.client.model.register.SignUpManager;
import musicApp.client.model.removeAlbum.RemoveAlbumManager;
import musicApp.client.model.search.SearchManager;
import musicApp.client.model.updateSettings.UpdateSettingsManager;
import musicApp.database.album.AlbumDao;

public class MainModelImplementation implements MainModel{
    private MusicManager musicManager;
    private LogInManager logInManager;
    private ChatManager chatManager;
    private SignUpManager signUpManager;
    private ProfileManager profileManager;
    private UpdateSettingsManager updateSettingsManager;
    private SearchManager searchManager;
    private FollowListManager followListManager;
    private MainMenuManager mainMenuManager;
    private CreatePlaylistManager createPlaylistManager;
    private AddToPlaylistManager addToPlaylistManager;
    private AddAlbumManager addAlbumManager;
    private AddSongManager addSongManager;
    private DeleteSongManager deleteSongManager;
    private RemoveAlbumManager removeAlbumManager;


    public MainModelImplementation(MusicManager musicManager, LogInManager logInManager, ChatManager chatManager,
        SignUpManager signUpManager, ProfileManager profileManager,
        UpdateSettingsManager updateSettingsManager, SearchManager searchManager, FollowListManager followListManager,
        MainMenuManager mainMenuManager,
        CreatePlaylistManager createPlaylistManager, AddToPlaylistManager addToPlaylistManager, AddAlbumManager addAlbumManager,
        AddSongManager addSongManager, DeleteSongManager deleteSongManager,RemoveAlbumManager removeAlbumManager) {
        this.musicManager = musicManager;
        this.logInManager = logInManager;
        this.chatManager = chatManager;
        this.signUpManager = signUpManager;
        this.updateSettingsManager = updateSettingsManager;
        this.profileManager = profileManager;
        this.searchManager = searchManager;
        this.followListManager = followListManager;
        this.mainMenuManager = mainMenuManager;
        this.createPlaylistManager = createPlaylistManager;
        this.addToPlaylistManager = addToPlaylistManager;
        this.addAlbumManager = addAlbumManager;
        this.addSongManager = addSongManager;
        this.deleteSongManager = deleteSongManager;
        this.removeAlbumManager = removeAlbumManager;
    }

    public MusicManager getMusicPlayerManager() {
        return musicManager;
    }

    public LogInManager getLogInManager() {
        return logInManager;
    }

    public ChatManager getChatManager() {
        return chatManager;
    }

    @Override public SignUpManager getSignUpManager()
    {
        return signUpManager;
    }

    @Override
    public ProfileManager getProfileManager() {
        return profileManager;
    }

    @Override public UpdateSettingsManager getUpdateSettingsManager()
    {
        return updateSettingsManager;
    }

    @Override
    public SearchManager getSearchManager() {
        return searchManager;
    }

    @Override public FollowListManager getFollowListManager()
    {
        return followListManager;
    }

    @Override
    public MainMenuManager getMainMenuManager() {
        return mainMenuManager;
    }

    @Override public CreatePlaylistManager getCreatePlaylistManager()
    {
        return createPlaylistManager;
    }

    @Override public AddToPlaylistManager getAddToPlaylistManager()
    {
        return addToPlaylistManager;
    }

    @Override public AddAlbumManager getAddAlbumManager()
    {
        return addAlbumManager;
    }

    @Override public DeleteSongManager getDeleteSongManager()
    {
        return deleteSongManager;
    }

    @Override public AddSongManager getAddSongManager()
    {
        return addSongManager;
    }

    @Override public RemoveAlbumManager getRemoveAlbumManager()
    {
        return removeAlbumManager;
    }
}
