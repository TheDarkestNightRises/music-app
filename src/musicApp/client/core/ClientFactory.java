package musicApp.client.core;

import musicApp.client.network.Client;
import musicApp.client.network.RMIClient;
import musicApp.client.network.chat.ChatClient;
import musicApp.client.network.login.LoginClient;
import musicApp.client.network.musicplayer.MusicPlayerClient;

public class ClientFactory {
    private Client client;
    private LoginClient loginClient;
    private MusicPlayerClient musicPlayerClient;
    private ChatClient chatClient;

    public Client getClient() {
        if (client == null) {
            this.client = new RMIClient();
        }
        return client;
    }
}
