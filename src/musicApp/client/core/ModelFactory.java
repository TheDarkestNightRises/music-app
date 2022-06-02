package musicApp.client.core;

import musicApp.client.model.addAlbum.AddAlbumManager;
import musicApp.client.model.addAlbum.AddAlbumManagerImplementation;
import musicApp.client.model.addSong.AddSongManager;
import musicApp.client.model.addSong.AddSongManagerImpl;
import musicApp.client.model.addToPlaylist.AddToPlaylistImplementation;
import musicApp.client.model.addToPlaylist.AddToPlaylistManager;
import musicApp.client.model.createPlaylist.CreatePlayListManagerImplementation;
import musicApp.client.model.createPlaylist.CreatePlaylistManager;
import musicApp.client.model.chat.ChatManager;
import musicApp.client.model.chat.ChatManagerImplementation;
import musicApp.client.model.deleteSong.DeleteSongManager;
import musicApp.client.model.deleteSong.DeleteSongManagerImplementation;
import musicApp.client.model.followList.FollowListManager;
import musicApp.client.model.followList.FollowListManagerImplementation;
import musicApp.client.model.login.LogInManager;
import musicApp.client.model.login.LoginManagerImplementation;
import musicApp.client.model.mainMenu.MainMenuManager;
import musicApp.client.model.mainMenu.MainMenuManagerImplementation;
import musicApp.client.model.music.MusicManager;
import musicApp.client.model.music.MusicManagerImplementation;
import musicApp.client.model.profile.ProfileManager;
import musicApp.client.model.profile.ProfileManagerImplementation;
import musicApp.client.model.register.SignUpManager;
import musicApp.client.model.register.SignUpManagerImplementation;
import musicApp.client.model.removeAlbum.RemoveAlbumManager;
import musicApp.client.model.removeAlbum.RemoveAlbumManagerImplementation;
import musicApp.client.model.removePlaylist.RemovePlaylistManager;
import musicApp.client.model.removePlaylist.RemovePlaylistManagerImplementation;
import musicApp.client.model.search.SearchManager;
import musicApp.client.model.search.SearchManagerImplementation;
import musicApp.client.model.updateSettings.UpdateSettingsManager;
import musicApp.client.model.updateSettings.UpdateSettingsManagerImplementation;

/**
 * The model factory is responsible for creating the models. It is a creational design pattern(factory)
 */
public class ModelFactory {
    private ChatManager chatManager;
    private LogInManager logInManager;
    private SignUpManager signUpManager;
    private MusicManager musicManager;
    private ProfileManager profileManager;
    private UpdateSettingsManager updateSettingsManager;
    private SearchManager searchManager;
    private FollowListManager followListManager;
    private CreatePlaylistManager createPlaylistManager;
    private AddToPlaylistManager addToPlaylistManager;
    private MainMenuManager mainMenuManager;
    private AddAlbumManager addAlbumManager;
    private AddSongManager addSongManager;
    private DeleteSongManager deleteSongManager;
    private ClientFactory clientFactory;
    private RemoveAlbumManager removeAlbumManager;
    private RemovePlaylistManager removePlaylistManager;


    /**
     * This is the constructor for the model factory. It takes the client factory as paramater because the model
     * has a association to the client
     * @param clientFactory a factory that returns the main client facade
     */
    public ModelFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    /**
     *  This method returns the AddToPlaylistManager (lazy instantiation)
     * @return AddToPlaylistManager
     */
    public AddToPlaylistManager getAddToPlaylistManager() {
        if (addToPlaylistManager == null)
            addToPlaylistManager = new AddToPlaylistImplementation(clientFactory.getClient());
        return addToPlaylistManager;
    }

    /**
     *  This method returns the ChatManager (lazy instantiation)
     * @return ChatManager
     */
    public ChatManager getChatManager() {
        if (chatManager == null)
            chatManager = new ChatManagerImplementation(clientFactory.getClient());
        return chatManager;
    }

    /**
     *  This method returns the FollowListManager (lazy instantiation)
     * @return FollowListManager
     */
    public FollowListManager getFollowListManager() {
        if (followListManager == null)
            followListManager = new FollowListManagerImplementation(clientFactory.getClient());
        return followListManager;
    }

    /**
     *  This method returns the LogInManager (lazy instantiation)
     * @return LogInManager
     */
    public LogInManager getLoginManager() {
        if (logInManager == null)
            logInManager = new LoginManagerImplementation(clientFactory.getClient());
        return logInManager;
    }

    /**
     *  This method returns the MusicManager (lazy instantiation)
     * @return MusicManager
     */
    public MusicManager getMusicManager() {
        if (musicManager == null)
            musicManager = new MusicManagerImplementation(clientFactory.getClient());
        return musicManager;
    }

    /**
     *  This method returns the SignUpManager (lazy instantiation)
     * @return SignUpManager
     */
    public SignUpManager getSignUpManager() {
        if (signUpManager == null)
            signUpManager = new SignUpManagerImplementation(clientFactory.getClient());
        return signUpManager;
    }

    /**
     *  This method returns the ProfileManager (lazy instantiation)
     * @return ProfileManager
     */
    public ProfileManager getProfileManager() {
        if (profileManager == null)
            profileManager = new ProfileManagerImplementation(clientFactory.getClient());
        return profileManager;
    }

    /**
     *  This method returns the UpdateSettingsManager (lazy instantiation)
     * @return UpdateSettingsManager
     */
    public UpdateSettingsManager getUpdateSettingsManager() {
        if (updateSettingsManager == null)
            updateSettingsManager = new UpdateSettingsManagerImplementation(clientFactory.getClient());
        return updateSettingsManager;
    }

    /**
     *  This method returns the SearchManager (lazy instantiation)
     * @return SearchManager
     */
    public SearchManager getSearchManager() {
        if (searchManager == null)
            searchManager = new SearchManagerImplementation(clientFactory.getClient());
        return searchManager;
    }

    /**
     *  This method returns the CreatePlaylistManager (lazy instantiation)
     * @return CreatePlaylistManager
     */
    public CreatePlaylistManager getCreatePlaylistManager() {
        if (createPlaylistManager == null)
            createPlaylistManager = new CreatePlayListManagerImplementation(clientFactory.getClient());
        return createPlaylistManager;
    }

    /**
     *  This method returns the MainMenuManager (lazy instantiation)
     * @return MainMenuManager
     */
    public MainMenuManager getMainMenuManager() {
        if (mainMenuManager == null)
            mainMenuManager = new MainMenuManagerImplementation(clientFactory.getClient());
        return mainMenuManager;
    }

    /**
     *  This method returns the AddAlbumManager (lazy instantiation)
     * @return AddAlbumManager
     */
    public AddAlbumManager getAddAlbumManager() {
        if (addAlbumManager == null)
            addAlbumManager = new AddAlbumManagerImplementation(clientFactory.getClient());
        return addAlbumManager;
    }

    /**
     *  This method returns the AddSongManager (lazy instantiation)
     * @return AddSongManager
     */
    public AddSongManager getAddSongManager() {
        if (addSongManager == null)
            addSongManager = new AddSongManagerImpl(clientFactory.getClient());
        return addSongManager;
    }

    /**
     *  This method returns the DeleteSongManager (lazy instantiation)
     * @return DeleteSongManager
     */
    public DeleteSongManager getDeleteSongManager() {
        if (deleteSongManager == null)
            deleteSongManager = new DeleteSongManagerImplementation(clientFactory.getClient());
        return deleteSongManager;
    }

    /**
     *  This method returns the RemoveAlbumManager (lazy instantiation)
     * @return RemoveAlbumManager
     */
    public RemoveAlbumManager getRemoveAlbumManager() {
        if (removeAlbumManager == null)
            removeAlbumManager = new RemoveAlbumManagerImplementation(clientFactory.getClient());
        return removeAlbumManager;
    }

    /**
     *  This method returns the RemovePlaylistManager (lazy instantiation)
     * @return RemovePlaylistManager
     */
    public RemovePlaylistManager getRemovePlaylistManager() {
        if (removePlaylistManager == null)
            removePlaylistManager = new RemovePlaylistManagerImplementation(clientFactory.getClient());
        return removePlaylistManager;
    }
}
