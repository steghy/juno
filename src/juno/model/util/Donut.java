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

import java.util.ArrayList;
import java.util.Random;

public class Donut<T>
        extends ArrayList<T> {

    private int index;
    private boolean inverted;

    public Donut() {
        inverted = false;
    }

    public void initialize() {
        if(this.isEmpty()) {
            throw new IllegalArgumentException("Empty donut");
        } Random random = new Random();
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