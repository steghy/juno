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

package juno.view.pages.new_game.single_player.match.panels.center.discarded_pile;

import juno.controller.log_out.Restorable;
import juno.model.card.InterfaceCard;
import juno.model.deck.InterfaceDiscardedPile;
import juno.model.util.Provider;
import juno.model.util.Observer;
import juno.view.gobject.GObjectButton;
import juno.view.gobject.InterfaceGObjectCreator;
import juno.view.util.ImageResizer;
import juno.view.util.RotatedIcon;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * This class defines the Discarded pile panel
 * @author Simone Gentili
 */
public class DiscardedPilePanel
        extends
        JPanel
        implements
        Observer,
        Restorable {

    /** The graphic card creator. */
    private InterfaceGObjectCreator<InterfaceCard> creator;

    /** The provider. */
    private Provider<InterfaceCard> provider;

    /** The default component. */
    private Component c;

    // The DiscardedPilePanel instance.
    private static DiscardedPilePanel instance;

    // Builds the DiscardedPilePanel instance.
    private DiscardedPilePanel() {
        setOpaque(false);
        setLayout(new BorderLayout());
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
    public void setProvider(@NotNull Provider<InterfaceCard> provider) {
        this.provider = provider;
    }

    /**
     * Sets the graphic card creator of this object.
     * @param creator An InterfaceGObjectCreator object.
     */
    public void setCreator(@NotNull InterfaceGObjectCreator<InterfaceCard> creator) {
        this.creator = creator;
    }

    /**
     * Sets the default component of this object.
     * @param c A Component.
     */
    public void setDefaultComponent(Component c) {
        this.c =c;
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceDiscardedPile<?>) {
            GObjectButton<InterfaceCard> gCard = (GObjectButton<InterfaceCard>)
                    creator.create(provider.provide(), RotatedIcon.Rotate.ABOUT_CENTER);
            ImageResizer.getInstance().resize(gCard, 2.2);
            removeAll();
            gCard.setEnabled(false);
            add(gCard, BorderLayout.CENTER);
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        "InterfaceDiscardedPile or InterfaceInitializer" +
                        " type expected.");
        revalidate();
        repaint();
    }

    @Override
    public void restore() {
        removeAll();
        add(c, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

}