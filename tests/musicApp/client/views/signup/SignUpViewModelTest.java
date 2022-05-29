package musicApp.client.views.signup;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import musicApp.client.views.login.FakeLoginModel;
import musicApp.client.views.login.LoginMainViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignUpViewModelTest {
    private SignUpViewModel viewModel;
    private StringProperty username;
    private StringProperty password;
    private StringProperty error;
    private StringProperty email;
    private StringProperty repeatPassword;

    @BeforeEach
    public void setUp() {
        viewModel = new SignUpViewModel(new FakeSignUpModel());
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        error = new SimpleStringProperty();
        email = new SimpleStringProperty();
        repeatPassword = new SimpleStringProperty();
        viewModel.bindUsername(username);
        viewModel.bindPassword(password);
        viewModel.bindError(error);
        viewModel.bindRepeatPassword(repeatPassword);
        viewModel.bindEmail(email);
    }

    @Test
    public void newViewModelIsEmpty() {
        assertNull(username.get());
        assertNull(password.get());
        assertNull(error.get());
        assertNull(email.get());
        assertNull(repeatPassword.get());
    }

    @Test
    public void canBeReset() {
        viewModel.reset();
        assertEquals("",username.get());
        assertEquals("",password.get());
        assertEquals("",email.get());
        assertEquals("",error.get());
        assertEquals("",repeatPassword.get());
    }

    @Test
    public void assignValuesToUsernamePasswordEmailDoesntChangeError(){
        username.set("emanuel");
        password.set("wdadxsada");
        repeatPassword.set("dasdaasd");
        email.set("lol@yahoo.com");
        assertNull(error.get());
    }

    @Test
    public void userNameExistsChangesError() {
        username.set("emanuel");
        viewModel.registerValidation();
        assertEquals("",error.get());
    }



}