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

package juno.controller.new_game.restorer;

import juno.controller.new_game.controller.Mover;
import juno.controller.new_game.dispenser.CardDispenser;
import juno.controller.new_game.dispenser.OneCardDispenser;
import juno.controller.new_game.human.CardTimer;
import juno.controller.new_game.penalty.PenaltyExecutor;
import juno.controller.util.InterfaceInitializer;
import juno.model.deck.ActualColorManager;
import juno.model.deck.Deck;
import juno.model.deck.DiscardedPile;
import juno.model.subjects.human.HumanPlayer;
import juno.view.pages.new_game.single_player.match.panels.center.actual_color.ActualColorPanel;
import juno.view.pages.new_game.single_player.match.panels.center.circle.CirclePanel;
import juno.view.pages.new_game.single_player.match.panels.center.colors.ColorsPanel;
import juno.view.pages.new_game.single_player.match.panels.center.deck.DeckPanel;
import juno.view.pages.new_game.single_player.match.panels.center.discarded_pile.DiscardedPilePanel;
import juno.view.pages.new_game.single_player.match.panels.center.uno_button.UnoButtonPanel;
import juno.view.pages.new_game.single_player.match.panels.east.EastCardPanel;
import juno.view.pages.new_game.single_player.match.panels.north.NorthCardPanel;
import juno.view.pages.new_game.single_player.match.panels.south.SouthCardPanel;
import juno.view.pages.new_game.single_player.match.panels.west.WestCardPanel;

import java.util.List;

/**
 * @author Simone Gentili
 */
public class Initializer
        implements InterfaceInitializer {

    // The Initializer instance.
    private static Initializer instance;

    // Builds the Initializer instance.
    private Initializer() {}

    /**
     * Returns the Initializer instance.
     * @return The Initializer instance.
     */
    public static Initializer getInstance() {
        if(instance == null) instance = new Initializer();
        return instance;
    }

    @Override
    public void initialize() {
        // Stopper.
        Stopper stopper = Stopper.getInstance();
        stopper.getStoppableList().addAll(List.of(
                CardTimer.getInstance(),
                Mover.getInstance(),
                PenaltyExecutor.getInstance(),
                CardDispenser.getInstance(),
                OneCardDispenser.getInstance()));

        // Restorer.
        Restorer restorer = Restorer.getInstance();
        restorer.getRestorableList().addAll(List.of(
                HumanPlayer.getInstance(),
                Deck.getInstance(),
                DiscardedPile.getInstance(),
                ActualColorManager.getInstance(),
                ActualColorPanel.getInstance(),
                CirclePanel.getInstance(),
                ColorsPanel.getInstance(),
                DeckPanel.getInstance(),
                DiscardedPilePanel.getInstance(),
                NorthCardPanel.getInstance(),
                SouthCardPanel.getInstance(),
                EastCardPanel.getInstance(),
                WestCardPanel.getInstance(),
                UnoButtonPanel.getInstance()));

        // Observer / Observable.
        stopper.addObserver(restorer);
    }

}