package musicApp.client.views.login;

import musicApp.client.model.MainModel;
import musicApp.database.Users.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginMainViewModel {

    private MainModel model;
    private StringProperty username;
    private StringProperty password;
    private StringProperty error;

    public LoginMainViewModel(MainModel model) {
        this.model = model;
        this.username = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
        this.error = new SimpleStringProperty("");
    }

    public boolean signIn() {
        if (password.get().equals("") && username.get().equals("")) {
            error.set("No data inserted");
            return false; }

        if (username.get().equals("")) {
            error.set("Username should not be null!");
            return false; }

        if (password.get().equals("")) {
            error.set("Password should not be null!");
            return false; }
        if(accountDoesNotExist())
          {
            error.set("The password is wrong");
            return false;
          }
        return model.getLogInManager().signIn(username.get(), password.get());
    }

    private boolean accountDoesNotExist()
    {
        return model.getLogInManager().accountDoesNotExist(username.get(), password.get());
    }

    public StringProperty usernameProperty() {
        return username;
    }


    public StringProperty passwordProperty() {
        return password;
    }

    public void setUser() {
        model.getLogInManager().setUser(new User(username.get(), password.get(),""));
    }

    public void bindError(StringProperty property) {
        error.bindBidirectional(property);
    }
}