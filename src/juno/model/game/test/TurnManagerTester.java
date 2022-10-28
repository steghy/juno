package juno.model.game.test;

import juno.model.game.AbstractPlayer;
import juno.model.game.Player;
import juno.model.game.TurnManager;

public class TurnManagerTester {

    public static void main(String[] args) {

        TurnManager turnManager = TurnManager.getInstance();

        AbstractPlayer player1 = new Player("Simone");
        AbstractPlayer player2 = new Player("Giancarlo");
        AbstractPlayer player3 = new Player("Francesca");
        AbstractPlayer player4 = new Player("Fabrizio");

        turnManager.setPlayers(player1, player2, player3, player4);

        System.out.println("Players before:");
        turnManager.getPlayers().forEach(System.out::println);
        System.out.println("----------------");

        turnManager.initializeFirstPlayer();

        System.out.println("Player after:");
        turnManager.getPlayers().forEach(System.out::println);

    }
}
