package juno.model.deck;

import juno.model.card.AbstractUnoCard;

/**
 * This class defines the method
 * to generate the Uno cards deck.
 */
public class UnoDeckGenerator {

    /**
     * Generates the Uno deck
     * @param deck A Generable deck
     */
    public static void generate(AbstractGenerable<AbstractUnoCard> deck,
                                AbstractUnoCardsFactory factory) {

        // BLUE CARDS
        factory.getBlueCards().forEach(card -> {
            deck.insert(card);
            if(card.value() != null && !card.value().isValueZero()) {
                deck.insert(card);
            } else if(card.action() != null) {
                deck.insert(card);
            }
        });

        // RED CARDS
        factory.getRedCards().forEach(card -> {
            deck.insert(card);
            if(card.value() != null && !card.value().isValueZero()) {
                deck.insert(card);
            } else if(card.action() != null) {
                deck.insert(card);
            }
        });

        // GREEN CARDS
        factory.getGreenCards().forEach(card -> {
            deck.insert(card);
            if(card.value() != null && !card.value().isValueZero()) {
                deck.insert(card);
            } else if(card.action() != null) {
                deck.insert(card);
            }
        });

        // YELLOW CARDS
        factory.getYellowCards().forEach(card -> {
            deck.insert(card);
            if(card.value() != null && !card.value().isValueZero()) {
                deck.insert(card);
            } else if(card.action() != null){
                deck.insert(card);
            }
        });

        // JOLLY CARDS
        factory.getJollyCards().forEach(card -> {
            deck.insert(card);
            deck.insert(card);
            deck.insert(card);
            deck.insert(card);
        });
    }
}