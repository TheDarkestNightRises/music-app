package musicApp.server.model.login;

import musicApp.server.model.domainModel.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServerModelLoginTestWithDatabase {
    private ServerModelLogin serverModelLogin;

    @BeforeEach
    public void setUp() {
        serverModelLogin = new ServerModelLoginImpl();
        populateModelWithFakeData();
    }

    private void populateModelWithFakeData() {
        User[] users = {
                new User("Cosmin","lol"),
                new User("Ree","Lol"),
                new User("Dodo","Lol"),
        } ;
        serverModelLogin.getUserList().addAll(List.of(users));
    }

    @Nested
    class ServelModelLoginZeroTest {
        @BeforeEach
        public void setUp() {
            serverModelLogin = new ServerModelLoginImpl();
        }

        @Test
        public void getNumberOfUsersIsZeroOnInitialization() {
            assertEquals(0,serverModelLogin.getNumberOfUsers());
        }

        @Test
        public void listSizeIsZeroOnInitialization() {
            assertEquals(0,serverModelLogin.getUserList().size());
        }
    }


    @Test
    public void getNumberOfUsers() {
        assertEquals(serverModelLogin.getNumberOfUsers(),3);
    }

    @Test
    public void afterSignInTheUserIsInList() {
        User user = serverModelLogin.signIn("cosmin","Qwerty1234");
        assertTrue(serverModelLogin.getUserList().contains(user));
    }

    @Test
    public void afterSignInTheUserIsActive() {
        User user = serverModelLogin.signIn("cosmin","Qwerty1234");
        assertTrue(user.isLoggedIn());
    }

    @Test
    public void afterSignInTheNumberOfUserIncreases() {
        User user = serverModelLogin.signIn("cosmin","Qwerty1234");
        assertEquals(serverModelLogin.getNumberOfUsers(),4);
    }

    @Test
    public void userIsLoggedOffAfterDisconnect() {
        User user = serverModelLogin.signIn("cosmin","Qwerty1234");
        serverModelLogin.disconnect(user);
        assertFalse(user.isLoggedIn());
    }

    @Test
    public void accountExistsInDatabase() {
        User user = serverModelLogin.signIn("cosmin","Qwerty1234");
        assertFalse(serverModelLogin.accountDoesNotExist(user));
    }
    @Test
    public void isOnlineAfterSignIn() {
        User user = serverModelLogin.signIn("cosmin","Qwerty1234");
        assertTrue(serverModelLogin.isOnline(user));
    }

    @Test
    public void updateUserInfo() {
        User user = serverModelLogin.signIn("cosmin","Qwerty1234");
        //Changed the description of the user
        serverModelLogin.updateUserInfoInList("cosmin","Qwerty1234","teodoru@gmail.ro",
                "cos12","I am duck");
        assertEquals(user.getDescription(),"I am duck");
    }

}