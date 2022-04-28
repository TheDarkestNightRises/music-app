package musicApp.client.network;

import musicApp.client.network.chat.ChatClient;
import musicApp.client.network.login.LoginClient;
import musicApp.client.network.musicplayer.MusicPlayerClient;
import musicApp.client.network.register.SignUpClient;
import musicApp.util.Subject;

public interface Client extends Subject {
    //-----------CLIENT-----------
    void startClient();

    ChatClient getChatClient();

    LoginClient getLoginClient();

    MusicPlayerClient getMusicPlayerClient();

    SignUpClient getSignUpClient();
}
