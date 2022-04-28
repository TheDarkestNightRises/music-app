package musicApp.client.model;

import musicApp.client.model.chat.ChatManager;
import musicApp.client.model.login.LogInManager;
import musicApp.client.model.music.MusicManager;
import musicApp.client.model.register.SignUpManager;

public class MainModelImplementation implements MainModel{
    MusicManager musicManager;
    LogInManager logInManager;
    ChatManager chatManager;
    SignUpManager signUpManager;


    public MainModelImplementation(MusicManager musicManager, LogInManager logInManager, ChatManager chatManager, SignUpManager signUpManager) {
        this.musicManager = musicManager;
        this.logInManager = logInManager;
        this.chatManager = chatManager;
        this.signUpManager = signUpManager;
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
}
