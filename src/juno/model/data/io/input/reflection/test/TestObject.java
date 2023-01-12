package juno.model.data.io.input.reflection.test;

import juno.model.card.Card;

public class TestObject {

    private int integerField;

    private String stringField;

    private Card objectField;

   public TestObject(int integerField,
                     String stringField,
                     Card objectField) {
       this.integerField = integerField;
       this.stringField = stringField;
       this.objectField = objectField;
   }

    public String getStringField() {
        return stringField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    public Card getObjectField() {
        return objectField;
    }

    public void setObjectField(Card objectField) {
        this.objectField = objectField;
    }

    public int getIntegerField() {
        return integerField;
    }

    public void setIntegerField(int integerField) {
        this.integerField = integerField;
    }
}