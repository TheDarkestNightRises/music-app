package musicApp.client.core;

/**
 * This interface must be implemented by all ViewControllers. When a view is instantiated the ViewHandler
 * will call the init function. 
 */
public interface ViewController {
     void init(ViewHandler vh, ViewModelFactory vmf, Object... args);
}
