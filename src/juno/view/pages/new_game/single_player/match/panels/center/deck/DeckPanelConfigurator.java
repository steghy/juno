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

import juno.controller.new_game.DrawAction;
import juno.controller.new_game.GameInitializer;
import juno.controller.new_game.Mover;
import juno.controller.new_game.NextTurnAction;
import juno.model.card.InterfaceCard;
import juno.model.deck.Deck;
import juno.model.deck.InterfaceDeck;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.human.HumanPlayer;
import juno.model.subjects.shift.TurnMover;
import juno.view.button.Button;
import juno.view.button.ButtonCreator;
import juno.view.util.ImageResizer;
import juno.view.util.RotatedIcon;

import javax.swing.*;

/**
 * @author Simone Gentili
 */
public class DeckPanelConfigurator {

    // Builds a DeckPanelConfigurator object.
    private DeckPanelConfigurator() {}

    /** Configure the DeckPanel instance. */
    @SuppressWarnings("unchecked")
    public static void configure() {
        // Main Component.
        DeckPanel deckPanel = DeckPanel.getInstance();

        // Component.
        AbstractButton deckButton = ButtonCreator.getInstance().create(Button.COVER, RotatedIcon.Rotate.ABOUT_CENTER);

        // Image resizing.
        ImageResizer.resize(deckButton, 2.5);

        // Action listener.
        deckButton.addActionListener(new DrawAction<>(
                (InterfacePlayer<InterfaceCard>) HumanPlayer.getInstance(),
                (InterfaceDeck<InterfaceCard>) Deck.getInstance()));
        deckButton.addActionListener(new NextTurnAction(TurnMover.getInstance()));

        // Observer / Observable.
        Mover.getInstance().addObserver(deckPanel);

        // Main component setting.
        deckPanel.setFirstComponent(deckButton);

        // Main component initialization.
        deckPanel.init();
    }

}