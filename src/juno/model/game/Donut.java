package juno.model.game;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author steghy
 */
public class Donut<E> extends ArrayList<E> {

    private int index;

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
     * Sets the next item
     */
    public E next() {
        if(index == size() - 1) {
            index = 0;
        } else {
            index++;
        }
        return get(index);
    }


    public E previous() {
        if(index == 0) {
            index = size() - 1;
        } else {
            index--;
        }
        return get(index);
    }


    /**
     * Returns the current Item
     * @return The current Item
     */
    public E current() {
        return get(index);
    }
}