package juno.model.util;

public class MyRandom extends java.util.Random {

    private static MyRandom instance;

    private MyRandom() {}

    public static MyRandom getInstance() {
        if(instance == null) {
            instance = new MyRandom();
        } return instance;
    }
}
