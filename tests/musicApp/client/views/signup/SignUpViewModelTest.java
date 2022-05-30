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
        username = new SimpleStringProperty("");
        password = new SimpleStringProperty("");
        error = new SimpleStringProperty("");
        email = new SimpleStringProperty("");
        repeatPassword = new SimpleStringProperty("");
        viewModel.bindUsername(username);
        viewModel.bindPassword(password);
        viewModel.bindError(error);
        viewModel.bindRepeatPassword(repeatPassword);
        viewModel.bindEmail(email);
    }

    @Test
    public void newViewModelIsEmpty() {
        assertEquals("", username.get());
        assertEquals("", error.get());
        assertEquals("", repeatPassword.get());
        assertEquals("", password.get());
    }

    @Test
    public void canBeReset() { //TODO:DONE
        viewModel.reset();
        assertEquals("", username.get());
        assertEquals("", password.get());
        assertEquals("", email.get());
        assertEquals("", error.get());
        assertEquals("", repeatPassword.get());
    }

    @Test
    public void assignValuesToUsernamePasswordEmailDoesntChangeError() {
        username.set("emanuel");
        password.set("wdadxsada");
        repeatPassword.set("dasdaasd");
        email.set("lol@yahoo.com");
        assertEquals("", error.get());
    }

    @Test
    public void userNameExistsIsTrue() {
        username.set("emanuel");
        assertTrue(viewModel.UsernameExists());
    }

    @Test
    public void userNameExistsChangesError() {
        username.set("emanuel");
        assertFalse(viewModel.registerValidation());
        assertEquals("Username already exists!", error.get());
    }

    @Test
    public void noDataInsertedChangesError() {
        assertFalse(viewModel.registerValidation());
        assertEquals("No data inserted!", error.get());
    }

    @Test
    public void userNameNullChangesError() {
        password.set("re1231245");
        assertFalse(viewModel.registerValidation());
        assertEquals("Username should not be null!", error.get());
    }

    @Test
    public void passwordNullChangesError() {
        username.set("lol1234");
        assertFalse(viewModel.registerValidation());
        assertEquals("Password should not be null!", error.get());
    }

    @Test
    public void emailNullChangesError() {
        username.set("lolwhatever");
        password.set("re2124");
        assertFalse(viewModel.registerValidation());
        assertEquals("Email should not be null!", error.get());
    }

    @Test
    public void passwordShorterThan8CharactersChangesError() {
        username.set("lolwhatever");
        password.set("re212");
        email.set("lol@yahoo.com");
        assertFalse(viewModel.registerValidation());
        assertEquals("Password must contain at least 8 characters!", error.get());
    }


    @Test
    public void passwordWithout1DigitChangesError() {
        username.set("lolwhatever");
        password.set("resdasdadasda");
        email.set("lol@yahoo.com");
        assertFalse(viewModel.registerValidation());
        assertEquals("Password must contain at least one digit!", error.get());
    }

    @Test
    public void passwordWithoutUppercaseChangesError() {
        username.set("lolwhatever");
        password.set("resdasdadasda1");
        email.set("lol@yahoo.com");
        assertFalse(viewModel.registerValidation());
        assertEquals("Password must contain at least one uppercase!", error.get());
    }

    @Test
    public void emailNotValidChangesError() {
        username.set("lolwhatever");
        password.set("Resdasdadasda1");
        email.set("lolm");
        assertFalse(viewModel.registerValidation());
        assertEquals("Email is not valid!", error.get());
    }

    @Test
    public void differentPasswordChangesError() {
        username.set("lolwhatever");
        password.set("Resdasdadasda1");
        email.set("lol@yahoo.com");
        assertFalse(viewModel.registerValidation());
        assertEquals("Password does not match!", error.get());
    }

    @Test
    public void goodValidationWorks() {
        username.set("lolwhatever");
        password.set("Resdasdadasda1");
        repeatPassword.set("Resdasdadasda1");
        email.set("lol@yahoo.com");
        assertTrue(viewModel.registerValidation());
        assertEquals("", error.get());
    }

    @Test
    public void createGoodUserWorks(){
        username.set("lolwhatever");
        password.set("Resdasdadasda1");
        repeatPassword.set("Resdasdadasda1");
        email.set("lol@yahoo.com");
        assertTrue(viewModel.createUser());
        assertEquals("", error.get());
    }
}