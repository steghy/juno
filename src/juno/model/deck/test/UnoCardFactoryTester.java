package juno.model.deck.test;

import juno.model.deck.UnoCardFactory;

public class UnoCardFactoryTester {

    public static void main(String[] args){

        UnoCardFactory.getInstance().getCards().forEach(System.out::println);
    }
}
