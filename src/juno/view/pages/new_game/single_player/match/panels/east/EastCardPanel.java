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

package juno.view.pages.new_game.single_player.match.panels.east;

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
public class EastCardPanel
        extends JPanel
        implements Observer {

    // The EastCardPanel instance.
    private static EastCardPanel instance;

    // Builds the EastCardPanel instance.
    private EastCardPanel() {
        setLayout(new GridLayout(10, 1));
        setOpaque(false);
    }

    /**
     * Returns the EastCardPanel instance.
     * @return The EastCardPanel instance.
     */
    public static EastCardPanel getInstance() {
        if(instance == null) instance = new EastCardPanel();
        return instance;
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceAdder<?>) {
            AbstractButton button = ButtonCreator.getInstance().create(Button.COVER_TO_WEST);
            ImageResizer.resize(button, 4.5);
            add(button);
            repaint();
        } else if (object instanceof InterfaceRemover<?>) {
            remove(getComponentCount() - 1);
            repaint();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceAdder or InterfaceRemover type expected.");
    }

}