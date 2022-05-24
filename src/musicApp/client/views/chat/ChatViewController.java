package musicApp.client.views.chat;

import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ChatViewController implements ViewController {
    @FXML private ListView<String> chatView;
    @FXML private TextField message;
    @FXML private Label user;
    private ViewHandler vh;
    private ChatViewModel viewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf,Object... args) {
        this.vh = vh;
        this.viewModel = vmf.getChatViewModel();
        viewModel.fetchNumberOfOnlineUsers();
        viewModel.bindChat(chatView.itemsProperty());
        viewModel.bindMessage(message.textProperty());
        viewModel.bindUser(user.textProperty());
    }
    @FXML protected void viewLogButtonPressed()
    {
       vh.openLog();
    }
    @FXML protected void sendButtonPressed()
    {
        viewModel.send();
    }
    @FXML protected void backToHomepage(){vh.openMainMenu();}

}
