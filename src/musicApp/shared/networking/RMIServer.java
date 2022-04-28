package musicApp.shared.networking;

import musicApp.client.model.User;
import musicApp.shared.LogEntry;
import musicApp.shared.Message;

import java.io.File;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface RMIServer extends Remote {
    void startServer() throws RemoteException, AlreadyBoundException;

    void registerClient(ClientCallBack client) throws RemoteException;

    ChatServer getChatServer() throws RemoteException;

    LoginServer getLoginServer() throws RemoteException;

    MusicPlayerServer getMusicPlayerServer() throws RemoteException;

    SignUpServer getSignUpServer() throws RemoteException;
}
