package juno.model.deck.test;

import juno.model.deck.Deck;
import juno.model.deck.FactoryUnoCard;
import juno.model.deck.Shuffler;
import juno.model.deck.UnoDeckGenerator;

public class ShufflerTester {

    public static void main(String[] args){
        Deck deck = new Deck();
        UnoDeckGenerator.generate(deck, FactoryUnoCard.getInstance());
        Shuffler.shuffle(deck);
        deck.forEach(System.out::println);
    }
}