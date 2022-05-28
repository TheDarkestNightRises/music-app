package musicApp.server.model.chat.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DefaultLog
{
  private final CurrentTime currentTime;
  private final File logDirectory;
  private static DefaultLog instance;

  private DefaultLog()
  {
    String homePath = System.getProperty("user.home");

    logDirectory = new File(homePath, "Downloads");
    currentTime = new CurrentTime();
  }

  private File getLogFile()
  {
    String fileName = "Log-" + currentTime.getFormattedIsoDate() + ".txt";
    return new File(logDirectory, fileName);
  }

  public void log(String message) throws IOException
  {
    try (FileWriter fileWriter = new FileWriter(getLogFile(), true); PrintWriter writer = new PrintWriter(fileWriter))
    {
      String logLine = currentTime.getFormattedTime() + " - " + message;
      writer.println(logLine);
    }
  }

  public CurrentTime getCurrentTime()
  {
    return currentTime;
  }

  public static synchronized DefaultLog getInstance()
  {
    if (instance == null)
    {
      instance = new DefaultLog();
    }
    return instance;
  }

  public File getLogDirectory()
  {
    return logDirectory;
  }
}
