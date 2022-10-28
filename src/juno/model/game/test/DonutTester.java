package juno.model.game.test;

import juno.model.game.AbstractPlayer;
import juno.model.game.Player;
import juno.model.game.Donut;

public class DonutTester {

    public static void main(String[] args) {

        Donut<AbstractPlayer> donut = new Donut<>();

        AbstractPlayer player1 = new Player("Simone");
        AbstractPlayer player2 = new Player("Francesca");
        AbstractPlayer player3 = new Player("Alessandra");
        AbstractPlayer player4 = new Player("Alberto");

        donut.add(player1);
        donut.add(player2);
        donut.add(player3);
        donut.add(player4);

        System.out.println("Players before");
        donut.forEach(System.out::println);

        donut.initialize();

        AbstractPlayer current = donut.current();

        System.out.println("Players after");
        System.out.println(current);
        for(int i = 0; i < 8; i++) {
            System.out.println(donut.previous());
        }
    }
}
