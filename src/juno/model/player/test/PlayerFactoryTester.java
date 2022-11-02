package juno.model.player.test;

import juno.model.player.AbstractPlayer;
import juno.model.player.AbstractPlayerFactory;
import juno.model.player.NameFactory;
import juno.model.player.PlayerFactory;

import java.util.Collection;

public class PlayerFactoryTester {

    public static void main(String[] args) {
        // SETTINGS
        AbstractPlayerFactory<AbstractPlayer> playerFactory = PlayerFactory.getInstance();
        playerFactory.setNameFactory(NameFactory.getInstance());

        // PLAYERS
        playerFactory.generate(3, "Human Player Name");
        Collection<AbstractPlayer> players = playerFactory.getPlayers();
        players.forEach(System.out::println);
    }
}
