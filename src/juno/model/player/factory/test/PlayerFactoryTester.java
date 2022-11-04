package juno.model.player.factory.test;

import juno.model.player.factory.AbstractPlayer;
import juno.model.player.factory.AbstractPlayersFactory;
import juno.model.player.factory.NameFactory;
import juno.model.player.factory.PlayersFactory;

import java.util.Collection;

public class PlayerFactoryTester {

    public static void main(String[] args) {
        // SETTINGS
        AbstractPlayersFactory<AbstractPlayer> playerFactory = PlayersFactory.getInstance();
        playerFactory.setNameFactory(NameFactory.getInstance());

        // PLAYERS
        playerFactory.generate(3, "Human Player Name");
        Collection<AbstractPlayer> players = playerFactory.getPlayers();
        players.forEach(System.out::println);
    }
}
