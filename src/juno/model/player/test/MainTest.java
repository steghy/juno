package juno.model.player.test;

import juno.model.player.factory.AbstractNameFactory;
import juno.model.player.factory.NameFactory;
import juno.model.player.factory.PlayersFactory;
import juno.model.player.players.PlayersMaintainer;

public class MainTest {

    public static void main(String[] args) {

        // [PLAYER FACTORY] (first Subject)
        PlayersFactory playersFactory = PlayersFactory.getInstance();

        // [SUB-COMPONENT PLAYER FACTORY]
        AbstractNameFactory nameFactory = NameFactory.getInstance();

        // [PLAYERS FACTORY] SETTING
        playersFactory.setNameFactory(nameFactory);

        // [PLAYERS DATA ( DONUT )]
        PlayersMaintainer players = PlayersMaintainer.getInstance();

        // [PLAYERS DATA ( DONUT )] SETTING
        players.subscribe(playersFactory);

        // OBSERVER EXAMPLES
        NextTurnObserver nextTurnObserver = new NextTurnObserver(players);
        InverterObserver inverterObserver = new InverterObserver(players);
        SkipperObserver skipperObserver = new SkipperObserver(players);
        FirstPlayerObserver firstPlayerObserver = new FirstPlayerObserver(players);
        PlayersManagerObserver playersManagerObserver = new PlayersManagerObserver(players);

        playersFactory.generate(3, "Human Player");
    }
}
