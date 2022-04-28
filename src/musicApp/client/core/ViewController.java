package musicApp.client.core;


public interface ViewController {
    void init(ViewHandler vh, ViewModelFactory vmf);
//    void init(ViewHandler vh, ViewModelFactory vmf, Object[] args); //TODO: overload init and make playlist init.
}
