package musicApp.client.network;

import musicApp.client.network.addToPlaylist.AddToPlaylistClient;
import musicApp.client.network.chat.ChatClient;
import musicApp.client.network.createPlaylist.CreatePlaylistClient;
import musicApp.client.network.followList.FollowListClient;
import musicApp.client.network.login.LoginClient;
import musicApp.client.network.mainMenu.MainMenuClient;
import musicApp.client.network.musicplayer.MusicPlayerClient;
import musicApp.client.network.profile.ProfileClient;
import musicApp.client.network.register.SignUpClient;
import musicApp.client.network.search.SearchClient;
import musicApp.client.network.updateSettings.UpdateSettingsClient;
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
}
