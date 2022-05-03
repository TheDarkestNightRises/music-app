package musicApp.client.views.loadingScreen;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MyPreloader extends Preloader {
    private Stage preloaderStage;
    private Scene scene;
    private LoadingScreenViewController loadingScreenViewController;

    @Override
    public void init() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("LoadingScreenView.fxml"));
        Parent root = loader.load();
        loadingScreenViewController = loader.getController();
        scene = new Scene(root);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.preloaderStage = stage;
        preloaderStage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        stage.setTitle("lol");
    }


    @Override
    public void handleApplicationNotification(PreloaderNotification preloaderNotification) {
        if (preloaderNotification instanceof ProgressNotification) {
            loadingScreenViewController.setTextProgress("Loading .." + ((ProgressNotification) preloaderNotification).getProgress() % 100 + "%");
        }
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification stateChangeNotification) {
        StateChangeNotification.Type type = stateChangeNotification.getType();
        switch (type){
            case BEFORE_START -> {
                System.out.println("BEFORE_START");
                preloaderStage.close();
                break;
            }
        }
    }


}
