package juno.model.subjects.factory.test;

import juno.model.subjects.factory.AbstractSubject;
import juno.model.subjects.factory.AbstractSubjectsFactory;
import juno.model.subjects.factory.NameFactory;
import juno.model.subjects.factory.SubjectsFactory;

import java.util.Collection;

public class PlayerFactoryTester {

    public static void main(String[] args) {
        // SETTINGS
        AbstractSubjectsFactory<AbstractSubject> playerFactory = SubjectsFactory.getInstance();
        playerFactory.setNameFactory(NameFactory.getInstance());

        // PLAYERS
        playerFactory.generate(3, "Human Player Name");
        Collection<AbstractSubject> players = playerFactory.getSubjects();
        players.forEach(System.out::println);
    }
}
