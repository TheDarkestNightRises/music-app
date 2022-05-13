package musicApp.server.model;

import musicApp.server.model.chat.ServerModelChat;
import musicApp.server.model.login.ServerModelLogin;
import musicApp.server.model.musicplayer.ServerModelMusic;
import musicApp.server.model.profile.ServerModelProfile;
import musicApp.server.model.register.ServerModelSignUp;
import musicApp.shared.networking.ProfileServer;

public interface ServerModel {
    //-----------MainServerModel----------
    ServerModelChat getModelChat();

    ServerModelLogin getModelLogin();

    ServerModelMusic getModelMusic();

    ServerModelSignUp getModelSignUp();

    ServerModelProfile getModelProfile();
}
