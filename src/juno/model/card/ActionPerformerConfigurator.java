package juno.model.card;

import juno.model.deck.AbstractDeck;
import juno.model.deck.Deck;
import juno.model.player.factory.AbstractPlayer;
import juno.model.player.hands.HandsManager;
import juno.model.player.hands.AbstractHandsManager;
import juno.model.player.players.AbstractPlayersManager;
import juno.model.player.players.PlayersManager;
import juno.model.player.shift.*;

public class ActionPerformerConfigurator {

    private ActionPerformerConfigurator() {}

    public static void configure() {
        // MAIN-COMPONENT
        ActionPerformer actionPerformer = ActionPerformer.getInstance();

        // SUB-COMPONENTS
        AbstractDeck<AbstractUnoCard> deck = Deck.getInstance();
        AbstractTurnJumper skipper = TurnJumper.getInstance();
        AbstractTurnMover nextTurnClass = TurnMover.getInstance();
        AbstractInverter<AbstractPlayer> inverter = Inverter.getInstance();
        AbstractPlayersManager<AbstractPlayer> playersManager = PlayersManager.getInstance();
        AbstractHandsManager<AbstractPlayer, AbstractUnoCard> handsManager = HandsManager.getInstance();

        // MAIN-COMPONENT SETTINGS
        actionPerformer.setDeck(deck);
        actionPerformer.setSkipper(skipper);
        actionPerformer.setNextTurnClass(nextTurnClass);
        actionPerformer.setInverter(inverter);
        actionPerformer.setPlayersManager(playersManager);
        actionPerformer.setHandsManager(handsManager);

        // MAIN-COMPONENT INITIALIZATION
        actionPerformer.initialize();
    }
}
