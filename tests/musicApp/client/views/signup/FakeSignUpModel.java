package musicApp.client.views.signup;

import musicApp.client.model.register.SignUpManager;
import musicApp.server.model.domainModel.User;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FakeSignUpModel implements SignUpManager {
    private ArrayList<User> users;

    public FakeSignUpModel() {
        this.users = new ArrayList<>();
        populateUsers();
    }

    public void populateUsers() {
        User user = new User("emanuel", "scrumMast3r");
        User user2 = new User("cosmin", "Qwerty1234");
        users.add(user);
        users.add(user2);
    }

    @Override
    public boolean usernameExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) return true;
        }
        return false;
    }

    @Override
    public void addUser(String username, String password, String email) {

    }

    @Override
    public boolean noDigits(String password) {
        for (int i = 0; i < password.length(); i++)
            if (Character.isDigit(password.charAt(i)))
                return false;
        return true;
    }

    @Override
    public boolean noUpper(String password) {
        for (int i = 0; i < password.length(); i++)
            if (Character.isUpperCase(password.charAt(i)))
                return false;
        return true;
    }

    @Override
    public boolean emailNotValid(String email) {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches())
            return false;
        return true;
    }

    @Override
    public void addArtist(String username, String password, String email) {

    }
}
