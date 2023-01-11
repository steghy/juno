/*
 *
 * MIT License
 *
 * Copyright (c) 2022 Simone Gentili
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package juno.model.util;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

/**
 * this class defines a donut.
 * @author Simone Gentili
 * @param <T> The type of the Donut elements.
 */
public class Donut<T>
        extends ArrayList<T> {

    /** The index of the current element of the Donut. */
    private int index;

    /** The inverted boolean value. */
    private boolean inverted;

    /** Builds a Donut object. */
    public Donut() {
        inverted = false;
    }

    /**
     * sets the current object randomly
     */
    public void initialize() {
        if(this.isEmpty()) {
            throw new IllegalArgumentException("Empty donut");
        } Random random = new Random();
       index = random.nextInt(size());
    }

    /**
     * sets the current object with
     * the specified index.
     * @param index An integer.
     */
    public void initialize(int index) {
        if(size() <= index || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index
            + " for length " + size());
        }
        this.index = index;
    }

    /**
     * Sets the current object to the specified object.
     * @param object An Object.
     */
    public void initialize(@NotNull T object) {
        if(!contains(object)) throw new IllegalArgumentException(
                "The specified object is not in " + this);
        index = indexOf(object);
    }

    /**
     * Reverses the sense in which
     * subsequent objects are considered.
     */
    public void invert() {
        inverted = !inverted;
    }

    /**
     * Move the index of the current object
     * to the next object and return it.
     * @return An Object.
     */
    public T next() {
        if(inverted) {
            return counterclockwise();
        } else {
            return clockwise();
        }
    }

    /**
     * Returns the previous object
     * to the current one.
     * @return An Object.
     */
    public T previous() {
        if(inverted) {
            return clockwise();
        } else {
            return counterclockwise();
        }
    }

    /**
     * Returns the current object.
     * @return An Object.
     */
    public T current() {
        if(size() == 0) {
            throw new IllegalArgumentException("Empty donut");
        } return get(index);
    }

    /**
     * Return the next object without moving
     * the current index.
     * @return An Object.
     */
    public T peek() {
        T el = next();
        previous();
        return el;
    }

    /**
     * Set the direction of this donut clockwise.
     * and returns the next object.
     * @return An Object.
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


    /**
     * Set the direction of this donut
     * counterclockwise and returns the
     * next object.
     * @return An Object.
     */
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