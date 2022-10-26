package juno.model.deck.test;

import juno.model.card.AbstractUnoCard;
import juno.model.deck.Deck;
import juno.model.deck.Shuffler;

public class ShufflerTester {

    public static void main(String[] args){
        Deck deck = Deck.getInstance();
        deck.generateDeck(4);

        System.out.println("Unmixed deck");
        deck.stream().forEach(System.out::println);
        System.out.println("_____________________________");

        Shuffler<AbstractUnoCard> shuffler = new Shuffler<>();
        shuffler.shuffle(deck);

        System.out.println("Mixed deck");
        deck.stream().forEach(System.out::println);
    }
}