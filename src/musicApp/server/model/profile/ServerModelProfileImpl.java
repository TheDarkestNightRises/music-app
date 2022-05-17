package musicApp.server.model.profile;

import musicApp.database.playlist.PlaylistDAO;
import musicApp.database.playlist.PlaylistDAOImpl;
import musicApp.database.profile.ProfileDAO;
import musicApp.database.profile.ProfileDAOImpl;
import musicApp.server.model.domainModel.Playlist;
import musicApp.server.model.domainModel.Song;
import musicApp.server.model.domainModel.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServerModelProfileImpl implements ServerModelProfile {
    private ProfileDAO profileDAO;
    private PlaylistDAO playlistDAO;

    public ServerModelProfileImpl() {
        try {
            profileDAO = ProfileDAOImpl.getInstance();
            playlistDAO = PlaylistDAOImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Playlist> fetchPlaylistsForUser(User user) {
        GetAllPlaylistsTask getAllPlaylistsTask = new GetAllPlaylistsTask(user);
        new Thread(getAllPlaylistsTask).start();
        try {
            return getAllPlaylistsTask.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
//        try {
//            profileDAO = ProfileDAOImpl.getInstance();
//            return profileDAO.fetchPlaylistsForUser(user);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
    }

    @Override
    public ArrayList<Song> fetchSongsForPlaylist(Playlist playlist) {
        GetAllSongsTask getAllSongsTask = new GetAllSongsTask(playlist);
        new Thread(getAllSongsTask).start();
        try {
            return getAllSongsTask.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
//        PlaylistDAO playlistDAO = null;
//        try {
//            playlistDAO = PlaylistDAOImpl.getInstance();
//            return playlistDAO.getAllSongsFromPlayList(playlist);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
    }
}
