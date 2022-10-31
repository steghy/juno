package juno.model.player.test;

import juno.model.player.NameFactory;

public class NameFactoryTester {

    public static void main(String[] args) {
        NameFactory randomNameProvider = NameFactory.getInstance();
        randomNameProvider.getNames(3).forEach(System.out::println);
    }
}
