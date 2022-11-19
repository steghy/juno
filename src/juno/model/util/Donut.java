package juno.model.util;

import java.util.ArrayList;
import java.util.Random;

public class Donut<T> extends ArrayList<T> {

    private int index;
    private boolean inverted;

    public Donut() {
        inverted = false;
    }

    public void initialize() {
        if(this.isEmpty()) {
            throw new IllegalArgumentException("Empty donut");
        }
       Random random = new Random();
       index = random.nextInt(size());
    }

    public void initialize(int index) {
        if(size() <= index || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index
            + " for length " + size());
        }
        this.index = index;
    }

    public void invert() {
        inverted = !inverted;
    }

    public T next() {
        if(inverted) {
            return counterclockwise();
        } else {
            return clockwise();
        }
    }

    public T previous() {
        if(inverted) {
            return clockwise();
        } else {
            return counterclockwise();
        }
    }

    public T current() {
        if(size() == 0) {
            throw new IllegalArgumentException("Empty donut");
        } return get(index);
    }

    public int getCurrentIndex() {
        return index;
    }

    public T peek() {
        T el = next();
        previous();
        return el;
    }

    private T clockwise() {
        if(size() == 0) {
            throw new IllegalArgumentException("Empty donut");
        } if(index == size() - 1) {
            index = 0;
        } else {
            index++;
        } return get(index);
    }


    private T counterclockwise() {
        if(size() == 0) {
            throw new IllegalArgumentException("Empty donut");
        } if(index == 0) {
            index = size() - 1;
        } else {
            index--;
        } return get(index);
    }

    public boolean isInverted() {
        return inverted;
    }
}