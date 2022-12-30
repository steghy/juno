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


import juno.model.card.InterfaceCard;
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.shift.Inverter;
import juno.model.subjects.shift.PlayersProvider;
import juno.model.subjects.shift.TurnMover;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds an Initializer object.
    private Initializer() {}

    @SuppressWarnings("unchecked")
    public static void initialize() {
        // Compatible card provider.
        CompatibleCardsProvider compatibleCardsProvider = CompatibleCardsProvider.getInstance();

        // Actual color manager.
        ActualColorManager actualColor = ActualColorManager.getInstance();

        // Compatibility checker.
        CompatibilityChecker compatibilityChecker = CompatibilityChecker.getInstance();

        // Deck.
        Deck<InterfaceCard> deck = (Deck<InterfaceCard>) Deck.getInstance();

        // Deck factory.
        DeckFactory deckFactory = DeckFactory.getInstance();

        // Deck filler.
        DeckFiller<InterfaceCard>  filler = (DeckFiller<InterfaceCard>) DeckFiller.getInstance();

        // Mixer.
        Mixer<InterfaceCard> mixer = (Mixer<InterfaceCard>) Mixer.getInstance();

        // Discarded pile.
        DiscardedPile<InterfaceCard> discardedPile = (DiscardedPile<InterfaceCard>) DiscardedPile.getInstance();

        // Card effect activator.
        CardEffectActivator cardEffectActivator = CardEffectActivator.getInstance();

        // Players provider.
        PlayersProvider<InterfacePlayer<InterfaceCard>> playersProvider =
                (PlayersProvider<InterfacePlayer<InterfaceCard>>) PlayersProvider.getInstance();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Compatible cards provider settings.
        compatibleCardsProvider.setCompatibilityChecker(compatibilityChecker);

        // Compatibility checker settings.
        compatibilityChecker.setDiscardedPile(discardedPile);
        compatibilityChecker.setProvider(actualColor);

        // Deck filler settings.
        filler.setDiscardedPile(discardedPile);

        // Deck settings.
        deck.setDeckFiller(filler);
        deck.setMixer(mixer);

        // Card effect activator settings.
        cardEffectActivator.setDeck(deck);
        cardEffectActivator.setInverter(Inverter.getInstance());
        cardEffectActivator.setTurnMover(TurnMover.getInstance());
        cardEffectActivator.setPlayersProvider(playersProvider);
        cardEffectActivator.setActualColor(actualColor);

        // Observer / Observable.
        // Deck factory.
        deckFactory.addObserver(deck);

        // Discarded pile
        discardedPile.addObserver(actualColor);
        discardedPile.addObserver(cardEffectActivator);
    }

}