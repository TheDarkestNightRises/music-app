package musicApp.server.model.login;

import musicApp.server.model.domainModel.User;
import musicApp.database.users.UsersDAO;
import musicApp.database.users.UsersDAOImpl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Server model login.This server keeps track of the active online users and delegates everything else
 * to userDao
 */
public class ServerModelLoginImpl implements ServerModelLogin {

    private List<User> userList;
    private PropertyChangeSupport support;
    private UsersDAO userDAO;

    /**
     * The user list starts empty at first but then is filled with users as they sign in
     */
    public ServerModelLoginImpl() {
        this.userList = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);
    }

    /**
     * This method will sign in the method by adding the user to the list and setting his
     * online status to true
     * @param username to look for user in database
     * @param password to look for user in database
     * @return signed in user
     */
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

    /**
     * This method will disconnect the user when the user closes the app
     * @param user to know which one
     */
    @Override
    public synchronized void disconnect(User user) {
        if (user == null) return;
        for (User currentUser : userList) {
            if (currentUser.getUsername().equals(user.getUsername())) {
                currentUser.setLoggedIn(false);
                userList.remove(currentUser);
                break;
            }
        }
    }

    /**
     * This will return the number of users
     * @return int number of users
     */
    @Override
    public int getNumberOfUsers() {
        return userList.size();
    }

    /**
     * This method will check if the account does not exist in database
     * @param user
     * @return true if account doesNotExit,false either
     */
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

    /**
     * This method updates the user cached in the user list once a change has been made
     * @param username
     * @param password
     * @param email
     * @param nickname
     * @param description
     */
    @Override
    public void updateUserInfoInList(String username, String password,
                                     String email, String nickname, String description) {
        for (User currentUser : userList)
            if (currentUser.getUsername().equals(username)) {
                currentUser.setPassword(password);
                currentUser.setEmail(email);
                currentUser.setNickname(nickname);
                currentUser.setDescription(description);
                break;
            }

    }

    /**
     * This method checks if the user is online
     * @param user to see which user
     * @return true if user is online , false if user is offline
     */
    @Override
    public boolean isOnline(User user) {
        for (User value : userList)
            if (value.getUsername().equals(user.getUsername()))
                return true;
        return false;
    }

    /**
     * This method will update the picture path cache in the user list
     * @param username
     * @param path
     */

    @Override
    public void updatePicturePathForUser(String username, String path) {
        for (User currentUser : userList)
            if (currentUser.getUsername().equals(username)) {
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
