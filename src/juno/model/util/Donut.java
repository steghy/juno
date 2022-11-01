package juno.model.util;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author steghy
 */
public class Donut<T> extends ArrayList<T> {

    /* The index of the current item */
    private int index;

    private boolean inverted;

    /**
     * Builds a Donut object
     */
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

    /**
     * Invert the order of this object
     */
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

    /**
     * Returns the current Item
     * @return The current Item
     */
    public T current() {
        if(size() == 0) {
            throw new IllegalArgumentException("Empty donut");
        } return get(index);
    }

    /**
     * Returns the index of the current
     * selected item.
     * @return An object of type T.
     */
    public int getCurrentIndex() {
        return index;
    }

    /**
     * Peeks the next item.
     * @return The next item.
     */
    public T peek() {
        T el = next();
        previous();
        return el;
    }

    /**
     * Returns the next item contained in
     * this Donut object.
     * @return An item of type T
     */
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

}