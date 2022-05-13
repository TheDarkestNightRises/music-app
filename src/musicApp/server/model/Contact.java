package musicApp.server.model;

import java.io.Serializable;

public class Contact implements Serializable
{
  private String username;

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }
}
