package musicApp.client.network.search;

import musicApp.server.model.domainModel.Song;
import musicApp.shared.networking.RMIServer;

import java.util.ArrayList;

public interface SearchClient {

    void searchSong(String search);

    void searchAlbum(String search);

    void searchProfile(String search);
}
