package musicApp.client.network.register;

import musicApp.shared.networking.RMIServer;

public interface SignUpClient
{
  void addUser(String username, String password, String email);

  boolean usernameExists(String username);

  boolean noDigits(String password);

  boolean noUpper(String password);

  boolean emailNotValid(String email);

  void addArtist(String username, String password, String email);
}
