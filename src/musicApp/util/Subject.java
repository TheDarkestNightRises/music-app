package musicApp.util;

import java.beans.PropertyChangeListener;

/**
 * Subject interface used for the observer pattern
 */
public interface Subject {
    void addListener(String eventName, PropertyChangeListener listener);
    void removeListener(String eventName, PropertyChangeListener listener);
}
