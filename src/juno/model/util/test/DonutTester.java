package juno.model.util.test;

import juno.model.player.AbstractPlayer;
import juno.model.player.Player;
import juno.model.util.Donut;

import java.util.Arrays;
import java.util.List;

public class DonutTester {

    public static void main(String[] args) {
        List<AbstractPlayer> players = Arrays.asList(new Player("Simone"),
                                                     new Player("Francesca"),
                                                     new Player("Alessandra"),
                                                     new Player("Alberto"));
        Donut<AbstractPlayer> donut = new Donut<>();
        donut.addAll(players);
        donut.initialize(0);


        // System.out.println("Donut items:");
        // donut.forEach(System.out::println);

        System.out.println(donut.current());
        for(int i = 0; i < 7; i++) {
            if(i == 4) {
                donut.invert();
            }
            System.out.println(donut.next());
        }
    }
}
