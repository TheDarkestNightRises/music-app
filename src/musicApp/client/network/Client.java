package musicApp.client.network;

import musicApp.client.model.addAlbum.AddAlbumManager;
import musicApp.client.model.removeAlbum.RemoveAlbumManager;
import musicApp.client.model.updateSettings.UpdateSettingsManager;
import musicApp.client.network.addAlbum.AddAlbumClient;
import musicApp.client.network.addSong.AddSongClient;
import musicApp.client.network.addToPlaylist.AddToPlaylistClient;
import musicApp.client.network.chat.ChatClient;
import musicApp.client.network.createPlaylist.CreatePlaylistClient;
import musicApp.client.network.deleteSong.DeleteSongClient;
import musicApp.client.network.followList.FollowListClient;
import musicApp.client.network.login.LoginClient;
import musicApp.client.network.mainMenu.MainMenuClient;
import musicApp.client.network.musicplayer.MusicPlayerClient;
import musicApp.client.network.profile.ProfileClient;
import musicApp.client.network.register.SignUpClient;
import musicApp.client.network.removeAlbum.RemoveAlbumClient;
import musicApp.client.network.removePlaylist.RemovePlaylistClient;
import musicApp.client.network.search.SearchClient;
import musicApp.client.network.updateSettings.UpdateSettingsClient;
import musicApp.client.views.removePlaylist.RemovePlaylistViewModel;
import musicApp.util.Subject;

public interface Client extends Subject
{
  //-----------CLIENT-----------
  void startClient();

  ChatClient getChatClient();

  LoginClient getLoginClient();

  MusicPlayerClient getMusicPlayerClient();

  SignUpClient getSignUpClient();

  ProfileClient getProfileClient();

  SearchClient getSearchClient();

  FollowListClient getFollowListClient();

  UpdateSettingsClient getUpdateSettingsclient();

  CreatePlaylistClient getCreatePlaylistClient();

  MainMenuClient getMainMenuClient();

  AddToPlaylistClient getAddToPlaylistClient();

  AddAlbumClient getAddAlbumClient();

  AddSongClient getAddSongClient();

  DeleteSongClient getDeleteSongClient();

  RemoveAlbumClient getRemoveAlbumClient();

  RemovePlaylistClient getRemovePlaylistClient();
}
