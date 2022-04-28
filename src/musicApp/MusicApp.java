package musicApp;

import javafx.application.Platform;
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
    public void stop() throws Exception {
        super.stop();
        modelFactory.getMainModel().getLogInManager().disconnect(); //TODO: BREAK LAW OF DEMETER
        Platform.exit();
        System.exit(0);
    }
}
