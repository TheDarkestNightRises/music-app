package musicApp.client.model;

import musicApp.client.model.createPlaylist.CreatePlaylistManager;
import musicApp.client.model.chat.ChatManager;
import musicApp.client.model.followList.FollowListManager;
import musicApp.client.model.login.LogInManager;
import musicApp.client.model.mainMenu.MainMenuManager;
import musicApp.client.model.music.MusicManager;
import musicApp.client.model.profile.ProfileManager;
import musicApp.client.model.register.SignUpManager;
import musicApp.client.model.search.SearchManager;
import musicApp.client.model.updateSettings.UpdateSettingsManager;

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


    public MainModelImplementation(MusicManager musicManager, LogInManager logInManager, ChatManager chatManager,
        SignUpManager signUpManager, ProfileManager profileManager,
        UpdateSettingsManager updateSettingsManager, SearchManager searchManager, FollowListManager followListManager,
        MainMenuManager mainMenuManager,
        CreatePlaylistManager createPlaylistManager) {
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
}
