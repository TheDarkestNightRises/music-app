package musicApp.util;

import java.beans.PropertyChangeListener;

public interface Subject {
    void addListener(String eventName, PropertyChangeListener listener);
    void removeListener(String eventName, PropertyChangeListener listener);
}
