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

package juno.model.deck;


import juno.controller.new_game.GameInitializer;
import juno.model.card.InterfaceCard;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.shift.Inverter;
import juno.model.subjects.shift.PlayersProvider;
import juno.model.subjects.shift.TurnJumper;
import juno.view.gobject.cards.GCardFactory;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds an Initializer object.
    private Initializer() {}

    @SuppressWarnings("unchecked")
    public static void initialize() {
        CompatibleCardsProvider compatibleCardsProvider = CompatibleCardsProvider.getInstance();
        ActualColorManager actualColor = ActualColorManager.getInstance();
        CompatibilityChecker compatibilityChecker = CompatibilityChecker.getInstance();
        Deck<InterfaceCard> deck = (Deck<InterfaceCard>) Deck.getInstance();
        DeckFactory deckFactory = DeckFactory.getInstance();
        DeckFiller<InterfaceCard>  filler = (DeckFiller<InterfaceCard>) DeckFiller.getInstance();
        Mixer<InterfaceCard> mixer = (Mixer<InterfaceCard>) Mixer.getInstance();
        DiscardedPile<InterfaceCard> discardedPile = (DiscardedPile<InterfaceCard>) DiscardedPile.getInstance();
        GameInitializer gameInitializer = GameInitializer.getInstance();
        CardEffectActivator cardEffectActivator = CardEffectActivator.getInstance();
        PlayersProvider<InterfacePlayer<InterfaceCard>> playersProvider =
                (PlayersProvider<InterfacePlayer<InterfaceCard>>) PlayersProvider.getInstance();
        compatibleCardsProvider.setCompatibilityChecker(compatibilityChecker);
        compatibilityChecker.setDiscardedPile(discardedPile);
        compatibilityChecker.setProvider(actualColor);
        filler.setDiscardedPile(discardedPile);
        deck.setDeckFiller(filler);
        deck.setMixer(mixer);
        cardEffectActivator.setDeck(deck);
        cardEffectActivator.setInverter(Inverter.getInstance());
        cardEffectActivator.setTurnJumper(TurnJumper.getInstance());
        cardEffectActivator.setPlayersProvider(playersProvider);
        cardEffectActivator.setActualColor(actualColor);
        deckFactory.addObserver(deck);
        deckFactory.addObserver(GCardFactory.getInstance());
        gameInitializer.addObserver(discardedPile);
        discardedPile.addObserver(actualColor);
        discardedPile.addObserver(cardEffectActivator);
    }

}