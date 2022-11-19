package juno.view.factories.buttons;

public class MyObject {

    private String value;
    private int value2;

    public MyObject(String value, int value2) {
        this.value =  value;
        this.value2 = value2;
    }

    public String toString() {
        return "value: " + value + " value2: " + value2;
    }
}
