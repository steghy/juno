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

import juno.model.card.InterfaceCard;
import juno.model.deck.*;
import juno.model.subjects.ai.InterfaceDifficulty;
import juno.model.subjects.factory.AiPlayerFactory;
import juno.model.subjects.factory.InterfaceAiPlayerGenerator;
import juno.model.subjects.shift.PlayersProvider;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds an Initializer object.
    private Initializer() {}

    @SuppressWarnings("unchecked")
    public static void initialize() {
        // Components.
        GameInitializer gameInitializer = GameInitializer.getInstance();
        AiCardPanelConnector connector = AiCardPanelConnector.getInstance();
        OneCardDispenser oneCardDispenser = OneCardDispenser.getInstance();
        CardDispenser cardDispenser = CardDispenser.getInstance();
        GameStarter gameStarter = GameStarter.getInstance();
        Mover mover = Mover.getInstance();
        CardController cardController = CardController.getInstance();
        FirstDiscardedCardManager firstDiscardedCard = FirstDiscardedCardManager.getInstance();
        DiscardedCardSetter<InterfaceCard> discardedCardSetter =
                (DiscardedCardSetter<InterfaceCard>) DiscardedCardSetter.getInstance();

        // Game starter.
        CardController.getInstance().addObserver(gameStarter);

        // Discarded card setter.
        discardedCardSetter.setDiscardedPile((InterfaceDiscardedPile<InterfaceCard>) DiscardedPile.getInstance());

        // Ai player factory.
        AiPlayerFactory.getInstance().addObserver(connector);

        // Players provider.
        PlayersProvider.getInstance().addObserver(oneCardDispenser);

        // Game initializer.
        gameInitializer.setAiGenerator((InterfaceAiPlayerGenerator<InterfaceDifficulty>) AiPlayerFactory.getInstance());
        gameInitializer.setDeckGenerator(DeckFactory.getInstance());
        gameInitializer.addObserver(oneCardDispenser);

        // One card dispenser.
        oneCardDispenser.setDeck((InterfaceDeck<InterfaceCard>) Deck.getInstance());
        oneCardDispenser.addObserver(cardController);

        // Card dispenser.
        cardDispenser.setDeck((InterfaceDeck<InterfaceCard>) Deck.getInstance());
        cardDispenser.addObserver(mover);
        cardDispenser.addObserver(firstDiscardedCard);

        // Card controller.
        cardController.addObserver(oneCardDispenser);
        cardController.addObserver(gameStarter);
        cardController.setDeck((InterfaceDeck<InterfaceCard>) Deck.getInstance());
    }

}