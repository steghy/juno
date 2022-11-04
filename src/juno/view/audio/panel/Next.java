package juno.view.audio.panel;

public class Next extends Button {

    private static Next instance;

    private Next() { super(); }

    public static Next getInstance() {
       if(instance == null) {
           instance = new Next();
       } return instance;
    }
}
