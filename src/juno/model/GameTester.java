package juno.model;

import juno.model.card.ActionPerformer;
import juno.model.card.ActionPerformerConfigurator;
import juno.model.deck.UnoDeck;
import juno.model.deck.UnoDeckConfigurator;
import juno.model.player.UnoCardPlayerManager;
import juno.model.player.UnoCardPlayerManagerConfigurator;

public class GameTester {

    public static void main(String[] args) {
        setGame(3);
    }

    /**
     * Sets the game for a new game of
     * num + 1 namber of player.
     * @param num The number of AI player.
     */
    private static void setGame(int num) {
        if(num < 1) {
            throw new IllegalArgumentException("At least 1 AI player");
        }

        // CONFIGURATION
        configure();

        // INSTANCES
        UnoDeck unoDeck = UnoDeck.getInstance();
        UnoCardPlayerManager unoCardPlayerManager = UnoCardPlayerManager.getInstance();

        // INITIALIZE THE GAME
        unoDeck.start();
        unoCardPlayerManager.start(num, "Human player");

        System.out.println("Initial status: ");
        printStatus(unoCardPlayerManager);
    }

    /**
     * Perform the configuration methods:
     * UnoDeckConfiguration.configure();
     * UnoCardPlayerManagerConfigurator.configure();
     * ActionPerformerConfigurator.configure();
     */
    private static void configure() {
        UnoDeckConfigurator.configure();
        UnoCardPlayerManagerConfigurator.configure();
        ActionPerformerConfigurator.configure();
    }

    /**
     * Prints the actual player's hand.
     * @param unoCardPlayerManager An AbstractUnoCardPlayerManager object.
     */
    private static void printStatus(UnoCardPlayerManager unoCardPlayerManager) {
        unoCardPlayerManager.getPlayers().forEach(player -> {
            System.out.println(player + "'s cards: ");
            System.out.println(unoCardPlayerManager.getCardOf(player));
            System.out.println("-------------------");
            });
    }

}
