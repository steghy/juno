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

package juno.view.card.factory;

import juno.init.Directories;
import juno.model.card.InterfaceCard;
import juno.model.deck.InterfaceDeckFactory;
import juno.model.deck.InterfaceDeckInitializer;
import juno.model.util.Observable;
import juno.model.util.Observer;
import juno.view.card.InterfaceButtonCard;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class GraphicCardsFactory
        extends AbstractGraphicCardsFactory<InterfaceCard>
        implements InterfaceGraphicCard<InterfaceCard>,
                    InterfaceGraphicCardsGenerator<InterfaceCard>,
                    Observer, Observable {

    // The Observers List.
    private final List<Observer> observerList;

    // The GraphicCardsFactory instance.
    private static GraphicCardsFactory instance;

    // Builds the GraphicCardsFactory.
    private GraphicCardsFactory() {
        observerList = new ArrayList<>();
    }

    /**
     * Returns the GraphicCardsFactory instance.
     * @return The GraphicCardsFactory instance.
     */
    public static GraphicCardsFactory getInstance() {
        if(instance == null) instance = new GraphicCardsFactory();
        return instance;
    }

    @Override
    public Map<InterfaceCard, InterfaceButtonCard<InterfaceCard>> getGraphicCards() {
        return null;
    }

    @Override
    public void generate(@NotNull List<InterfaceCard> cards) {

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