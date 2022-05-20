package musicApp.server.network;

import musicApp.server.model.ServerModel;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.network.chat.ChatServerImpl;
import musicApp.server.network.followList.FollowListServerImpl;
import musicApp.server.network.login.LoginServerImpl;
import musicApp.server.network.mainMenu.MainMenuServerImpl;
import musicApp.server.network.musicplayer.MusicPlayerServerImpl;
import musicApp.server.network.profile.ProfileServerImpl;
import musicApp.server.network.register.SignUpServerImpl;
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

public class RMIServerImpl implements RMIServer {
    private ServerModel serverModel;
    private ChatServer chatServer;
    private LoginServer loginServer;
    private MusicPlayerServer musicPlayerServer;
    private SignUpServer signUpServer;
    private ProfileServer profileServer;
    private SearchServer searchServer;
    private FollowListServer followListServer;
    private UpdateSettingsServer updateSettingsServer;
    private MainMenuServer mainMenuServer;

    public RMIServerImpl(ServerModel serverModel) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModel = serverModel;
        this.chatServer = new ChatServerImpl(serverModel);
        this.loginServer = new LoginServerImpl(serverModel);
        this.musicPlayerServer = new MusicPlayerServerImpl(serverModel);
        this.signUpServer = new SignUpServerImpl(serverModel);
        this.profileServer = new ProfileServerImpl(serverModel);
        this.searchServer = new SearchServerImpl(serverModel);
        this.followListServer = new FollowListServerImpl(serverModel);
        this.updateSettingsServer = new UpdateSettingsServerImpl(serverModel);
        this.mainMenuServer = new MainMenuServerImpl(serverModel);
    }

    @Override
    public void startServer() throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", this);
    }


    public void registerClient(ClientCallBack client) {
        serverModel.getModelChat().addListener("NewLogEntry", evt -> {
            try {
                client.updateLog((LogEntry) evt.getNewValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
        serverModel.getModelLogin().addListener("OnNewUserEntry", evt -> {
            try {
                client.updateUserNumber((int) evt.getNewValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
        serverModel.getModelSearch().addListener("newSearch", evt -> {
            try {
                client.updateSearchResult((ArrayList<Song>) evt.getNewValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
        serverModel.getModelMusic().addListener("newPlaylist",evt -> {
            try {
                client.updatePlaylists((Playlist) evt.getNewValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
        serverModel.getModelMusic().addListener("newSongAddedToPlaylist",evt -> {
            try {
                client.updateSongsFromPlaylist((Playlist) evt.getNewValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
    }

    public ChatServer getChatServer() throws RemoteException {
        return chatServer;
    }

    public LoginServer getLoginServer() throws RemoteException {
        return loginServer;
    }

    public MusicPlayerServer getMusicPlayerServer() throws RemoteException{
        return musicPlayerServer;
    }

     public SignUpServer getSignUpServer() throws RemoteException
    {
        return signUpServer;
    }

    @Override
    public ProfileServer getProfileServer() throws RemoteException {
        return profileServer;
    }

    @Override
    public SearchServer getSearchServer() {
        return searchServer;
    }

    public FollowListServer getFollowListServer() throws RemoteException
    {
        return followListServer;
    }

    public UpdateSettingsServer getUpdateSettingsServer() throws RemoteException
    {
        return updateSettingsServer;
    }

    @Override
    public MainMenuServer getMainMenuServer() throws RemoteException {
        return mainMenuServer;
    }
}
