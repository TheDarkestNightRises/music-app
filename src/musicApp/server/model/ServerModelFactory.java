package musicApp.server.model;

import musicApp.server.model.addAlbum.ServerModelAddAlbum;
import musicApp.server.model.addAlbum.ServerModelAddAlbumImpl;
import musicApp.server.model.addSong.ServerModelAddSong;
import musicApp.server.model.addSong.ServerModelAddSongImpl;
import musicApp.server.model.addToPlaylist.ServerModelAddToPlaylist;
import musicApp.server.model.addToPlaylist.ServerModelAddToPlaylistImpl;
import musicApp.server.model.chat.ServerModelChat;
import musicApp.server.model.chat.ServerModelChatImpl;
import musicApp.server.model.createPlaylist.ServerModelCreatePlaylist;
import musicApp.server.model.createPlaylist.ServerModelCreatePlaylistImpl;
import musicApp.server.model.deleteSong.ServerModelDeleteSong;
import musicApp.server.model.deleteSong.ServerModelDeleteSongImpl;
import musicApp.server.model.followList.ServerModelFollowList;
import musicApp.server.model.followList.ServerModelFollowListImpl;
import musicApp.server.model.login.ServerModelLogin;
import musicApp.server.model.login.ServerModelLoginImpl;
import musicApp.server.model.mainMenu.ServerModelMainMenu;
import musicApp.server.model.mainMenu.ServerModelMainMenuImpl;
import musicApp.server.model.musicplayer.ServerModelMusic;
import musicApp.server.model.musicplayer.ServerModelMusicImpl;
import musicApp.server.model.profile.ServerModelProfile;
import musicApp.server.model.profile.ServerModelProfileImpl;
import musicApp.server.model.register.ServerModelSignUp;
import musicApp.server.model.register.ServerModelSignUpImpl;
import musicApp.server.model.removeAlbum.ServerModelRemoveAlbum;
import musicApp.server.model.removeAlbum.ServerModelRemoveAlbumImpl;
import musicApp.server.model.removePlaylist.ServerModelRemovePlaylist;
import musicApp.server.model.removePlaylist.ServerModelRemovePlaylistImpl;
import musicApp.server.model.search.ServerModelSearch;
import musicApp.server.model.search.ServerModelSearchImpl;
import musicApp.server.model.updateSettings.ServerModelUpdateSettings;
import musicApp.server.model.updateSettings.ServerModelUpdateSettingsImpl;

import java.beans.PropertyChangeSupport;

public class ServerModelFactory  {

    private final ServerModelProfile modelProfile;
    private ServerModelChat modelChat;
    private ServerModelLogin modelLogin;
    private ServerModelMusic modelMusic;
    private ServerModelSignUp modelSignUp;
    private ServerModelUpdateSettings modelUpdateSettings;
    private ServerModelSearch modelSearch;
    private ServerModelFollowList modelFollowList;
    private ServerModelMainMenu serverModelMainMenu;
    private ServerModelCreatePlaylist serverModelCreatePlaylist;
    private ServerModelAddToPlaylist serverModelAddToPlaylist;
    private ServerModelAddAlbum serverModelAddAlbum;
    private ServerModelRemoveAlbum serverModelRemoveAlbum;
    private ServerModelAddSong serverModelAddSong;
    private ServerModelDeleteSong serverModelDeleteSong;
    private ServerModelRemovePlaylist serverModelRemovePlaylist;

    public ServerModelFactory() {
        this.modelChat = new ServerModelChatImpl();
        this.modelLogin = new ServerModelLoginImpl();
        this.modelMusic = new ServerModelMusicImpl();
        this.modelSignUp = new ServerModelSignUpImpl();
        this.modelProfile = new ServerModelProfileImpl();
        this.modelUpdateSettings = new ServerModelUpdateSettingsImpl();
        this.modelSearch = new ServerModelSearchImpl();
        this.modelFollowList = new ServerModelFollowListImpl();
        this.serverModelMainMenu = new ServerModelMainMenuImpl();
        this.serverModelCreatePlaylist = new ServerModelCreatePlaylistImpl();
        this.serverModelAddToPlaylist = new ServerModelAddToPlaylistImpl();
        this.serverModelAddAlbum = new ServerModelAddAlbumImpl();
        this.serverModelAddSong = new ServerModelAddSongImpl();
        this.serverModelDeleteSong = new ServerModelDeleteSongImpl();
        this.serverModelRemoveAlbum = new ServerModelRemoveAlbumImpl();
        this.serverModelRemovePlaylist = new ServerModelRemovePlaylistImpl();
    }

    public ServerModelChat getModelChat() {
        return modelChat;
    }

    public ServerModelLogin getModelLogin() {
        return modelLogin;
    }

    public ServerModelMusic getModelMusic() {
        return modelMusic;
    }

    public ServerModelSignUp getModelSignUp() {
        return modelSignUp;
    }

    public ServerModelProfile getModelProfile() {
        return modelProfile;
    }

    public ServerModelSearch getModelSearch() {
        return modelSearch;
    }

    public ServerModelFollowList getModelFollowList() {
        return modelFollowList;
    }

    public ServerModelUpdateSettings getModelUpdateSettings() {
        return modelUpdateSettings;
    }


    public ServerModelMainMenu getModelMainMenu() {
        return serverModelMainMenu;
    }

    public ServerModelCreatePlaylist getServerModelCreatePlaylist() {
        return serverModelCreatePlaylist;
    }

    public ServerModelAddToPlaylist getModelAddToPlaylist() {
        return serverModelAddToPlaylist;
    }

    public ServerModelAddAlbum getModelAddAlbums() {
        return serverModelAddAlbum;
    }

    public ServerModelAddSong getModelAddSong() {
        return serverModelAddSong;
    }

    public ServerModelDeleteSong getModelDeleteSong() {
        return serverModelDeleteSong;
    }

    public ServerModelRemoveAlbum getModelRemoveAlbum() {
        return serverModelRemoveAlbum;
    }

    public ServerModelRemovePlaylist getModelRemovePlaylist() {
        return serverModelRemovePlaylist;
    }
}
