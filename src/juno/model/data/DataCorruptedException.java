package juno.model.data;

public class DataCorruptedException extends Exception{

    private Constant IF_CORRUPTED;

    public DataCorruptedException(String message, Constant IF_CORRUPTED) {
        super(message);
        this.IF_CORRUPTED = IF_CORRUPTED;
    }

    public DataCorruptedException(Constant IF_CORRUPTED) {
        this.IF_CORRUPTED = IF_CORRUPTED;
    }

    public Constant getIF_CORRUPTED() {
        return IF_CORRUPTED;
    }
}
