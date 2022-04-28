package musicApp.client.core;

import musicApp.client.model.MainModel;
import musicApp.client.model.MainModelImplementation;
import musicApp.client.model.chat.ChatManager;
import musicApp.client.model.chat.ChatManagerImplementation;
import musicApp.client.model.login.LogInManager;
import musicApp.client.model.login.LoginManagerImplementation;
import musicApp.client.model.music.MusicManager;
import musicApp.client.model.music.MusicManagerImplementation;
import musicApp.client.model.register.SignUpManager;
import musicApp.client.model.register.SignUpManagerImplementation;

public class ModelFactory {
    private ChatManager chatManager;
    private LogInManager logInManager;
    private SignUpManager signUpManager;
    private ClientFactory clientFactory;
    private MainModel mainModel;
    private MusicManager musicManager;

    public ModelFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public MainModel getMainModel() {
        if (mainModel == null) {
            mainModel = new MainModelImplementation(getMusicManager(),getLoginManager(), getChatManager(),signUpManager());
        }
        return mainModel;
    }

    public ChatManager getChatManager() {
        if(chatManager == null)
            chatManager = new ChatManagerImplementation(clientFactory.getClient());
        return chatManager;
    }

    public LogInManager getLoginManager() {
        if(logInManager == null)
            logInManager = new LoginManagerImplementation(clientFactory.getClient());
        return logInManager;
    }

    public MusicManager getMusicManager() {
        if(musicManager == null)
            musicManager = new MusicManagerImplementation(clientFactory.getClient());
        return musicManager;
    }

    public SignUpManager signUpManager() {
        if(signUpManager == null)
            signUpManager = new SignUpManagerImplementation(clientFactory.getClient());
        return signUpManager;
    }
}
