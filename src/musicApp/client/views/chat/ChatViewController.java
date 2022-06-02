package musicApp.client.views.chat;

import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * This is the chat view controller
 */
public class ChatViewController implements ViewController {
    @FXML
    private ListView<String> chatView;
    @FXML
    private TextField message;
    @FXML
    private Label user;
    private ViewHandler vh;
    private ChatViewModel viewModel;

    /**
     * This is the constructor for the chat view model.It ask the viewModel
     * bind this UI elements to the view model properties
     *
     * @param vh   to open windows
     * @param vmf  to initialize the ChatViewModel
     * @param args -
     */
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Object... args) {
        this.vh = vh;
        this.viewModel = vmf.getChatViewModel();
        viewModel.fetchNumberOfOnlineUsers();
        viewModel.bindChat(chatView.itemsProperty());
        viewModel.bindMessage(message.textProperty());
        viewModel.bindUser(user.textProperty());
    }

    /**
     * This is method is linked to the openLog button.
     * On action it will open the log window
     */
    @FXML
    protected void viewLogButtonPressed() {
        vh.openLog();
    }

    /**
     * This method is linked to the send button. It will delegate the viewModel.
     */
    @FXML
    protected void sendButtonPressed() {
        viewModel.send();
    }

    /**
     * This is method is linked to the mainMenu button.
     * On action it will open the main menu window
     */
    @FXML
    protected void backToHomepage() {
        vh.openMainMenu();
    }

}
