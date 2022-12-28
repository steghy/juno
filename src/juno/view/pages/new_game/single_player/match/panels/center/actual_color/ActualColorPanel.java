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

package juno.view.pages.new_game.single_player.match.panels.center.actual_color;

import juno.controller.util.InterfaceInitializer;
import juno.model.card.colors.InterfaceColor;
import juno.model.deck.InterfaceActualColor;
import juno.model.util.Observer;
import juno.view.gobject.InterfaceGObjectMapFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class ActualColorPanel
        extends JPanel
        implements Observer {

    // The graphic color map factory.
    private InterfaceGObjectMapFactory<InterfaceColor> mapFactory;

    // The ActualColorPanel instance.
    private static ActualColorPanel instance;

    // Builds the ActualColorPanel instance.
    private ActualColorPanel() {
        setOpaque(true);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(75, 75));
    }

    /**
     * Returns the ActualColorPanel instance.
     * @return The ActualColorPanel instance.
     */
    public static ActualColorPanel getInstance() {
        if(instance == null) instance = new ActualColorPanel();
        return instance;
    }

    /**
     * Sets the graphic color map factory of
     * this object.
     * @param mapFactory An interfaceGObjectMapFactory object.
     */
    public void setMapFactory(@NotNull InterfaceGObjectMapFactory<InterfaceColor> mapFactory) {
        this.mapFactory = mapFactory;
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceActualColor<?> actualColor) {
            Object temp = actualColor.provide();
            if(temp instanceof InterfaceColor color) {
                add((Component) mapFactory.getGObjectsMap().get(color), BorderLayout.CENTER);
            } else throw new IllegalArgumentException(
                    "Invalid object type: " + temp.getClass() +
                            ". InterfaceColor type expected.");
        } else if(object instanceof InterfaceInitializer) {
            setBackground(Color.lightGray);
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceActualColor expected.");
        revalidate();
        repaint();
    }

}