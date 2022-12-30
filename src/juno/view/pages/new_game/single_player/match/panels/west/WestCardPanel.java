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

package juno.view.pages.new_game.single_player.match.panels.west;

import juno.controller.log_out.Restorable;
import juno.controller.new_game.GameStarter;
import juno.model.card.InterfaceCard;
import juno.model.subjects.ai.AI;
import juno.model.util.Observer;
import juno.view.button.Button;
import juno.view.button.ButtonCreator;
import juno.view.gobject.cards.GCard;
import juno.view.gobject.cards.GCardCreator;
import juno.view.util.ImageResizer;
import juno.view.util.RotatedIcon;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class WestCardPanel
        extends JPanel
        implements Observer, Restorable {

    // The show card boolean value.
    private boolean showCard = true;

    // The WestCardPanel instance.
    private static WestCardPanel instance;

    // Builds the WestCardPanel instance.
    private WestCardPanel() {
        setOpaque(false);
        setLayout(new GridLayout(108, 1));
        setBackground(Color.GRAY);
    }

    /**
     * Returns the WestCardPanel instance.
     * @return The WestCardPanel instance.
     */
    public static WestCardPanel getInstance() {
        if(instance == null) instance = new WestCardPanel();
        return instance;
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof GameStarter)
            showCard = false;
        else if(object instanceof AI<?, ?> ai) {
            if(ai.getRemoved()) {
                int count = getComponentCount();
                if(count == 0) throw new IllegalArgumentException(
                        "There is no components to remove.");
                remove(getComponentCount() - 1);
            } else {
                AbstractButton gCard;
                if(showCard) {
                    InterfaceCard card = (InterfaceCard) ai.provide();
                    gCard = (GCard<InterfaceCard>)
                            GCardCreator.getInstance().create(Objects.requireNonNull(card), RotatedIcon.Rotate.DOWN);
                } else {
                    gCard = ButtonCreator.getInstance().create(Button.COVER, RotatedIcon.Rotate.DOWN);
                    ImageResizer.resize(gCard, 4.0);
                } add(gCard);
            }
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceAdder, InterfaceRemover " +
                        "or InterfaceInitializer type expected.");
        revalidate();
        repaint();
    }

    @Override
    public void restore() {
        setOpaque(false);
        removeAll();
        showCard = true;
        revalidate();
        repaint();
    }

}