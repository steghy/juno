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
        // GameInitializer.
        GameInitializer gameInitializer = GameInitializer.getInstance();

        // AiCardPanelConnector.
        AiCardPanelConnector connector = AiCardPanelConnector.getInstance();

        // CardDispenser.
        CardDispenser cardDispenser = CardDispenser.getInstance();

        // Mover.
        Mover mover = Mover.getInstance();

        // FirstDiscardedCardManager.
        FirstDiscardedCardManager firstDiscardedCard = FirstDiscardedCardManager.getInstance();

        // DiscardedCardSetter.
        DiscardedCardSetter<InterfaceCard> discardedCardSetter =
                (DiscardedCardSetter<InterfaceCard>) DiscardedCardSetter.getInstance();

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Connections
        // GameInitializer.
        gameInitializer.setAiGenerator((InterfaceAiPlayerGenerator<InterfaceDifficulty>) AiPlayerFactory.getInstance());
        gameInitializer.setDeckGenerator(DeckFactory.getInstance());

        // CardDispenser.
        cardDispenser.setDeck((InterfaceDeck<InterfaceCard>) Deck.getInstance());

        // DiscardedCardSetter.
        discardedCardSetter.setDiscardedPile((InterfaceDiscardedPile<InterfaceCard>) DiscardedPile.getInstance());

        // Observer / Observable.
        AiPlayerFactory.getInstance().addObserver(connector);
        PlayersProvider.getInstance().addObserver(cardDispenser);
        gameInitializer.addObserver(StartGameAction.getInstance());
        cardDispenser.addObserver(mover);
        cardDispenser.addObserver(firstDiscardedCard);
    }

}