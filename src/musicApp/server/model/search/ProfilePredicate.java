package musicApp.server.model.search;

import musicApp.server.model.domainModel.Album;
import musicApp.server.model.domainModel.User;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProfilePredicate {
    public static Predicate<User> hasSameUserNameOrNickName(String searchResult) {
        return p -> p.getUsername().contains(searchResult) || p.getNickname().contains(searchResult);
    }

    public static ArrayList<User> filterUsers(ArrayList<User> user, Predicate<User> predicate) {
        return (ArrayList<User>) user.stream()
                .filter(predicate)
                .collect(Collectors.<User>toList());
    }
}
