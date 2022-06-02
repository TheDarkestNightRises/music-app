package musicApp.server.model.search;

import javafx.concurrent.Task;
import musicApp.database.album.AlbumDAOImpl;
import musicApp.database.album.AlbumDao;
import musicApp.server.model.domainModel.Album;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Task that will get all the albums from the database. Runs on separate thread
 */
public class GetAllAlbumsTask extends Task<ArrayList<Album>> {
    private AlbumDao albumDao;

    public GetAllAlbumsTask() {
        try {
            this.albumDao = AlbumDAOImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected ArrayList<Album> call()  {
        return albumDao.getAllAlbums();
    }
}
