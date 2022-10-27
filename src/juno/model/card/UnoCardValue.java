package juno.model.card;

public enum UnoCardValue implements AbstractUnoCardValue {

    ZERO,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    HEIGHT,
    NINE;

    @Override
    public boolean isValueZero() {
        return this.name().equals("ZERO");
    }

    @Override
    public boolean isValueOne() {
        return this.name().equals("ONE");
    }

    @Override
    public boolean isValueTwo() {
        return this.name().equals("TWO");
    }

    @Override
    public boolean isValueThree() {
        return this.name().equals("THREE");
    }

    @Override
    public boolean isValueFour() {
        return this.name().equals("FOUR");
    }

    @Override
    public boolean isValueFive() {
        return this.name().equals("FIVE");
    }

    @Override
    public boolean isValueSix() {
        return this.name().equals("SIX");
    }

    @Override
    public boolean isValueSeven() {
        return this.name().equals("SEVEN");
    }

    @Override
    public boolean isValueEight() {
        return this.name().equals("HEIGHT");
    }

    @Override
    public boolean isValueNine() {
        return this.name().equals("NINE");
    }

    @Override
    public String toString(){
       return this.name();
    }
}