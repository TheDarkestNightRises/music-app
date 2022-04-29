package musicApp.server.model;

import musicApp.client.model.User;
import musicApp.server.model.chat.ServerModelChat;
import musicApp.server.model.login.ServerModelLogin;
import musicApp.server.model.musicplayer.ServerModelMusic;
import musicApp.server.model.register.ServerModelSignUp;
import musicApp.shared.LogEntry;
import musicApp.shared.Message;
import musicApp.util.Subject;

import java.util.List;

public interface ServerModel {
    //-----------MainServerModel----------
    ServerModelChat getModelChat();

    ServerModelLogin getModelLogin();

    ServerModelMusic getModelMusic();

    ServerModelSignUp getModelSignUp();


}
