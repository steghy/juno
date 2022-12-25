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

import juno.model.subjects.InterfaceAdder;
import juno.model.subjects.InterfaceRemover;
import juno.model.util.Observer;
import juno.view.button.Button;
import juno.view.button.ButtonCreator;
import juno.view.util.ImageResizer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class WestCardPanel
        extends JPanel implements Observer {

    // The WestCardPanel instance.
    private static WestCardPanel instance;

    // Builds the WestCardPanel instance.
    private WestCardPanel() {
        setOpaque(false);
        setLayout(new GridLayout(108, 1));
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
        if(object instanceof InterfaceAdder<?>) {
            AbstractButton button = ButtonCreator.getInstance().create(Button.COVER_TO_EAST);
            ImageResizer.resize(button, 4.5);
            add(button);
            revalidate();
            repaint();
        } else if (object instanceof InterfaceRemover<?>) {
            int count = getComponentCount();
            if(count == 0) throw new IllegalArgumentException(
                    "There is no components to remove.");
            remove(getComponentCount() - 1);
            revalidate();
            repaint();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceAdder or InterfaceRemover type expected.");
    }

}