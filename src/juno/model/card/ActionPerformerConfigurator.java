package juno.model.card;

import juno.model.deck.UnoDeck;
import juno.model.player.UnoCardPlayerManager;

/**
 * @author steghy
 */
public class ActionPerformerConfigurator {

    private ActionPerformerConfigurator() {}

    /** Configure the ActionPerformer instance */
    public static void configure() {
        ActionPerformer actionPerformer = ActionPerformer.getInstance();
        actionPerformer.setUnoDeck(UnoDeck.getInstance());
        actionPerformer.setCardPlayerManager(UnoCardPlayerManager.getInstance());
        actionPerformer.initialize();
    }
}
