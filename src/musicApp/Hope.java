package musicApp;

import musicApp.database.users.UsersDAOImpl;

import java.sql.SQLException;

public class Hope
{
  public static void main(String[] args) throws SQLException
  {
    UsersDAOImpl.getInstance().createUser("Sexisforfree69","Sexisgreat1","fuck@yahoo.com");
  }
}
