package musicApp;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Platform;
import javafx.application.Preloader;
import musicApp.client.core.ClientFactory;
import musicApp.client.core.ModelFactory;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class MusicApp extends Application {
    private ModelFactory modelFactory;

    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory clientFactory = new ClientFactory();
        this.modelFactory = new ModelFactory(clientFactory);
        ViewModelFactory vmf = new ViewModelFactory(modelFactory);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }

    @Override
    public void init() throws Exception {
        //Heavy calculation connecting to database whatever.
        double limit = 500000;
        for (int i = 0; i < 500000; i++) {
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
