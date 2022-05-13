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

    @Override
    public void start(Stage stage) throws Exception {
        vh.start();
    }

    @Override
    public void init() throws Exception {
        //Heavy calculation connecting to database whatever.
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnection();
        ClientFactory clientFactory = new ClientFactory();
        this.modelFactory = new ModelFactory(clientFactory);
        ViewModelFactory vmf = new ViewModelFactory(modelFactory);
        this.vh = new ViewHandler(vmf);
        double limit = 10000;
        for (int i = 0; i < limit; i++) {
            double progress = (100 * i) / limit;
            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        modelFactory.getMainModel().getLogInManager().disconnect(); //TODO: BREAK LAW OF DEMETER
        Platform.exit();
        System.exit(0);
    }
}
