package musicApp.server.network;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;
import musicApp.server.network.addAlbum.AddAlbumServerImpl;
import musicApp.server.network.addSong.AddSongServerImpl;
import musicApp.server.network.addToPlaylist.AddToPlaylistServerImpl;
import musicApp.server.network.chat.ChatServerImpl;
import musicApp.server.network.createPlaylist.CreatePlaylistServerImpl;
import musicApp.server.network.deleteSong.DeleteSongServerImpl;
import musicApp.server.network.followList.FollowListServerImpl;
import musicApp.server.network.login.LoginServerImpl;
import musicApp.server.network.mainMenu.MainMenuServerImpl;
import musicApp.server.network.musicplayer.MusicPlayerServerImpl;
import musicApp.server.network.profile.ProfileServerImpl;
import musicApp.server.network.register.SignUpServerImpl;
import musicApp.server.network.removeAlbum.RemoveAlbumServerImpl;
import musicApp.server.network.removePlaylist.RemovePlaylistServerImpl;
import musicApp.server.network.search.SearchServerImpl;
import musicApp.server.network.updateSettings.UpdateSettingsServerImpl;
import musicApp.shared.LogEntry;
import musicApp.shared.networking.*;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Rmi server that acts as a facade
 */
public class RMIServerImpl implements RMIServer {
    private AddToPlaylistServer addToPlaylistServer;
    private ServerModelFactory serverModelFactory;
    private ChatServer chatServer;
    private LoginServer loginServer;
    private MusicPlayerServer musicPlayerServer;
    private SignUpServer signUpServer;
    private ProfileServer profileServer;
    private SearchServer searchServer;
    private FollowListServer followListServer;
    private UpdateSettingsServer updateSettingsServer;
    private CreatePLayListServer createPLayListServer;
    private MainMenuServer mainMenuServer;
    private AddAlbumServer addAlbumServer;
    private AddSongServer addSongServer;
    private DeleteSongServer deleteSongServer;
    private RemoveAlbumServer removeAlbumServer;
    private RemovePlaylistServer removePlaylistServer;

    public RMIServerImpl(ServerModelFactory serverModelFactory) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModelFactory = serverModelFactory;
        this.chatServer = new ChatServerImpl(serverModelFactory);
        this.loginServer = new LoginServerImpl(serverModelFactory);
        this.musicPlayerServer = new MusicPlayerServerImpl(serverModelFactory);
        this.signUpServer = new SignUpServerImpl(serverModelFactory);
        this.profileServer = new ProfileServerImpl(serverModelFactory);
        this.searchServer = new SearchServerImpl(serverModelFactory);
        this.followListServer = new FollowListServerImpl(serverModelFactory);
        this.updateSettingsServer = new UpdateSettingsServerImpl(serverModelFactory);
        this.mainMenuServer = new MainMenuServerImpl(serverModelFactory);
        this.createPLayListServer = new CreatePlaylistServerImpl(serverModelFactory);
        this.addToPlaylistServer = new AddToPlaylistServerImpl(serverModelFactory);
        this.addAlbumServer = new AddAlbumServerImpl(serverModelFactory);
        this.addSongServer = new AddSongServerImpl(serverModelFactory);
        this.deleteSongServer = new DeleteSongServerImpl(serverModelFactory);
        this.removeAlbumServer = new RemoveAlbumServerImpl(serverModelFactory);
        this.removePlaylistServer = new RemovePlaylistServerImpl(serverModelFactory);
    }

    /**
     * This method will start the server and bind it to the registry
     * @throws RemoteException if communication fails
     * @throws AlreadyBoundException if there is already a server
     */
    @Override
    public void startServer() throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", this);
    }

    /**
     * This will register the client to the observers from the model.
     * @param client that implements clientCallBack
     */
    public void registerClient(ClientCallBack client) {
        serverModelFactory.getModelLogin().addListener("OnNewUserEntry", evt -> {
            try {
                client.updateUserNumber((int) evt.getNewValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
        serverModelFactory.getModelSearch().addListener("newSearchSong", evt -> {
            try {
                client.updateSongSearchResult((ArrayList<Song>) evt.getNewValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
        serverModelFactory.getModelSearch().addListener("newSearchAlbum", evt -> {
            try {
                client.updateAlbumSearchResult((ArrayList<Album>) evt.getNewValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
        serverModelFactory.getModelSearch().addListener("newSearchProfile", evt -> {
            try {
                client.updateProfileSearchResult((ArrayList<User>) evt.getNewValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
        serverModelFactory.getModelMusic().addListener("newPlaylist", evt -> {
            try {
                client.updatePlaylists((Playlist) evt.getNewValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
        serverModelFactory.getModelMusic().addListener("newSongAddedToPlaylist", evt -> {
            try {
                client.updateSongsFromPlaylist((Playlist) evt.getNewValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * This will get the chat server to call methods for it ( facade)
     */
    public ChatServer getChatServer() throws RemoteException {
        return chatServer;
    }

    /**
     * This will get the login server to call methods for it ( facade)
     */
    public LoginServer getLoginServer() throws RemoteException {
        return loginServer;
    }

    /**
     * This will get the music server to call methods for it ( facade)
     */
    public MusicPlayerServer getMusicPlayerServer() throws RemoteException {
        return musicPlayerServer;
    }

    /**
     * This will get the sign up server to call methods for it ( facade)
     */
    public SignUpServer getSignUpServer() throws RemoteException {
        return signUpServer;
    }

    /**
     * This will get the profile server to call methods on it ( facade)
     */
    @Override
    public ProfileServer getProfileServer() throws RemoteException {
        return profileServer;
    }

    /**
     * This will get the search server to call methods on it ( facade)
     */
    @Override
    public SearchServer getSearchServer() {
        return searchServer;
    }

    /**
     * This will get the follow list server to call methods on it ( facade)
     */
    public FollowListServer getFollowListServer() throws RemoteException {
        return followListServer;
    }

    /**
     * This will get the updateSettingsServer server to call methods on it ( facade)
     */
    public UpdateSettingsServer getUpdateSettingsServer() throws RemoteException {
        return updateSettingsServer;
    }

    /**
     * This will get the createPLayListServer to call methods on it ( facade)
     */
    public CreatePLayListServer getCreatePlaylistServer() {
        return createPLayListServer;
    }

    /**
     * This will get the mainMenuServer to call methods on it ( facade)
     */
    @Override
    public MainMenuServer getMainMenuServer() throws RemoteException {
        return mainMenuServer;
    }

    /**
     * This will get the addToPlaylistServer to call methods on it ( facade)
     */
    @Override
    public AddToPlaylistServer getAddToPlaylistServer() throws RemoteException {
        return addToPlaylistServer;
    }

    /**
     * This will get the addAlbumServer to call methods on it ( facade)
     */
    @Override
    public AddAlbumServer getAddAlbumServer() throws RemoteException {
        return addAlbumServer;
    }

    /**
     * This will get the addSongServer to call methods on it ( facade)
     */
    @Override
    public AddSongServer getAddSongServer() throws RemoteException {
        return addSongServer;
    }

    /**
     * This will get the deleteSongServer to call methods on it ( facade)
     */
    @Override
    public DeleteSongServer getDeleteSongServer()
            throws RemoteException {
        return deleteSongServer;
    }

    /**
     * This will get the removeAlbumServer to call methods on it ( facade)
     */
    @Override
    public RemoveAlbumServer getRemoveAlbumServer()
            throws RemoteException {
        return removeAlbumServer;
    }

    /**
     * This will get the removePlaylistServer to call methods on it ( facade)
     */
    @Override
    public RemovePlaylistServer getRemovePlaylistServer() throws RemoteException {
        return removePlaylistServer;
    }

}
