package musicApp.client.views.followList;

import musicApp.client.model.followList.FollowListManager;
import musicApp.client.model.login.LogInManager;
import musicApp.server.model.domainModel.User;

import java.util.List;

public class FollowListViewModel {

    private LogInManager loginManager;
    private FollowListManager followListManager;

    public FollowListViewModel(LogInManager loginManager, FollowListManager followListManager) {
        this.loginManager = loginManager;
        this.followListManager = followListManager;
    }

    public List<User> getFollowList() {
        User user = loginManager.getUser();
        return followListManager.getFollowList(user);
    }

    public boolean isOnline(User user) {
        return followListManager.isOnline(user);
    }
}
