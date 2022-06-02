package musicApp.client.core;

import musicApp.client.network.Client;
import musicApp.client.network.RMIClient;
import musicApp.client.network.chat.ChatClient;
import musicApp.client.network.login.LoginClient;
import musicApp.client.network.musicplayer.MusicPlayerClient;

/**
 * The client factory is responsible for creating the client. It uses the factory design pattern
 */
public class ClientFactory {
    private Client client;

    /**
     * The getClient() method is made with lazy instantiation
     * @return the client facade
     */
    public Client getClient() {
        if (client == null) {
            this.client = new RMIClient();
        }
        return client;
    }
}
