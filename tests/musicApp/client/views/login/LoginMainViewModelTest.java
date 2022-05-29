package musicApp.client.views.login;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class LoginMainViewModelTest {
    private LoginMainViewModel viewModel;
    private StringProperty username;
    private StringProperty password;
    private StringProperty error;

    @BeforeEach
    void setUp() {
        viewModel = new LoginMainViewModel(new FakeLoginModel());
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        error = new SimpleStringProperty();
        viewModel.bindUsername(username);
        viewModel.bindPassword(password);
        viewModel.bindError(error);
    }
}