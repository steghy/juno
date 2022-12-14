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

package juno.view.pages.new_game.single_player.match.panels.center.uno_button;

import juno.controller.log_out.Restorable;
import juno.controller.new_game.penalty.PenaltyTimer;
import juno.model.util.Observer;
import juno.view.panels.AbstractFirstComponent;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;


/**
 * This class defines an uno button panel
 * @author Simone Gentili
 */
public class UnoButtonPanel
        extends AbstractFirstComponent
        implements Observer, Restorable {

    // The UnoButton instance.
    private static UnoButtonPanel instance;

    // Builds the UnoButton instance.
    private UnoButtonPanel() {}

    /**
     * Returns the UnoButton instance.
     * @return The UnoButton instance.
     */
    public static UnoButtonPanel getInstance() {
        if(instance == null) instance = new UnoButtonPanel();
        return instance;
    }

    /** Initialize the UnoButtonPanel instance. */
    public void init() {
        setOpaque(false);
        setLayout(new BorderLayout());
        add(Objects.requireNonNull(getFirstComponent()), BorderLayout.CENTER);
        getFirstComponent().setEnabled(false);
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof PenaltyTimer penaltyTimer) {
            Objects.requireNonNull(getFirstComponent())
                    .setEnabled(penaltyTimer.getTimer().isRunning());
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". UnoCardController type expected.");
    }

    @Override
    public void restore() {
        Objects.requireNonNull(getFirstComponent()).setEnabled(false);
    }

}