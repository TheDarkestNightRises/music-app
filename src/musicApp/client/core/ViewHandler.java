package musicApp.client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private Scene chatScene;
    private Stage stage;
    private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
    }

    public void start() {
        stage = new Stage();
        openSignUp();
    }

    public void openChat() {
        if (chatScene == null) {
            try {
                Parent root = loadFXML("../views/chat/ChatView.fxml");
                stage.setTitle("Chat");
                chatScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setTitle("Chat");
        stage.setScene(chatScene);
        stage.show();
        stage.setResizable(false);
        stage.centerOnScreen();
    }

    public void openLog() {
        try {
            Parent root = loadFXML("../views/log/LogView.fxml");
            Scene logScene = new Scene(root);
            stage.setTitle("Log");
            stage.setScene(logScene);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openLogin(){
        try {
            Parent root = loadFXML("../views/login/LoginMain.fxml");
            Scene loginScene = new Scene(root);
            stage.setTitle("Login");
            stage.setScene(loginScene);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openSignUp(){
        try {
            Parent root = loadFXML("../views/signup/SignUpView.fxml");
            Scene signUp = new Scene(root);
            stage.setTitle("Sign Up");
            stage.setScene(signUp);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openMusicPlayer(){
        try {
            Parent root = loadFXML("../views/musicPlayer/MusicPlayer.fxml");
            Scene signUp = new Scene(root);
            stage.setTitle("Music Player");
            stage.setScene(signUp);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openProfile(){
        try {
            Parent root = loadFXML("../views/profile/ProfileView.fxml");
            Scene profile = new Scene(root);
            stage.setTitle("Profile");
            stage.setScene(profile);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void openFollowList(){
        try {
            Parent root = loadFXML("../views/followList/FollowList.fxml");
            Scene signUp = new Scene(root);
            stage.setTitle("FollowList");
            stage.setScene(signUp);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void openUpdateSettings(){
        try {
            Parent root = loadFXML("../views/updateSettingsS/UpdateSettingsView.fxml");
            Scene settingsScene = new Scene(root);
            stage.setTitle("Update settings");
            stage.setScene(settingsScene);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private Parent loadFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();
        ViewController ctrl = loader.getController();
        ctrl.init(this, vmf);
        return root;
    }

}

