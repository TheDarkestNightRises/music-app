package musicApp.client.views.log;

import musicApp.client.model.MainModel;
import musicApp.client.model.chat.ChatManager;
import musicApp.shared.LogEntry;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class LogViewModel
{

  private ObservableList<LogEntry> logItems;
  private MainModel mainModel;
  private StringProperty date;
  private StringProperty time;
  private StringProperty text;

  public LogViewModel(MainModel mainModel)
  {

    this.logItems = new SimpleListProperty<>(FXCollections.observableArrayList());
    this.mainModel = mainModel;
    mainModel.getChatManager().addListener("NewLogEntry", this::onNewLogEntry);
    this.date = new SimpleStringProperty("");
    this.time = new SimpleStringProperty("");
    this.text = new SimpleStringProperty("");
  }

  private void onNewLogEntry(PropertyChangeEvent evt) {
    logItems.add((LogEntry)evt.getNewValue());
  }

  void loadLogs() {
    List<LogEntry> logList = mainModel.getChatManager().getLog();
    logItems = FXCollections.observableArrayList(logList);
  }


  ObservableList<LogEntry> getLogs() {
    return logItems;
  }

}

