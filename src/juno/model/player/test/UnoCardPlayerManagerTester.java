package juno.model.player.test;

import juno.model.deck.UnoDeck;
import juno.model.deck.UnoDeckConfigurator;
import juno.model.player.ObserverExample;
import juno.model.player.UnoCardPlayerManager;
import juno.model.player.UnoCardPlayerManagerConfigurator;

public class UnoCardPlayerManagerTester {

    public static void main(String[] args) {

        // UNO DECK INITIALIZATION
        UnoDeck unoDeck = UnoDeck.getInstance();
        UnoDeckConfigurator.configure();
        unoDeck.start();

        // CARD PLAYER INITIALIZATION
        UnoCardPlayerManager unoCardPlayerManager = UnoCardPlayerManager.getInstance();
        UnoCardPlayerManagerConfigurator.configure();
        unoCardPlayerManager.start(3, "HumanPlayerNameHere");

        // OBSERVER
        ObserverExample observer = new ObserverExample(unoCardPlayerManager);

        // TESTS
        System.out.println("Players:");
        unoCardPlayerManager.getPlayers().forEach(System.out::println);
        System.out.println("-------------------------");


        for(int i = 0; i < 28; i++) {
            unoCardPlayerManager.addCardTo(unoCardPlayerManager.getCurrentPlayer(), unoDeck.draw());
            unoCardPlayerManager.next();
        }

        unoCardPlayerManager.getPlayers().forEach(player -> {
            System.out.println(player + "'s cards: ");
            unoCardPlayerManager.getCardOf(player).forEach(System.out::println);
            System.out.println("------------------------");
        });
    }
}
