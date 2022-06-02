package musicApp;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.concurrent.Task;
import musicApp.client.core.ClientFactory;
import musicApp.client.core.ModelFactory;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import musicApp.database.ConnectionFactory;

import java.sql.Connection;

public class MusicApp extends Application {
    private ModelFactory modelFactory;
    private ViewHandler vh;
    ConnectionFactory connectionFactory;

    /**
     * This method starts the viewHandler and opens the first scene
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        vh.start();
    }

    /**
     * This will initialize all the factories and connect to the database until the scene is built
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnection();
        ClientFactory clientFactory = new ClientFactory();
        this.modelFactory = new ModelFactory(clientFactory);
        ViewModelFactory vmf = new ViewModelFactory(modelFactory);
        this.vh = new ViewHandler(vmf);
    }

    /**
     * When the user stops the application the system will shut down, and he will disconnect from the app
     * @throws Exception
     */
    @Override
    public void stop() throws Exception {
        super.stop();
        modelFactory.getLoginManager().disconnect();
        connectionFactory.close();
        Platform.exit();
        System.exit(0);
    }
}
