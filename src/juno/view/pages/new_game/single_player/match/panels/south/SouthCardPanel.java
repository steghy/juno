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

package juno.view.pages.new_game.single_player.match.panels.south;

import juno.controller.new_game.Mover;
import juno.controller.util.InterfaceInitializer;
import juno.model.card.InterfaceCard;
import juno.model.subjects.InterfaceAdder;
import juno.model.subjects.InterfaceRemover;
import juno.model.util.InterfaceProvider;
import juno.model.util.Observer;
import juno.view.gobject.cards.GCard;
import juno.view.gobject.cards.GCardMapFactory;
import juno.view.util.ImageResizer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class SouthCardPanel
        extends JPanel
        implements Observer {

    // The card provider.
    private InterfaceProvider<InterfaceCard> provider;

    // The SouthCardPanel instance.
    private static SouthCardPanel instance;

    // Builds the SouthCardPanel instance.
    private SouthCardPanel() {
        setOpaque(false);
        GridLayout gridLayout = new GridLayout(1, 108);
        gridLayout.setVgap(0);
        gridLayout.setHgap(0);
        setLayout(gridLayout);
    }

    /**
     * Returns the SouthCardPanel instance.
     * @return The SouthCardPanel instance.
     */
    public static SouthCardPanel getInstance() {
        if(instance == null) instance = new SouthCardPanel();
        return instance;
    }

    /**
     * Sets the card provider of this object.
     * @param provider An InterfaceProvider object.
     */
    public void setProvider(@NotNull InterfaceProvider<InterfaceCard> provider) {
        this.provider = provider;
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceAdder<?>) {
            InterfaceCard card = provider.provide();
            GCard<InterfaceCard> gCard = (GCard<InterfaceCard>)
                    Objects.requireNonNull(GCardMapFactory.getInstance().getGObjectsMap()).get(card);
            ImageResizer.resize(gCard, 2.5);
            add(gCard);
        } else if(object instanceof InterfaceRemover<?>) {
            InterfaceCard card = provider.provide();
            GCard<InterfaceCard> gCard = (GCard<InterfaceCard>)
                    Objects.requireNonNull(GCardMapFactory.getInstance().getGObjectsMap()).get(card);
            remove(gCard);
        } else if(object instanceof InterfaceInitializer) {
            removeAll();
        } else if(object instanceof Mover) {
            
        } else throw new IllegalArgumentException(
                    "Invalid object type: " + object.getClass() +
                            ". InterfaceAdder, InterfaceRemover " +
                            "or InterfaceInitializer type expected.");
        revalidate();
        repaint();
    }

}