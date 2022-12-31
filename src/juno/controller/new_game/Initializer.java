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

package juno.controller.new_game;

import juno.controller.new_game.dispenser.CardController;
import juno.controller.new_game.dispenser.CardDispenser;
import juno.controller.new_game.dispenser.OneCardDispenser;
import juno.controller.new_game.human.*;
import juno.controller.new_game.penalty.PenaltyExecutor;
import juno.controller.new_game.penalty.UnoCardController;
import juno.controller.util.InterfaceInitializer;
import juno.model.card.InterfaceCard;
import juno.model.deck.*;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.ai.InterfaceDifficulty;
import juno.model.subjects.factory.AiPlayerFactory;
import juno.model.subjects.human.HumanPlayer;
import juno.model.subjects.shift.CurrentPlayerProvider;
import juno.model.subjects.shift.PlayersProvider;
import juno.model.subjects.shift.TurnMover;

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
        // Game initializer.
        GameInitializer gameInitializer = GameInitializer.getInstance();

        // Deck factory.
        DeckFactory deckFactory = DeckFactory.getInstance();

        // Ai player factory.
        AiPlayerFactory<?, InterfaceDifficulty> aiPlayerFactory =
                (AiPlayerFactory<?, InterfaceDifficulty>) AiPlayerFactory.getInstance();

        // Draw action.
        DrawAction<InterfaceCard> drawAction = (DrawAction<InterfaceCard>) DrawAction.getInstance();

        // One card dispenser.
        OneCardDispenser<InterfaceCard> oneCardDispenser =
                (OneCardDispenser<InterfaceCard>) OneCardDispenser.getInstance();

        // Card dispenser.
        CardDispenser<InterfaceCard> cardDispenser =
                (CardDispenser<InterfaceCard>) CardDispenser.getInstance();

        // Game starter.
        GameStarter gameStarter = GameStarter.getInstance();

        // Mover.
        Mover<InterfaceCard> mover = (Mover<InterfaceCard>) Mover.getInstance();

        // Card controller.
        CardController cardController = CardController.getInstance();

        // First discarded card manager.
        FirstDiscardedCardManager firstDiscardedCardManager = FirstDiscardedCardManager.getInstance();

        // Card remover.
        CardRemover<InterfaceCard> cardRemover =
                (CardRemover<InterfaceCard>) CardRemover.getInstance();

        // Discarded card setter.
        DiscardedCardSetter<InterfaceCard> discardedCardSetter =
                (DiscardedCardSetter<InterfaceCard>) DiscardedCardSetter.getInstance();

        // Discarded pile.
        DiscardedPile<InterfaceCard> discardedPile =
                (DiscardedPile<InterfaceCard>) DiscardedPile.getInstance();

        // Players provider.
        PlayersProvider<InterfacePlayer<InterfaceCard>> playersProvider =
                (PlayersProvider<InterfacePlayer<InterfaceCard>>) PlayersProvider.getInstance();

        // Deck.
        Deck<InterfaceCard> deck = (Deck<InterfaceCard>) Deck.getInstance();

        // Turn mover
        TurnMover<InterfaceCard> turnMover = (TurnMover<InterfaceCard>) TurnMover.getInstance();

        // Human player.
        HumanPlayer<InterfaceCard> humanPlayer = (HumanPlayer<InterfaceCard>) HumanPlayer.getInstance();

        // Penalty executor.
        PenaltyExecutor<InterfaceCard> penaltyExecutor =
                (PenaltyExecutor<InterfaceCard>) PenaltyExecutor.getInstance();

        // Current player provider.
        CurrentPlayerProvider<InterfacePlayer<InterfaceCard>> currentPlayerProvider =
                (CurrentPlayerProvider<InterfacePlayer<InterfaceCard>>) CurrentPlayerProvider.getInstance();

        // Uno card controller.
        UnoCardController<InterfaceCard> unoCardController =
                (UnoCardController<InterfaceCard>) UnoCardController.getInstance();

        // Pass turn action.
        PassTurnAction passTurnAction = PassTurnAction.getInstance();

        // Card timer.
        CardTimer cardTimer = CardTimer.getInstance();

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Card timer.
        drawAction.addObserver(cardTimer);

        // Pass turn action.
        passTurnAction.setTurnMover(turnMover);
        cardTimer.addObserver(passTurnAction);
        discardedCardSetter.addObserver(passTurnAction);

        // Mover.
        mover.setTurnMover(turnMover);
        mover.setDeck(deck);
        mover.setDiscardedPile(discardedPile);
        passTurnAction.addObserver(mover);
        playersProvider.addObserver(mover);
        cardDispenser.addObserver(mover);

        // Card remover.
        cardRemover.setPlayer(humanPlayer);

        // Discarded card setter.
        discardedCardSetter.setDiscardedPile(discardedPile);

        // Players provider.
        playersProvider.addObserver(oneCardDispenser);

        // Game initializer.
        gameInitializer.setAiGenerator(aiPlayerFactory);
        gameInitializer.setDeckGenerator(deckFactory);
        gameInitializer.addObserver(oneCardDispenser);

        // One card dispenser.
        oneCardDispenser.setDeck(deck);
        oneCardDispenser.addObserver(cardController);

        // Card dispenser.
        cardDispenser.setProvider(playersProvider);
        cardDispenser.setDeck(deck);

        // First discarded card.
        firstDiscardedCardManager.setDiscardedPile(discardedPile);
        firstDiscardedCardManager.setDeck(deck);

        // Card controller.
        cardController.addObserver(oneCardDispenser);
        cardController.setDeck(deck);

        // Game starter.
        gameStarter.setDispenser(cardDispenser);
        gameStarter.setProvider(playersProvider);
        gameStarter.setDiscardedCardManager(firstDiscardedCardManager);
        cardController.addObserver(gameStarter);

        // Penalty executor.
        penaltyExecutor.setDeck(deck);
        penaltyExecutor.setProvider(currentPlayerProvider);

        // Uno card controller.
        unoCardController.setProvider(currentPlayerProvider);
        unoCardController.setPenaltyExecutor(penaltyExecutor);

        // Draw action.
        drawAction.setDeck(deck);
        drawAction.setPlayer(humanPlayer);

        // Connector initialization.
        juno.controller.new_game.connector.Initializer.getInstance().initialize();
    }

}