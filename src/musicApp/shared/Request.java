package musicApp.shared;

import java.io.Serializable;

public class Request implements Serializable {
    private String type;
    private Object arg;

    public Request(String type,Object arg) {
        this.type = type;
        this.arg = arg;
    }

    public String getType() {
        return type;
    }

    public Object getArg() {
        return arg;
    }
}