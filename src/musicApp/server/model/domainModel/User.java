package musicApp.server.model.domainModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class User implements Serializable
{

  private String username;
  private String password;
  private String email;
  private String description;
  private String profile_picture;
  private String nickname;
  private boolean isLoggedIn;
  private ArrayList<Playlist> playlists;

  public User(String username, String password)
  {
    this.username = username;
    this.password = password;
  }

  public User(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }

  public User(String username, String password, String email, String nickname, String profile_picture, String description,
              ArrayList<Playlist> playlists)
  {
    this.username = username;
    this.password = password;
    this.email = email;
    this.nickname = nickname;
    this.profile_picture = profile_picture;
    this.description = description;
    this.playlists = new ArrayList<>();
  }

  public User(String username, String password, String email, String description, String profile_picture, String nickname)
  {
    this.username = username;
    this.password = password;
    this.email = email;
    this.description = description;
    this.profile_picture = profile_picture;
    this.nickname = nickname;
  }

  public User()
  {
  }

  ;

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

  public String getDescription()
  {
    return description;
  }

  public String getNickname()
  {
    return nickname;
  }

  public String getProfile_picture()
  {
    return profile_picture;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public void setNickname(String nickname)
  {
    this.nickname = nickname;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public void setProfile_picture(String profile_picture)
  {
    this.profile_picture = profile_picture;
  }

  @Override public int hashCode()
  {
    return Objects.hash(username, password);
  }

  public boolean isLoggedIn()
  {
    return isLoggedIn;
  }

  public void setLoggedIn(boolean loggedIn)
  {
    isLoggedIn = loggedIn;
  }

  public ArrayList<Playlist> getPlaylists()
  {
    return playlists;
  }

  @Override public String toString()
  {
    return "User{" + "username='" + username + '\'' + ", password='" + password + '\'' + ", email='" + email + '\''
        + ", description='" + description + '\'' + ", profile_picture='" + profile_picture + '\'' + ", nickname='" + nickname
        + '\'' + ", isLoggedIn=" + isLoggedIn + ", playlists=" + playlists + '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    User user = (User) o;
    return isLoggedIn == user.isLoggedIn && Objects.equals(username, user.username) && Objects.equals(password,
        user.password) && Objects.equals(email, user.email);
  }

  public boolean equalsIgnoreEmail(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    User user = (User) o;
    return isLoggedIn == user.isLoggedIn && Objects.equals(username, user.username) && Objects.equals(password,
        user.password);
  }

}
