package musicApp.server.model.login;

import musicApp.server.model.domainModel.User;
import musicApp.database.users.UsersDAO;
import musicApp.database.users.UsersDAOImpl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServerModelLoginImpl implements ServerModelLogin {

    private List<User> userList;
    private PropertyChangeSupport support;
    private UsersDAO userDAO;

    public ServerModelLoginImpl() {
        this.userList = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);
    }

    @Override
    public User signIn(String username, String password) {
        try {
            for (User currentUser : userList)
                if (currentUser.isLoggedIn() && currentUser.getUsername()
                        .equals(username))
                    return null;
            if (UsersDAOImpl.getInstance().accountExists(username, password)) {
                User userLogged = UsersDAOImpl.getInstance().getUserByName(username);
                userLogged.setLoggedIn(true);
                //System.out.println(userLogged);
                userList.add(userLogged);
                System.out.println(userList);
                return userLogged;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public synchronized void disconnect(User user) {
        if (user == null) return;
        for (User currentUser : userList) {
            if (currentUser.getUsername().equals(user.getUsername()))
            {
                currentUser.setLoggedIn(false);
                userList.remove(currentUser);
                break;
            }
        }
    }

    @Override
    public int getNumberOfUsers() {
        return userList.size();
    }

    @Override
    public boolean accountDoesNotExist(User user) {
        try {
            this.userDAO = new UsersDAOImpl();
            if (!this.userDAO.accountExists(user.getUsername(), user.getPassword()))
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override public void updateUserInfoInList(String username, String password,
        String email, String nickname, String description)
    {
        for (User currentUser : userList)
            if (currentUser.getUsername().equals(username))
            {
                currentUser.setPassword(password);
                currentUser.setEmail(email);
                currentUser.setNickname(nickname);
                currentUser.setDescription(description);
                break;
            }

    }

    @Override public boolean isOnline(User user)
    {
        for(User value: userList)
            if(value.getUsername().equals(user.getUsername()))
             return true;
        return false;
    }

    @Override public void updatePicturePathForUser(String username, String path)
    {
        for (User currentUser : userList)
            if (currentUser.getUsername().equals(username))
            {
                currentUser.setProfile_picture(path);
                break;
            }
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }

    public List<User> getUserList() {
        return userList;
    }
}
