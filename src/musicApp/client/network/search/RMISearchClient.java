package musicApp.client.network.search;

import musicApp.server.model.domainModel.Song;
import musicApp.shared.networking.RMIServer;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RMISearchClient implements SearchClient{
    private RMIServer server;

    @Override
    public void setServer(RMIServer server) {
        this.server = server;
    }

    @Override
    public ArrayList<Song> fetchSortedList() {
        try {
            return server.getSearchServer().fetchSortedList();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void search(String newValue) {
        try {
            server.getSearchServer().search(newValue);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
