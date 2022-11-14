package juno.model.subjects.factory.test;

import juno.model.subjects.factory.NameFactory;

public class NameFactoryTester {

    public static void main(String[] args) {
        NameFactory randomNameProvider = NameFactory.getInstance();
        randomNameProvider.getNames(3).forEach(System.out::println);
    }
}
