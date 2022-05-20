package musicApp.client.model.register;

public interface SignUpManager
{
  boolean usernameExists(String username);

  void addUser(String username, String password, String email);

  boolean noDigits(String password);

  boolean noUpper(String password);

  boolean emailNotValid(String email);

  void addArtist(String username, String password, String email);
}
