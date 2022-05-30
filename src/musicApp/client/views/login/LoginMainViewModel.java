package musicApp.client.views.login;

import musicApp.client.model.login.LogInManager;
import musicApp.database.artist.ArtistDAOImpl;
import musicApp.server.model.domainModel.Artist;
import musicApp.server.model.domainModel.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.SQLException;

public class LoginMainViewModel {

    private LogInManager logInManager;
    private StringProperty username;
    private StringProperty password;
    private StringProperty error;

    public LoginMainViewModel(LogInManager logInManager) {
        this.logInManager = logInManager;
        this.username = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
        this.error = new SimpleStringProperty("");
    }

    public boolean signIn() {
        return loginValidation();
    }

    private boolean accountDoesNotExist() {
        return logInManager.accountDoesNotExist(username.get(), password.get());
    }

    public StringProperty usernameProperty() {
        return username;
    }


    public StringProperty passwordProperty() {
        return password;
    }

//    public void setUser() {
//        model.getLogInManager().setUser(new User(username.get(), password.get()));
//    }//go to database and take user by its username
//

    public void bindError(StringProperty property) {
        error.bindBidirectional(property);
    }

    public void bindUsername(StringProperty usernameProperty) {
        username.bindBidirectional(usernameProperty);
    }

    public void bindPassword(StringProperty passwordProperty) {
        password.bind(passwordProperty);
    }

    public User getUser() {
        return logInManager.getUser();
    }

    public boolean loginValidation() {
        if (password.get().equals("") && username.get().equals("")) {
            error.set("No data inserted");
            return false;
        }
        if (username.get().equals("")) {
            error.set("Username should not be null!");
            return false;
        }
        if (password.get().equals("")) {
            error.set("Password should not be null!");
            return false;
        }
        if (accountDoesNotExist()) {
            error.set("Incorrect username or password");
            return false;
        }
        if (logInManager.signIn(username.get(), password.get()))
            return true;
        else {
            error.set("Account already logged in");
            return false;
        }
    }

}