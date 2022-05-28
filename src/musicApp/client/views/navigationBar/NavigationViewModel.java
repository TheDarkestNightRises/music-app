package musicApp.client.views.navigationBar;

import musicApp.server.model.domainModel.User;

public class NavigationViewModel {
    private final MainModel mainModel;

    public NavigationViewModel(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public User fetchUser() {
        return mainModel.getLogInManager().getUser();
    }

    public boolean isArtist() {
        User user = mainModel.getLogInManager().getUser();
        return mainModel.getProfileManager().isArtist(user);
    }
}
