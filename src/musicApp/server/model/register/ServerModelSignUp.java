package musicApp.server.model.register;

import musicApp.util.Subject;

public interface ServerModelSignUp extends Subject
{
  boolean noDigits(String password);
  boolean noUpper(String password);
  boolean emailNotValid(String email);
}
