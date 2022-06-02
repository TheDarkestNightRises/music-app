package musicApp.client.views.followList;

import musicApp.client.model.followList.FollowListManager;
import musicApp.client.model.login.LogInManager;
import musicApp.server.model.domainModel.User;

import java.util.List;

/**
 * Follow list view model responsible for getting the follow list
 */
public class FollowListViewModel {

    private LogInManager loginManager;
    private FollowListManager followListManager;

    /**
     *  This is the constructor of the FollowListViewModel
     * @param loginManager this  is used to get the current user
     * @param followListManager this  is used to get the follow list
     */
    public FollowListViewModel(LogInManager loginManager, FollowListManager followListManager) {
        this.loginManager = loginManager;
        this.followListManager = followListManager;
    }

    /**
     * this method is used to get the followed list
     * @return a list with people that are followed
     */
    public List<User> getFollowList() {
        User user = loginManager.getUser();
        return followListManager.getFollowList(user);
    }

    /**
     * this method check is the user is online
     * @param user the user that needs to be checked
     * @return true is the user is online and false is he is not
     */
    public boolean isOnline(User user) {
        return followListManager.isOnline(user);
    }
}
