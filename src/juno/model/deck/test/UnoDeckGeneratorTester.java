package juno.model.deck.test;

import juno.model.deck.Deck;
import juno.model.deck.FactoryUnoCard;
import juno.model.deck.UnoDeckGenerator;

public class UnoDeckGeneratorTester {

    public static void main(String[] args){

        Deck unoDeck = new Deck();
        UnoDeckGenerator.generate(unoDeck, FactoryUnoCard.getInstance());
        unoDeck.forEach(System.out::println);
        System.out.println("TOTAL CARDS: " + unoDeck.size());
    }
}
