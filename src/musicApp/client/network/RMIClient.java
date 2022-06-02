package musicApp.client.network;

import musicApp.client.network.addAlbum.AddAlbumClient;
import musicApp.client.network.addAlbum.RMIAddAlbumClient;
import musicApp.client.network.addSong.AddSongClient;
import musicApp.client.network.addSong.RMIAddSongClient;
import musicApp.client.network.addToPlaylist.AddToPlaylistClient;
import musicApp.client.network.addToPlaylist.RMIAddToPlaylistClient;
import musicApp.client.network.chat.ChatClient;
import musicApp.client.network.chat.RMIChatClient;
import musicApp.client.network.createPlaylist.CreatePlaylistClient;
import musicApp.client.network.createPlaylist.RMICreatePlayListClient;
import musicApp.client.network.deleteSong.DeleteSongClient;
import musicApp.client.network.deleteSong.RMIDeleteSongClient;
import musicApp.client.network.followList.FollowListClient;
import musicApp.client.network.followList.RMIFollowListClient;
import musicApp.client.network.login.LoginClient;
import musicApp.client.network.login.RMILoginClient;
import musicApp.client.network.mainMenu.MainMenuClient;
import musicApp.client.network.mainMenu.RMIMainMenu;
import musicApp.client.network.musicplayer.MusicPlayerClient;
import musicApp.client.network.musicplayer.RMIMusicPlayerClient;
import musicApp.client.network.profile.ProfileClient;
import musicApp.client.network.profile.RMIProfileClient;
import musicApp.client.network.register.RMISignUpClient;
import musicApp.client.network.register.SignUpClient;
import musicApp.client.network.removeAlbum.RMIRemoveAlbumClient;
import musicApp.client.network.removeAlbum.RemoveAlbumClient;
import musicApp.client.network.removePlaylist.RMIRemovePlaylistClient;
import musicApp.client.network.removePlaylist.RemovePlaylistClient;
import musicApp.client.network.search.RMISearchClient;
import musicApp.client.network.search.SearchClient;
import musicApp.client.network.updateSettings.RMIUpdateSettingsClient;
import musicApp.client.network.updateSettings.UpdateSettingsClient;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.shared.LogEntry;
import musicApp.shared.Message;
import musicApp.shared.networking.ClientCallBack;
import musicApp.shared.networking.RMIServer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * This is the RMIClient used for communication with the server
 */
public class RMIClient implements Client, ClientCallBack {
    private PropertyChangeSupport support;
    private RMIServer server;
    private ChatClient chatClient;
    private LoginClient loginClient;
    private MusicPlayerClient musicPlayerClient;
    private SignUpClient signUpClient;
    private ProfileClient profileClient;
    private UpdateSettingsClient updateSettingsClient;
    private SearchClient searchClient;
    private FollowListClient followListClient;
    private MainMenuClient mainMenuClient;
    private CreatePlaylistClient createPlaylistClient;
    private AddToPlaylistClient addToPlaylistClient;
    private AddAlbumClient addAlbumClient;
    private AddSongClient addSongClient;
    private DeleteSongClient deleteSongClient;
    private RemoveAlbumClient removeAlbumClient;
    private RemovePlaylistClient removePlaylistClient;

    /**
     * This constructor will export the rmi client as a remote object and will lookup for the server
     * as well instantiating the clients.
     */
    public RMIClient() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            server = (RMIServer) registry.lookup("Server");
            support = new PropertyChangeSupport(this);
            this.signUpClient = new RMISignUpClient(server);
            this.chatClient = new RMIChatClient(server);
            this.loginClient = new RMILoginClient(server);
            this.musicPlayerClient = new RMIMusicPlayerClient(server);
            this.profileClient = new RMIProfileClient(server);
            this.updateSettingsClient = new RMIUpdateSettingsClient(server);
            this.searchClient = new RMISearchClient(server);
            this.followListClient = new RMIFollowListClient(server);
            this.mainMenuClient = new RMIMainMenu(server);
            this.createPlaylistClient = new RMICreatePlayListClient(server);
            this.addToPlaylistClient = new RMIAddToPlaylistClient(server);
            this.addAlbumClient = new RMIAddAlbumClient(server);
            this.addSongClient = new RMIAddSongClient(server);
            this.deleteSongClient = new RMIDeleteSongClient(server);
            this.removeAlbumClient = new RMIRemoveAlbumClient(server);
            this.removePlaylistClient = new RMIRemovePlaylistClient(server);
            startClient();
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will start the client by registering the client to all observer/ broadcast
     */
    @Override
    public void startClient() {
        try {
            server.registerClient(this);
            server.getChatServer().registerClientToBroadcast(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    //ASYNC UPDATE FROM SERVER -- INTERFACE CLIENT CALLBACK
    @Override
    public void updateChat(Message message) {
        support.firePropertyChange("MessageAdded", null, message);
    }

    @Override
    public void updateUserNumber(int newValue) {
        support.firePropertyChange("OnNewUserEntry", null, newValue);
    }

    @Override
    public void updateSongSearchResult(ArrayList<Song> songsSearchResult) {
        support.firePropertyChange("newSearchSong", null, songsSearchResult);
    }

    @Override
    public void updateAlbumSearchResult(ArrayList<Album> albumsSearchResult) throws RemoteException {
        support.firePropertyChange("newSearchAlbum", null, albumsSearchResult);
    }

    @Override
    public void updateProfileSearchResult(ArrayList<User> profileSearchResult) throws RemoteException {
        support.firePropertyChange("newSearchProfile", null, profileSearchResult);
    }

    @Override
    public void updatePlaylists(Playlist newValue) throws RemoteException {
        support.firePropertyChange("newPlaylist", null, newValue);
    }

    @Override
    public void updateSongsFromPlaylist(Playlist newValue) throws RemoteException {
        System.out.println("Fired from profile client");
        support.firePropertyChange("newSongAddedToPlaylist", null, newValue);
    }

    @Override
    public void updateLog(LogEntry log) {
        support.firePropertyChange("NewLogEntry", null, log);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }

    public ChatClient getChatClient() {
        return chatClient;
    }

    public LoginClient getLoginClient() {
        return loginClient;
    }

    public MusicPlayerClient getMusicPlayerClient() {
        return musicPlayerClient;
    }

    public SignUpClient getSignUpClient() {
        return signUpClient;
    }

    @Override
    public ProfileClient getProfileClient() {
        return profileClient;
    }

    @Override
    public SearchClient getSearchClient() {
        return searchClient;
    }

    @Override
    public FollowListClient getFollowListClient() {
        return followListClient;
    }

    @Override
    public UpdateSettingsClient getUpdateSettingsclient() {
        return updateSettingsClient;
    }

    @Override public CreatePlaylistClient getCreatePlaylistClient()
    {
        return createPlaylistClient;
    }

    @Override
    public MainMenuClient getMainMenuClient() {
        return mainMenuClient;
    }

    @Override public AddToPlaylistClient getAddToPlaylistClient()
    {
        return addToPlaylistClient;
    }

    @Override public AddAlbumClient getAddAlbumClient()
    {
        return addAlbumClient;
    }

    @Override public AddSongClient getAddSongClient()
    {
        return addSongClient;
    }

    @Override public DeleteSongClient getDeleteSongClient()
    {
        return deleteSongClient;
    }

    @Override public RemoveAlbumClient getRemoveAlbumClient()
    {
        return removeAlbumClient;
    }

    @Override public RemovePlaylistClient getRemovePlaylistClient()
    {
        return removePlaylistClient;
    }

}
