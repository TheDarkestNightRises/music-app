package musicApp.server.model;

import musicApp.server.model.chat.ServerModelChat;
import musicApp.server.model.login.ServerModelLogin;
import musicApp.server.model.musicplayer.ServerModelMusic;
import musicApp.server.model.register.ServerModelSignUp;

public interface ServerModel {
    //-----------MainServerModel----------
    ServerModelChat getModelChat();

    ServerModelLogin getModelLogin();

    ServerModelMusic getModelMusic();

    ServerModelSignUp getModelSignUp();


}
