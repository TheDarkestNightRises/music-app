package musicApp.server.network.search;

import musicApp.server.model.ServerModel;
import musicApp.server.model.domainModel.Song;
import musicApp.shared.networking.SearchServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class SearchServerImpl implements SearchServer {
    private ServerModel serverModel;

    public SearchServerImpl(ServerModel serverModel) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.serverModel = serverModel;
    }

    @Override
    public ArrayList<Song> fetchSortedList() {
        return serverModel.getModelSearch().fetchSortedList();
    }

    @Override
    public void search(String newValue) {
        serverModel.getModelSearch().search(newValue);
    }
}
