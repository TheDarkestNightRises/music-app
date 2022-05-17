package musicApp.database.profile;

import musicApp.database.ConnectionFactory;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.User;

import java.sql.*;
import java.util.ArrayList;

public class ProfileDAOImpl implements ProfileDAO {
    private static ProfileDAOImpl instance;
    public static String URL = "jdbc:postgresql://abul.db.elephantsql.com:5432/viinvdnw";
    public static String USERNAME = "viinvdnw";
    public static String PASSWORD = "RYTBFOCvnjTJFnAoOA-XeuvHE7sdLyV-";
    private Connection connection;

    private ProfileDAOImpl() throws SQLException {
        try {
            this.connection = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public static synchronized ProfileDAO getInstance() throws SQLException {
        if (instance == null) {
            instance = new ProfileDAOImpl();
        }
        return ProfileDAOImpl.instance;
    }

//    private Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(ProfileDAOImpl.URL,
//                ProfileDAOImpl.USERNAME, ProfileDAOImpl.PASSWORD);
//    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }



    //  public User createUser(String username, String password, String email)
//  {
//    try (Connection connection = getConnection())
//    {
//      PreparedStatement statement1 = connection.prepareStatement("SET SCHEMA 'music_app'");
//      PreparedStatement statement = connection.prepareStatement("INSERT INTO User_(username, password_, email, nickname, profile_picture_path, description) "
//          + "VALUES (?, ?, ?, ?, ?, ?);");
//      statement.setString(1, username);
//      statement.setString(2,password);
//      statement.setString(3,email);
//      statement.setString(4,email);
//      statement.setString(5,email);
//      statement.setString(6,email);
//      statement1.executeUpdate();
//      statement.executeUpdate();
//      return new User(username,password);
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//    return null;
//  }
    @Override
    public ArrayList<Playlist> fetchPlaylistsForUser(User user) {
        try {
            PreparedStatement statement1 = connection.prepareStatement("SET SCHEMA 'music_app'");
            PreparedStatement statement = connection.prepareStatement("SELECT playlist_id, title, description, picture_path "
                    + "FROM playlist WHERE username = ?;");
            statement.setString(1, user.getUsername());
            statement1.executeUpdate();
            ResultSet rs = statement.executeQuery();
            ArrayList<Playlist> playlists = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("playlist_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String picture = rs.getString("picture_path");
                Playlist playlist = new Playlist(id, title, description, picture);
                playlists.add(playlist);
            }
            return playlists;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Integer> getSongIdsByPlaylist(Playlist playlist) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement1 = connection.prepareStatement("SET SCHEMA 'music_app'");
            PreparedStatement statement = connection.prepareStatement("SELECT song_id "
                    + "FROM playlist_song_pair WHERE playlist_id = ?;");
            statement.setInt(1, playlist.getPlaylist_id());
            statement1.executeUpdate();
            ResultSet rs = statement.executeQuery();
            ArrayList<Integer> songs = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("song_id");

                songs.add(id);
            }
            return songs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUserInfo(User user) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement0 = connection.prepareStatement(
                    "SET SCHEMA 'music_app'");
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE user_ SET nickname = ?, profile_picture_path = ?, description = ? "
                            + "WHERE username = ?");
            statement.setString(1, user.getNickname());
            statement.setString(2, user.getProfile_picture());
            statement.setString(3, user.getDescription());
            statement.setString(4, user.getUsername());
            statement0.executeUpdate();
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
