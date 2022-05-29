package musicApp.server.model.login;

import musicApp.server.model.register.ServerModelSignUp;
import musicApp.server.model.register.ServerModelSignUpImpl;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ServerModelLoginTest {
    private ServerModelLogin serverModelLogin;

    @BeforeEach
    public void setUp() {
        serverModelLogin = new ServerModelLoginImpl();
    }
}