package musicApp.client.model;

import musicApp.client.model.chat.ChatManager;
import musicApp.client.model.followList.FollowListManager;
import musicApp.client.model.login.LogInManager;
import musicApp.client.model.music.MusicManager;
import musicApp.client.model.profile.ProfileManager;
import musicApp.client.model.register.SignUpManager;
import musicApp.client.model.search.SearchManager;
import musicApp.client.model.updateSettings.UpdateSettingsManager;

public interface MainModel {
    MusicManager getMusicPlayerManager();
    LogInManager getLogInManager();
    ChatManager getChatManager();
    SignUpManager getSignUpManager();
    ProfileManager getProfileManager();
    UpdateSettingsManager getUpdateSettingsManager();
    SearchManager getSearchManager();
    FollowListManager getFollowListManager();
}
