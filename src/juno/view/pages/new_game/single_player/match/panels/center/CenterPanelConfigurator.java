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

package juno.view.pages.new_game.single_player.match.panels.center;

import juno.controller.new_game.ActionTest;
import juno.controller.new_game.DrawAction;
import juno.controller.new_game.NextTurnAction;
import juno.controller.new_game.StartGameAction;
import juno.model.card.InterfaceCard;
import juno.model.deck.Deck;
import juno.model.deck.InterfaceDeck;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.human.HumanPlayer;
import juno.model.subjects.shift.TurnMover;
import juno.view.button.Button;
import juno.view.button.ButtonCreator;
import juno.view.util.ImageResizer;

import javax.swing.*;

/**
 * @author Simone Gentili
 */
public class CenterPanelConfigurator {

    // Builds a CenterPanelConfigurator object.
    private CenterPanelConfigurator() {}

    @SuppressWarnings("unchecked")
    public static void configure() {
        // Center panel.
        CenterPanel centerPanel = CenterPanel.getInstance();

        // Deck button.
        ButtonCreator creator = ButtonCreator.getInstance();
        AbstractButton deckButton = creator.create(Button.COVER_TO_NORTH);
        ImageResizer.resize(deckButton, 2.5);
        deckButton.addActionListener(new DrawAction<>(
                (InterfacePlayer<InterfaceCard>) HumanPlayer.getInstance(),
                (InterfaceDeck<InterfaceCard>) Deck.getInstance()));
        deckButton.addActionListener(new NextTurnAction(TurnMover.getInstance()));

        // Start button.
        AbstractButton startButton = creator.create(Button.START);
        ImageResizer.resize(startButton, 2.5);
        startButton.addActionListener(StartGameAction.getInstance());

        // Button test.
        AbstractButton buttonTest = ButtonCreator.getInstance().create(Button.CONFIRM);
        ImageResizer.resize(buttonTest, 4.5);
        buttonTest.addActionListener(new ActionTest());


        // Settings.
        centerPanel.setFirstComponent(CirclePanel.getInstance());
        centerPanel.setSecondComponent(deckButton);
        centerPanel.setThirdComponent(DiscardedPilePanel.getInstance());
        centerPanel.setFourthComponent(startButton);

        // Initialization.
        centerPanel.init();
    }

}