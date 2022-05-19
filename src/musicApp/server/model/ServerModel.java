package musicApp.server.model;

import musicApp.server.model.chat.ServerModelChat;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.followList.ServerModelFollowList;
import musicApp.server.model.login.ServerModelLogin;
import musicApp.server.model.mainMenu.ServerModelMainMenu;
import musicApp.server.model.musicplayer.ServerModelMusic;
import musicApp.server.model.profile.ServerModelProfile;
import musicApp.server.model.register.ServerModelSignUp;
import musicApp.server.model.search.ServerModelSearch;
import musicApp.server.model.updateSettings.ServerModelUpdateSettings;
import musicApp.shared.networking.ProfileServer;

import java.util.ArrayList;

public interface ServerModel {
    //-----------MainServerModel----------
    ServerModelChat getModelChat();

    ServerModelLogin getModelLogin();

    ServerModelMusic getModelMusic();

    ServerModelSignUp getModelSignUp();

    ServerModelProfile getModelProfile();

    ServerModelSearch getModelSearch();

    ServerModelFollowList getModelFollowList();

    ServerModelUpdateSettings getModelUpdateSettings();

    ServerModelMainMenu getModelMainMenu();
}
