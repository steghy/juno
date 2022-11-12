package juno.init;

public class ExitManager implements AbstractExitManager{

    private static ExitManager instance;

    private ExitManager() {}

    public static ExitManager getInstance() {
        if(instance == null) {
            instance = new ExitManager();
        } return instance;
    }

    public void exit() {
        System.exit(0);
    }
}
