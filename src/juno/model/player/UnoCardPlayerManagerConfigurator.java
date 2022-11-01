package juno.model.player;

import juno.model.card.AbstractUnoCard;
import juno.model.card.UnoCard;

import java.util.List;

/**
 * @author steghy
 */
public class UnoCardPlayerManagerConfigurator {

    /* Builds the UnoCardPlayerManagerConfigurator */
    private UnoCardPlayerManagerConfigurator() {}

    /**
     * Configure the UnoCardPlayerManagerConfigurator
     */
    public static void configure() {
        UnoCardPlayerManager unoCardPlayerManager = UnoCardPlayerManager.getInstance();

        // SETTING SUB COMPONENT
        PlayerFactory playerFactory = PlayerFactory.getInstance();
        playerFactory.setNameFactory(NameFactory.getInstance());

        // SETTING MAIN COMPONENT
        unoCardPlayerManager.setFactory(playerFactory);

        // INITIALIZATION
        unoCardPlayerManager.initialize();
    }
}
