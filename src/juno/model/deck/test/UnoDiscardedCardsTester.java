package juno.model.deck.test;

import juno.model.deck.*;

public class UnoDiscardedCardsTester {

    public static void main(String[] args){

        // DECK
        UnoDeck deck = UnoDeck.getInstance();

        // DISCARDED CARDS
        UnoDiscardPile discardedPile = UnoDiscardPile.getInstance();

        // UNO DECK GENERATOR
        UnoDeckFactory generator = UnoDeckFactory.getInstance();

        // DECK SETTINGS
        deck.setMixer(new Mixer<>());
        deck.setDiscardedPile(discardedPile);
        deck.setRefiller(new UnoDeckRefiller<>());

        // DISCARDED CARDS SETTINGS
        discardedPile.setCompatibilityChecker(UnoCardCompatibilityChecker.getInstance());

        // UNO DECK GENERATOR SETTINGS
        generator.setFactory(UnoCardFactory.getInstance());

        // OPERATIONS
        deck.addAll(generator.getDeck());

        System.out.println("DECK");
        System.out.println();
        deck.forEach(System.out::println);
        System.out.println();
        System.out.println("---------------------");
        System.out.println();

        int factor = 104;

        // CARD
        for(int i = 0; i < factor; i++){
           try {
               discardedPile.push(deck.draw());
           } catch (IllegalArgumentException e) {
                e.printStackTrace();
           }
        }

        System.out.println("Deck size before :" + deck.size());
        System.out.println("DiscardedCards before: " + discardedPile.size());

        System.out.println();

        discardedPile.push(deck.draw());

        System.out.println("Deck size after :" + deck.size());
        System.out.println("DiscardedCards after: " + discardedPile.size());
    }
}
