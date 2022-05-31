package musicApp.server.network.updateSettings;

import musicApp.server.model.ServerModelFactory;
import musicApp.server.model.login.ServerModelLogin;
import musicApp.server.model.updateSettings.ServerModelUpdateSettings;
import musicApp.shared.networking.UpdateSettingsServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UpdateSettingsServerImpl implements UpdateSettingsServer {


    private final ServerModelUpdateSettings serverModelUpdateSettings;
    private final ServerModelLogin serverModelLogin;

    public UpdateSettingsServerImpl(ServerModelFactory serverModelFactory) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModelUpdateSettings = serverModelFactory.getModelUpdateSettings();
        this.serverModelLogin = serverModelFactory.getModelLogin();
    }

    @Override
    public void updateUserInfo(String username, String password, String email,
        String nickname, String description) {
        try {
            serverModelUpdateSettings.updateUserInfo(username, password, email, nickname, description);
            serverModelLogin.updateUserInfoInList(username, password, email, nickname, description);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String uploadImage(String username, byte[] bytes) {
        String path = serverModelUpdateSettings.uploadPicture(username, bytes);
        if (path != null) {
            serverModelLogin.updatePicturePathForUser(username, path);
        }
        return path;
    }
}
