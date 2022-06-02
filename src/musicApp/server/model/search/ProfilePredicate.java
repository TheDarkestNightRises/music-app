package musicApp.server.model.search;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.User;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Predicate responsible for filtering the profile search results based on certain conditions:
 * if the search result contains any of the username or nicknames
 */
public class ProfilePredicate {
    public static Predicate<User> hasSameUserNameOrNickName(String searchResult) {
        return p -> p.getUsername().contains(searchResult) || p.getNickname().contains(searchResult);
    }

    /**
     * Method responsible for filtering the list based on the predicate above
     * @param users array to be sorted
     * @param predicate condition
     * @return filtered list
     */
    public static ArrayList<User> filterUsers(ArrayList<User> users, Predicate<User> predicate) {
        return (ArrayList<User>) users.stream()
                .filter(predicate)
                .collect(Collectors.<User>toList());
    }
}
