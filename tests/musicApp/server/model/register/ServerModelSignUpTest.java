package musicApp.server.model.register;

import musicApp.database.users.UsersDAOImpl;
import musicApp.server.model.domainModel.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerModelSignUpTest {
    private ServerModelSignUp serverModelSignUp;

    @BeforeEach
    public void setUp() {
        serverModelSignUp = new ServerModelSignUpImpl();
    }

    @Test
    public void noDigitsReturnsTrue() {
        assertTrue(serverModelSignUp.noDigits("ras"));
    }

    @Test
    public void withDigitsReturnsFalse() {
        assertFalse(serverModelSignUp.noDigits("ras2"));
    }

    @Test
    public void noUpperCaseReturnsTrue() {
        assertTrue(serverModelSignUp.noUpper("ras2"));
    }

    @Test
    public void withUpperCaseReturnsFalse() {
        assertFalse(serverModelSignUp.noUpper("Ras2"));
    }

    @Test
    public void correctEmailFormatReturnsFalse() {
        assertFalse(serverModelSignUp.emailNotValid("acal@gmail.com"));
    }

    @Test
    public void incorrectEmailFormatReturnsTrue() {
        assertTrue(serverModelSignUp.emailNotValid("lolddacom"));
    }

    @Test
    public void usernameInDatabaseReturnsTrue() {
        assertTrue(serverModelSignUp.usernameExists("emanuel"));
    }

    @Test
    public void usernameNotInDatabaseReturnsFalse() {
        assertFalse(serverModelSignUp.usernameExists("duck"));
    }

    @Test
    public void userExistsAfterIsAddedInDatabase() {
        User user = new User("duckTheGoose", "Abcd1234", "lol@yahoo.com", "I like sunny weather", "pfp_1.jpg", "duckie");
        serverModelSignUp.addUser(user);
        assertTrue(serverModelSignUp.usernameExists("duckTheGoose"));
    }
}