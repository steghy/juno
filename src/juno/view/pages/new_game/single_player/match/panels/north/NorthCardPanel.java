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

package juno.view.pages.new_game.single_player.match.panels.north;

import juno.controller.util.InterfaceInitializer;
import juno.model.subjects.ai.AI;
import juno.model.util.Observer;
import juno.view.button.Button;
import juno.view.button.ButtonCreator;
import juno.view.util.ImageResizer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Simone Gentili
 */
public class NorthCardPanel
        extends JPanel
        implements Observer {

    // The NorthCardPanel instance.
    private static NorthCardPanel instance;

    // Builds the NorthCardPanel instance.
    private NorthCardPanel() {
        setOpaque(false);
        setLayout(new GridLayout(1, 108));
    }

    /**
     * Returns the NorthCardPanel instance.
     * @return The NorthCardPanel instance.
     */
    public static NorthCardPanel getInstance() {
        if(instance == null) instance = new NorthCardPanel();
        return instance;
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof AI<?, ?> ai) {
            if(ai.getRemoved()) {
                int count = getComponentCount();
                if(count == 0) throw new IllegalArgumentException(
                        "There is no components to remove.");
                remove(getComponentCount() - 1);
            } else {
                AbstractButton button = ButtonCreator.getInstance().create(Button.COVER_TO_SOUTH);
                ImageResizer.resize(button, 4.5);
                add(button);
            }
        } else if(object instanceof InterfaceInitializer) {
            removeAll();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceAdder, InterfaceRemover " +
                        "or InterfaceInitializer type expected.");
        revalidate();
        repaint();
    }

}