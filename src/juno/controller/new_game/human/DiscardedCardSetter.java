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

package juno.controller.new_game.human;

import juno.model.deck.AbstractDiscardedPileUser;
import juno.model.util.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class defines a discarded card setter.
 * @author Simone Gentili
 * @param <T> The type of the card.
 */
public class DiscardedCardSetter<T>
        extends AbstractDiscardedPileUser<T>
        implements Setter<T>, Provider<T>, Observable {

    // The last object involved.
    private T object;

    // The card remover.
    private Remover<T> remover;

    // The Observers list.
    private final List<Observer> observableList;

    // The DiscardedCardSetter instance.
    private static DiscardedCardSetter<?> instance;

    // Builds the DiscardedCardSetter instance.
    private DiscardedCardSetter() {
        observableList = new ArrayList<>();
    }

    /**
     * Returns the DiscardedCardSetter instance.
     * @return The DiscardedCardSetter instance.
     */
    public static DiscardedCardSetter<?> getInstance() {
        if(instance == null) instance = new DiscardedCardSetter<>();
        return instance;
    }

    /**
     * Sets the remover of this object.
     * @param remover A Remover object.
     */
    public void setRemover(@NotNull Remover<T> remover) {
        this.remover = remover;
    }

    @Override
    public void set(@NotNull T object) {
        updateAll();
        remover.remove(object);
        Objects.requireNonNull(getDiscardedPile()).discard(object);
        this.object = object;
    }

    @Override
    @Nullable
    public T provide() {
        return object;
    }

    @Override
    public boolean addObserver(@NotNull Observer observer) {
        return observableList.add(observer);
    }

    @Override
    public boolean removeObserver(@NotNull Observer observer) {
        return observableList.remove(observer);
    }

    @Override
    public void updateAll() {
        observableList.forEach(observer -> observer.update(this));
    }

}