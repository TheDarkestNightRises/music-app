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

    /**
     * This method will fetch the cached user
     */
    public User fetchUser() {
        return loginManager.getUser();
    }

    /**
     * This method will check if the user is an artist
     * @return true if artist, false if not
     */
    public boolean isArtist() {
        User user = loginManager.getUser();
        return profileManager.isArtist(user);
    }
}
