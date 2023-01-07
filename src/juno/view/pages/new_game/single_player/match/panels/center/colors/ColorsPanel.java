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

package juno.view.pages.new_game.single_player.match.panels.center.colors;

import juno.controller.log_out.Restorable;
import juno.controller.new_game.controller.Controller;
import juno.controller.util.GSetterAction;
import juno.model.subjects.shift.TurnMover;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

/**
 * This class defines the colors panel.
 * @author Simone Gentili
 */
public class ColorsPanel
        extends JPanel
        implements Observer, Restorable {

    // The ColorsPanel instance.
    private static ColorsPanel instance;

    // Builds the ColorsPanel instance.
    private ColorsPanel() {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    /**
     * Returns the ColorsPanel instance.
     * @return The ColorsPanel instance.
     */
    public static ColorsPanel getInstance() {
        if(instance == null) instance = new ColorsPanel();
        return instance;
    }

    @Override
    public void update(@NotNull Object object) {
        // The update comes from the
        // CardEffectController class.
        if(object instanceof Controller) {
            for(Component c : getComponents()) c.setEnabled(true);
        } else if(object instanceof GSetterAction<?>) {
            restore();
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". Controller type expected.");
    }

    @Override
    public void restore() {
        for(Component c : getComponents()) c.setEnabled(false);
    }

}