package musicApp.client.network;

import musicApp.client.model.search.SearchManager;
import musicApp.client.network.chat.ChatClient;
import musicApp.client.network.login.LoginClient;
import musicApp.client.network.musicplayer.MusicPlayerClient;
import musicApp.client.network.profile.ProfileClient;
import musicApp.client.network.register.SignUpClient;
import musicApp.client.network.search.SearchClient;
import musicApp.server.model.Playlist;
import musicApp.server.model.Song;
import musicApp.util.Subject;

import java.util.ArrayList;

public interface Client extends Subject {
    //-----------CLIENT-----------
    void startClient();

    ChatClient getChatClient();

    LoginClient getLoginClient();

    MusicPlayerClient getMusicPlayerClient();

    SignUpClient getSignUpClient();

    ProfileClient getProfileClient();

    SearchClient getSearchClient();
}
