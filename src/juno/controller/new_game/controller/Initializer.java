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

package juno.controller.new_game.controller;

import juno.controller.new_game.penalty.PenaltyExecutor;
import juno.controller.new_game.penalty.PenaltyTimer;
import juno.controller.new_game.restorer.Stopper;
import juno.controller.util.InterfaceInitializer;
import juno.controller.util.PanelChanger;
import juno.model.card.InterfaceCard;
import juno.model.data.score.GamesWonCounter;
import juno.model.data.score.LostGamesCounter;
import juno.model.deck.CardEffectActivator;
import juno.model.deck.Deck;
import juno.model.deck.DiscardedPile;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.shift.CurrentPlayerProvider;
import juno.model.subjects.shift.TurnMover;
import juno.view.pages.new_game.single_player.card.SinglePlayerCardPanel;

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
    @SuppressWarnings("unchecked")
    public void initialize() {
        // Win condition controller.
        WinConditionController<InterfaceCard> winConditionController =
                (WinConditionController<InterfaceCard>) WinConditionController.getInstance();

        // One card controller.
        OneCardController<InterfaceCard> oneCardController =
                (OneCardController<InterfaceCard>) OneCardController.getInstance();

        // Card effect controller.
        CardEffectController cardEffectController = CardEffectController.getInstance();

        // Card effect activator.
        CardEffectActivator cardEffectActivator = CardEffectActivator.getInstance();

        // Current player provider.
        CurrentPlayerProvider<InterfacePlayer<InterfaceCard>> currentPlayerProvider =
                (CurrentPlayerProvider<InterfacePlayer<InterfaceCard>>) CurrentPlayerProvider.getInstance();

        // Stopper.
        Stopper stopper = Stopper.getInstance();

        // Discarded pile
        DiscardedPile<InterfaceCard> discardedPile =
                (DiscardedPile<InterfaceCard>) DiscardedPile.getInstance();

        // Penalty executor.
        PenaltyExecutor<InterfaceCard> penaltyExecutor =
                (PenaltyExecutor<InterfaceCard>) PenaltyExecutor.getInstance();

        // Penalty timer.
        PenaltyTimer penaltyTimer = PenaltyTimer.getInstance();

        // Turn mover.
        TurnMover<InterfacePlayer<InterfaceCard>> turnMover =
                (TurnMover<InterfacePlayer<InterfaceCard>>) TurnMover.getInstance();

        // Deck.
        Deck<InterfaceCard> deck = (Deck<InterfaceCard>) Deck.getInstance();

        // First discarded card manager.
        FirstDiscardedCardManager firstDiscardedCardManager = FirstDiscardedCardManager.getInstance();

        // Winner manager.
        WinnerManager winnerManager = WinnerManager.getInstance();

        // CountersManager.
        CountersManager<InterfaceCard> countersManager =
                (CountersManager<InterfaceCard>) CountersManager.getInstance();

        //////////////////////////////////////////////////////////////////////////////////////

        // Win condition controller.
        discardedPile.addObserver(winConditionController);
        winConditionController.setProvider(currentPlayerProvider);

        // One card controller.
        winConditionController.addObserver(oneCardController);
        oneCardController.setProvider(currentPlayerProvider);
        oneCardController.setPenaltyExecutor(penaltyExecutor);
        oneCardController.setPenaltyTimer(penaltyTimer);

        // Penalty executor.
        penaltyExecutor.setDeck(deck);
        penaltyExecutor.setProvider(currentPlayerProvider);
        penaltyTimer.addObserver(penaltyExecutor);

        // Card effect activator.
        penaltyExecutor.addObserver(cardEffectController);
        oneCardController.addObserver(cardEffectController);
        cardEffectController.setProvider(currentPlayerProvider);
        cardEffectController.setActivator(cardEffectActivator);
        cardEffectController.setTurnMover(turnMover);
        cardEffectController.setDiscardedPile(discardedPile);

        // First discarded card.
        firstDiscardedCardManager.setDiscardedPile(discardedPile);
        firstDiscardedCardManager.setDeck(deck);

        // Winner manager.
        winnerManager.setPanelChanger(new PanelChanger(
                SinglePlayerCardPanel.getInstance(), SinglePlayerCardPanel.WINNER_PANEL));
        winnerManager.setStopper(stopper);

        countersManager.setLostGamesCounter(LostGamesCounter.getInstance());
        countersManager.setGamesWonCounter(GamesWonCounter.getInstance());
        countersManager.setProvider(currentPlayerProvider);
        winnerManager.addObserver(countersManager);
    }

}