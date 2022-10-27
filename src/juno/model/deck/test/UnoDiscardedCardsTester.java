package juno.model.deck.test;

import juno.model.deck.*;

public class UnoDiscardedCardsTester {

    public static void main(String[] args){

        // DECK
        UnoDeck deck = UnoDeck.getInstance();

        // DISCARDED CARDS
        UnoDiscardedCards discardedCards = UnoDiscardedCards.getInstance();

        // DECK SETTINGS
        deck.setMixer(new Mixer<>());
        deck.setDiscardedCards(discardedCards);
        deck.setManager(UnoDeckManager.getInstance());

        // DISCARDED CARDS SETTINGS
        discardedCards.setUnoCardController(UnoCardController.getInstance());

        // GENERATING THE CARDS OF THE DECK
        UnoDeckGenerator.generate(deck, UnoCardsFactory.getInstance());

        // MIXING THE CARDS OF THE DECK
        deck.mixDeck();

        System.out.println("DECK");
        deck.forEach(System.out::println);
        System.out.println();
        System.out.println("---------------------");
        System.out.println();

        int factor = 104;

        // CARD
        for(int i = 0; i < factor; i++){
           try {
               discardedCards.push(deck.draw());
           } catch (IllegalArgumentException e) {
                e.printStackTrace();
           }
        }

        System.out.println("Deck size before :" + deck.size());
        System.out.println("DiscardedCards before: " + discardedCards.size());

        System.out.println();

        discardedCards.push(deck.draw());

        System.out.println("Deck size after :" + deck.size());
        System.out.println("DiscardedCards after: " + discardedCards.size());
    }
}
