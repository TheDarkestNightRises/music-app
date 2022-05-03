package musicApp;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import musicApp.client.views.loadingScreen.MyPreloader;

public class RunMusicApp {
    public static void main(String[] args) {
//        Application.launch(MusicApp.class);
        LauncherImpl.launchApplication(MusicApp.class,MyPreloader.class,args);
    }
}
