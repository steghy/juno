package juno.model.player.factory.test;

import juno.model.player.factory.NameFactory;

public class NameFactoryTester {

    public static void main(String[] args) {
        NameFactory randomNameProvider = NameFactory.getInstance();
        randomNameProvider.getNames(3).forEach(System.out::println);
    }
}
