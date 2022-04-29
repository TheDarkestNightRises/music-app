package musicApp.client.network.profile;

import musicApp.shared.networking.RMIServer;

public class RMIProfileClient implements ProfileClient{
    private RMIServer rmiServer;


    @Override
    public void setServer(RMIServer server) {
        this.rmiServer = rmiServer;
    }
}
