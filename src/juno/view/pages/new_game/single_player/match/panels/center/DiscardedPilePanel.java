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

package juno.view.pages.new_game.single_player.match.panels.center;

import juno.controller.util.InterfaceInitializer;
import juno.model.card.InterfaceCard;
import juno.model.deck.InterfaceDiscardedPile;
import juno.model.util.InterfaceProvider;
import juno.model.util.Observer;
import juno.view.gobject.InterfaceGObjectMapFactory;
import juno.view.gobject.cards.GCard;
import juno.view.util.ImageResizer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class DiscardedPilePanel
        extends JPanel
        implements Observer {

    // The graphic cards factory.
    private InterfaceGObjectMapFactory<InterfaceCard> factory;

    // The top discarded pile card provider.
    private InterfaceProvider<InterfaceCard> provider;

    // The DiscardedPilePanel instance.
    private static DiscardedPilePanel instance;

    // Builds the DiscardedPilePanel instance.
    private DiscardedPilePanel() {
        setOpaque(false);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(150, 250));
    }

    /**
     * Returns the DiscardedPilePanel instance.
     * @return The DiscardedPilePanel instance.
     */
    public static DiscardedPilePanel getInstance() {
        if(instance == null) instance = new DiscardedPilePanel();
        return instance;
    }

    /**
     * Sets the top discarded pile card provider
     * of this object.
     * @param provider An InterfaceProvider object.
     */
    public void setProvider(@NotNull InterfaceProvider<InterfaceCard> provider) {
        this.provider = provider;
    }

    /**
     * Sets the graphic card factory of this object.
     * @param factory An InterfaceGObjectMapFactory object.
     */
    public void setFactory(@NotNull InterfaceGObjectMapFactory<InterfaceCard> factory) {
        this.factory = factory;
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceDiscardedPile<?>) {
            GCard<InterfaceCard> gCard = (GCard<InterfaceCard>)
                    factory.getGObjectsMap().get(provider.provide());
            removeAll();
            ImageResizer.resize(gCard, 1.5);
            add(gCard, BorderLayout.CENTER);
        } else if(object instanceof InterfaceInitializer) {
            removeAll();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        "InterfaceDiscardedPile or InterfaceInitializer" +
                        " type expected.");
        revalidate();
        repaint();
    }

}