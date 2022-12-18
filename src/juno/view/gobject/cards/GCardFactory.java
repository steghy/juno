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

package juno.view.gobject.cards;

import juno.model.card.InterfaceCard;
import juno.model.deck.InterfaceDeckFactory;
import juno.model.util.Observable;
import juno.model.util.Observer;
import juno.view.gobject.AbstractGObjectFactory;
import juno.view.gobject.InterfaceGObject;
import juno.view.gobject.InterfaceGObjectCreator;
import juno.view.gobject.InterfaceGObjectGenerator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * @author Simone Gentili
 */
public class GCardFactory
        extends AbstractGObjectFactory<InterfaceCard>
        implements InterfaceGObjectGenerator<InterfaceCard>, Observer, Observable {

    // The Observers List.
    private final List<Observer> observerList;

    // The graphic cards.
    private List<InterfaceGObject<InterfaceCard>> gCards;

    // The GCardFactory instance.
    private static GCardFactory instance;

    // Builds the GCardFactory.
    private GCardFactory() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the GCardFactory instance.
     * @return The GCardFactory instance.
     */
    public static GCardFactory getInstance() {
        if(instance == null) instance = new GCardFactory();
        return instance;
    }

    @Override @Nullable
    public List<InterfaceGObject<InterfaceCard>> getGObjects() {
        return gCards;
    }

    @Override
    public void generate(@NotNull List<InterfaceCard> cards) {
        gCards = new ArrayList<>();
        InterfaceGObjectCreator<InterfaceCard> gCardCreator = getCreator();
        Objects.requireNonNull(gCardCreator);
        cards.forEach(card ->
                gCards.add(gCardCreator.create(card)));
        updateAll();
    }

    @Override
    public void addObserver(@NotNull Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

    @Override @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceDeckFactory<?> factory)
            generate((List<InterfaceCard>) Objects.requireNonNull(factory.getDeck()));
        else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceDeckInitialized expected.");
    }

}