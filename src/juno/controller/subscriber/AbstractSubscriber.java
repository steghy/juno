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

package juno.controller.subscriber;

import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * @author Simone Gentili
 */
public abstract class AbstractSubscriber
        implements Subscriber, Unsubscriber {

    // The Observer object.
    private Observer observer;

    // The Observable object.
    private Observable observable;

    @Override
    public void subscribe() {
        if(!Objects.requireNonNull(getObservable()).addObserver(getObserver()))
            throw new IllegalArgumentException(
                    "It was not possible to subscribe the following " +
                            "Observer object (" + observer + ")" +
                            " to this Observable object + (" + observable + ")");
    }

    @Override
    public void unsubscribe() {
        if(!Objects.requireNonNull(getObservable()).removeObserver(getObserver()))
            throw new IllegalArgumentException(
                    "It was not possible to unsubscribe the following " +
                            "Observer object (" + observer + ")" +
                            " to this Observable object (" + observable + ")");
    }

    /**
     * Sets the Observer object of this
     * object.
     * @param observer An Observer object.
     */
    public void setObserver(@NotNull Observer observer) {
        this.observer = observer;
    }

    /**
     * Sets the Observable object of this
     * object.
     * @param observable An Observable object.
     */
    public void setObservable(@NotNull Observable observable) {
        this.observable = observable;
    }

    /**
     * Returns the Observer object of
     * this object.
     * @return An Observer object.
     */
    @Nullable
    public Observer getObserver() {
        return observer;
    }

    /**
     * Returns the Observable object.
     * @return An Observable object.
     */
    @Nullable
    public Observable getObservable() {
        return observable;
    }

}