package musicApp.shared.networking;

import musicApp.client.network.followList.FollowListClient;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote {
    void startServer() throws RemoteException, AlreadyBoundException;

    void registerClient(ClientCallBack client) throws RemoteException;

    ChatServer getChatServer() throws RemoteException;

    LoginServer getLoginServer() throws RemoteException;

    MusicPlayerServer getMusicPlayerServer() throws RemoteException;

    SignUpServer getSignUpServer() throws RemoteException;

    ProfileServer getProfileServer() throws RemoteException;

    SearchServer getSearchServer() throws RemoteException;

    FollowListServer getFollowListServer() throws RemoteException;

    UpdateSettingsServer getUpdateSettingsServer() throws RemoteException;

    MainMenuServer getMainMenuServer() throws RemoteException;
}
