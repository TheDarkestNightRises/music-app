package musicApp.client.views.navigationBar;

import musicApp.client.model.login.LogInManager;
import musicApp.client.model.profile.ProfileManager;
import musicApp.server.model.domainModel.User;

public class NavigationViewModel {


    private final LogInManager loginManager;
    private final ProfileManager profileManager;

    public NavigationViewModel(LogInManager loginManager, ProfileManager profileManager) {
        this.loginManager = loginManager;
        this.profileManager = profileManager;
    }

    public User fetchUser() {
        return loginManager.getUser();
    }

    public boolean isArtist() {
        User user = loginManager.getUser();
        return profileManager.isArtist(user);
    }
}
