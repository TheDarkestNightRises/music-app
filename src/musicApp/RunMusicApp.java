package musicApp;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import musicApp.client.views.loadingScreen.MyPreloader;

/**
 * This will launch the loading screen that will wait until the factories and the connection to the
 * database is built
 */
public class RunMusicApp
{
  public static void main(String[] args)
  {
    LauncherImpl.launchApplication(MusicApp.class, MyPreloader.class, args);
  }
}
