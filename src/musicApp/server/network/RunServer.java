package musicApp.server.network;

import musicApp.server.model.ServerModelFactory;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class  RunServer {
    public static void main(String[] args) throws AlreadyBoundException, RemoteException {
        RMIServerImpl rmiServer = new RMIServerImpl(new ServerModelFactory());
        rmiServer.startServer();
        System.out.println("Server started...");
    }
}
