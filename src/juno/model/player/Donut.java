package juno.model.player;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author steghy
 */
public class Donut<T> extends ArrayList<T> {

    /* The index of the current item */
    private int index;

    /**
     * Builds a Donut object
     */
    public Donut() {}

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
     * Returns the next item contained in
     * this Donut object.
     * @return An item of type T
     */
    public T next() {
        if(size() == 0) {
            throw new IllegalArgumentException("Empty donut");
        } if(index == size() - 1) {
            index = 0;
        } else {
            index++;
        } return get(index);
    }


    public T previous() {
        if(size() == 0) {
            throw new IllegalArgumentException("Empty donut");
        } if(index == 0) {
            index = size() - 1;
        } else {
            index--;
        } return get(index);
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
}