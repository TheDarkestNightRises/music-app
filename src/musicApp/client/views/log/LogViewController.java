package musicApp.client.views.log;

import musicApp.client.core.ViewController;
import musicApp.client.core.ViewHandler;
import musicApp.client.core.ViewModelFactory;
import musicApp.shared.LogEntry;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LogViewController implements ViewController
{

  @FXML private TableView<LogEntry> tableview;
  @FXML public TableColumn<String, LogEntry> date;
  @FXML public TableColumn<String, LogEntry> time;
  @FXML public TableColumn<String, LogEntry> text;

  private ViewHandler viewHandler;
  private LogViewModel logViewModel;

  @FXML public void back()
  {
    viewHandler.openChat();
  }

  @Override public void init(ViewHandler vh, ViewModelFactory vmf,Object... args)
  {
    viewHandler = vh;
    logViewModel = vmf.getLogViewModel();
    logViewModel.loadLogs();
    tableview.setItems(logViewModel.getLogs());
    text.setCellValueFactory(new PropertyValueFactory<>("text"));
    date.setCellValueFactory(new PropertyValueFactory<>("date"));
    time.setCellValueFactory(new PropertyValueFactory<>("time"));
  }

}
