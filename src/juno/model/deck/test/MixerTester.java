package juno.model.deck.test;

import juno.model.deck.*;

public class MixerTester {

    public static void main(String[] args){

        // DECK
        UnoDeck deck = UnoDeck.getInstance();

        // DISCARDED CARDS
        UnoDiscardedCards discardedCards = UnoDiscardedCards.getInstance();

        // SETTING
        deck.setMixer(new Mixer<>());
        deck.setDiscardedCards(discardedCards);

        // GENERATING THE CARDS OF THE DECK
        UnoDeckGenerator.generate(deck, UnoCardsFactory.getInstance());

        // MIXING THE CARDS
        deck.mixDeck();

        deck.forEach(System.out::println);
    }
}