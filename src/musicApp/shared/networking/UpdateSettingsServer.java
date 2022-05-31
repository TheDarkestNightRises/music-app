package musicApp.shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UpdateSettingsServer extends Remote
{

  void updateUserInfo(String username, String password, String email,
      String nickname, String description) throws RemoteException;
  String uploadImage(String username, byte[] bytes) throws RemoteException;
}
