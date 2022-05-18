package musicApp.client.network;

import musicApp.client.network.chat.ChatClient;
import musicApp.client.network.chat.RMIChatClient;
import musicApp.client.network.followList.FollowListClient;
import musicApp.client.network.followList.RMIFollowListClient;
import musicApp.client.network.login.LoginClient;
import musicApp.client.network.login.RMILoginClient;
import musicApp.client.network.musicplayer.MusicPlayerClient;
import musicApp.client.network.musicplayer.RMIMusicPlayerClient;
import musicApp.client.network.profile.ProfileClient;
import musicApp.client.network.profile.RMIProfileClient;
import musicApp.client.network.register.RMISignUpClient;
import musicApp.client.network.register.SignUpClient;
import musicApp.client.network.search.RMISearchClient;
import musicApp.client.network.search.SearchClient;
import musicApp.client.network.updateSettings.RMIUpdateSettingsClient;
import musicApp.client.network.updateSettings.UpdateSettingsClient;
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

    //TODO: RMI is early instantiation and Model is lazy even though lazy doesn't make much sense? this is a jojo ref

    public RMIClient() {
        support = new PropertyChangeSupport(this);
        this.chatClient = new RMIChatClient();
        this.loginClient = new RMILoginClient();
        this.musicPlayerClient = new RMIMusicPlayerClient();
        this.signUpClient = new RMISignUpClient();
        this.profileClient = new RMIProfileClient();
        this.updateSettingsClient = new RMIUpdateSettingsClient();
        this.searchClient = new RMISearchClient();
        this.followListClient = new RMIFollowListClient();
    }

    @Override
    public void startClient()  {
        try {
            UnicastRemoteObject.exportObject(this,0);
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            server = (RMIServer) registry.lookup("Server");
            server.registerClient(this);
            server.getChatServer().registerClientToBroadcast(this);
            this.chatClient.setServer(server);
            this.loginClient.setServer(server);
            this.musicPlayerClient.setServer(server);
            this.signUpClient.setServer(server);
            this.profileClient.setServer(server);
            this.updateSettingsClient.setServer(server);
            this.searchClient.setServer(server);
            this.followListClient.setServer(server);
            this.updateSettingsClient.setServer(server);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }


    //ASYNC UPDATE FROM SERVER -- INTERFACE CLIENT CALLBACK
    @Override
    public void updateChat(Message message) {
        support.firePropertyChange("MessageAdded",null,message);
    }

    @Override
    public void updateUserNumber(int newValue) {
        support.firePropertyChange("OnNewUserEntry",null,newValue);
    }

    @Override
    public void updateLog(LogEntry log) {
        support.firePropertyChange("NewLogEntry",null,log);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName,listener);
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

     public SignUpClient getSignUpClient()
    {
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

    @Override public FollowListClient getFollowListClient()
    {
        return followListClient;
    }

    @Override public UpdateSettingsClient getUpdateSettingsclient()
    {
        return updateSettingsClient;
    }

}
