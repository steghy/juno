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

package juno.controller;

import juno.model.subjects.temp.human.InterfaceReceiver;
import juno.view.card.InterfaceButtonCard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

/**
 * @author Simone Gentili
 * @param <T> The type of the input.
 */
public class Receiver<T>
        extends Thread
        implements InterfaceReceiver<T>, ActionListener {

    // The input.
    private T input;

    // The seconds.
    private int seconds;

    // The Receiver instance.
    private static Receiver<?> instance;

    // Builds the Receiver instance.
    private Receiver() {}

    /**
     * Returns the Receiver instance.
     * @return The Receiver instance.
     */
    public static Receiver<?> getInstance() {
        if(instance == null) instance = new Receiver<>();
        return instance;
    }

    @Override
    public T receive() {
        this.start();
        return input;
    }

    @Override @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent e) {
        if(e instanceof InterfaceButtonCard<?> buttonCard) {
            input = (T) buttonCard.card();
            this.interrupt();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + e.getClass() +
                "InterfaceButtonCard expected.");
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(seconds);
            input = null;
        } catch (InterruptedException ignored) {}
    }

    public void setSeconds(int seconds) {
        if(seconds < 0) throw new IllegalArgumentException(
                "Invalid input");
        this.seconds = seconds;
    }

}