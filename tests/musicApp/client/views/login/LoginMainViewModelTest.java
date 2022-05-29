package musicApp.client.views.login;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginMainViewModelTest {
    private LoginMainViewModel viewModel;
    private StringProperty username;
    private StringProperty password;
    private StringProperty error;

    @BeforeEach
    public void setUp() {
        viewModel = new LoginMainViewModel(new FakeLoginModel());
        username = new SimpleStringProperty("");
        password = new SimpleStringProperty("");
        error = new SimpleStringProperty("");
        viewModel.bindUsername(username);
        viewModel.bindPassword(password);
        viewModel.bindError(error);
    }

    @Test
    public void newViewModelIsEmpty() {
        assertEquals("", username.get());
        assertEquals("", password.get());
        assertEquals("", error.get());
    }

    @Test
    public void noDataInsertedChangesError() {
        viewModel.signIn();
        assertEquals("No data inserted", error.get());
    }

    @Test
    public void passwordNullChangesError() {
        username.set("emanuel");
        assertFalse(viewModel.signIn());
        assertEquals("Password should not be null!", error.get());
    }

    @Test
    public void incorectCombinationChangesError() {
        username.set("emanuel");
        password.set("reea");
        viewModel.signIn();
        assertFalse(viewModel.signIn());
        assertEquals("Password should not be null!", error.get());
    }




}