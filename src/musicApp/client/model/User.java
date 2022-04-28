package musicApp.client.model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable
{

  private String username;
  private String password;
  private String email;
  private boolean isLoggedIn;

  public User(String username, String password, String email)
  {
    this.username = username;
    this.password = password;
    this.email = email;
  }


  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  public String getEmail()
  {
    return email;
  }


  @Override public int hashCode()
  {
    return Objects.hash(username, password);
  }


  public boolean isLoggedIn() {
    return isLoggedIn;
  }

  public void setLoggedIn(boolean loggedIn) {
    isLoggedIn = loggedIn;
  }

  @Override
  public String toString() {
    return "User{" +
            "username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", isLoggedIn=" + isLoggedIn +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return isLoggedIn == user.isLoggedIn && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email);
  }

  public boolean equalsIgnoreEmail(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return isLoggedIn == user.isLoggedIn && Objects.equals(username, user.username) && Objects.equals(password, user.password);
  }
}
