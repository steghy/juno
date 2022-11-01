package juno.model.player.test;

import juno.model.player.AbstractPlayer;
import juno.model.player.AbstractPlayerFactory;
import juno.model.player.NameFactory;
import juno.model.player.PlayerFactory;

import java.util.List;

public class PlayerFactoryTester {

    public static void main(String[] args) {
        // SETTINGS
        AbstractPlayerFactory<AbstractPlayer> playerFactory = PlayerFactory.getInstance();
        playerFactory.setNameFactory(NameFactory.getInstance());

        // PLAYERS
        List<AbstractPlayer> players = playerFactory.getPlayers(3, "Human player");
        players.forEach(System.out::println);
    }
}
