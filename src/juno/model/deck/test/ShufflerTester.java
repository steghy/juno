package juno.model.deck.test;

import juno.model.deck.Deck;
import juno.model.deck.Shuffler;
import juno.model.deck.UnoDeckGenerator;

public class ShufflerTester {

    public static void main(String[] args){
        Deck deck = new Deck();
        UnoDeckGenerator.generate(deck);
        Shuffler.shuffle(deck);
        deck.forEach(System.out::println);
    }
}