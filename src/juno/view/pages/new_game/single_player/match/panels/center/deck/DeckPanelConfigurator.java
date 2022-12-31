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

package juno.view.pages.new_game.single_player.match.panels.center.deck;

import juno.controller.new_game.human.DrawAction;
import juno.controller.new_game.Mover;
import juno.model.subjects.shift.TurnMover;
import juno.view.button.Button;
import juno.view.button.ButtonCreator;
import juno.view.util.ImageResizer;

import javax.swing.*;

/**
 * @author Simone Gentili
 */
public class DeckPanelConfigurator {

    // Builds a DeckPanelConfigurator object.
    private DeckPanelConfigurator() {}

    /** Configure the DeckPanel instance. */
    public static void configure() {
        // Main Component.
        DeckPanel deckPanel = DeckPanel.getInstance();

        // Component.
        AbstractButton deckButton = ButtonCreator.getInstance().create(Button.COVER, null);

        // Image resizing.
        ImageResizer.resize(deckButton, 3.0);

        // Action listener.
        deckButton.addActionListener(DrawAction.getInstance());

        // Observer / Observable.
        TurnMover.getInstance().addObserver(deckPanel);
        DrawAction.getInstance().addObserver(deckPanel);

        // Main component setting.
        deckPanel.setFirstComponent(deckButton);

        // Main component initialization.
        deckPanel.init();
    }

}