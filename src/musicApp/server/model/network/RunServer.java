package musicApp.server.model.network;

import musicApp.server.model.ServerModelImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args) throws AlreadyBoundException, RemoteException {
        RMIServerImpl rmiServer = new RMIServerImpl(new ServerModelImpl());
        rmiServer.startServer();
        System.out.println("Server started...");
    }
}
