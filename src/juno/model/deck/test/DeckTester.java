package juno.model.deck.test;

import juno.model.card.AbstractUnoCard;
import juno.model.deck.*;

public class DeckTester {

    public static void main(String[] args){

        // DECK
        UnoDeck deck = UnoDeck.getInstance();

        // DISCARDED CARDS
        UnoDiscardedCards discardedCards = UnoDiscardedCards.getInstance();

        // SETTINGS
        deck.setMixer(new Mixer<>());
        deck.setDiscardedCards(discardedCards);
        deck.setManager(new UnoDeckManager());

        // GENERATING CARDS OF THE DECK
        UnoDeckGenerator.generate(deck, UnoCardsFactory.getInstance());

        deck.forEach(System.out::println);

        System.out.println("Deck size: " + deck.size());
    }
}
