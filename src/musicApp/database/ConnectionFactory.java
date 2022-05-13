package musicApp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
    public static String URL = "jdbc:postgresql://abul.db.elephantsql.com:5432/viinvdnw";
    public static String USERNAME = "viinvdnw";
    public static String PASSWORD = "RYTBFOCvnjTJFnAoOA-XeuvHE7sdLyV-";

    private static Connection connection;
    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
    }

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }
        return connection;
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }

//    public boolean open() {
//        try {
//            connection = DriverManager.getConnection(CONNECTION_STRING);
//            querySongInfoView = connection.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
//            insertIntoArtists = connection.prepareStatement(INSERT_ARTIST);
//            insertIntoAlbums = connection.prepareStatement(INSERT_ALBUMS);
//            insertIntoSongs = connection.prepareStatement(INSERT_SONGS);
//            queryArtist = connection.prepareStatement(QUERY_ARTIST);
//            queryAlbum = connection.prepareStatement(QUERY_ALBUM);
//            queryAlbumByArtistId = connection.prepareStatement(QUERY_ALBUMS_BY_ARTIST_ID);
//            updateArtistName = connection.prepareStatement(UPDATE_ARTIST_NAME);
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public void close() {
//        try {
//            if (querySongInfoView != null) {
//                querySongInfoView.close();
//            }
//            if (insertIntoAlbums != null) {
//                insertIntoAlbums.close();
//            }
//            if (insertIntoSongs != null)
//                insertIntoSongs.close();
//            if (insertIntoArtists != null) {
//                insertIntoArtists.close();
//            }
//            if (queryArtist != null) {
//                queryArtist.close();
//            }
//            if (queryAlbum != null) {
//                queryAlbum.close();
//            }
//            if (queryAlbumByArtistId != null) {
//                queryAlbumByArtistId.close();
//            }
//            if (updateArtistName != null) {
//                updateArtistName.close();
//            }
//            if (connection != null) {
//                connection.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
