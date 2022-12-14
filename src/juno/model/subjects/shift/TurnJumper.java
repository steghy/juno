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

package juno.model.subjects.shift;

import juno.model.util.Donut;
import juno.model.util.Provider;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class defines a turn jumper.
 * @author Simone Gentili
 * @param <T> The type of the players.
 */
public class TurnJumper<T>
        extends AbstractPlayersMaintainer<T>
        implements InterfaceTurnMover, Observable, Observer {

    // The Observer List.
    private final List<Observer> observerList;

    // The TurnJumper instance.
    private static TurnJumper<?> instance;

    // Builds the TurnJumper instance.
    private TurnJumper() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the TurnJumper instance.
     * @return The TurnJumper instance.
     */
    public static TurnJumper<?> getInstance(){
        if(instance == null) instance = new TurnJumper<>();
        return instance;
    }

    @Override
    public void next() {
        Objects.requireNonNull(players).next();
        updateAll();
    }

    @Override
    public boolean addObserver(@NotNull Observer observer) {
        return observerList.add(observer);
    }

    @Override
    public boolean removeObserver(@NotNull Observer observer) {
        return observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof Provider<?> provider)
            players = (Donut<T>) provider.provide();
        else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceProvider type expected.");
    }

}