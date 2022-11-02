package juno.model.deck;

import juno.model.card.AbstractUnoCard;

public class DiscardedPileConfigurator {

    private DiscardedPileConfigurator() {}

    public static void configure() {

        // MAIN COMPONENT
        DiscardedPile discardedPile = DiscardedPile.getInstance();

        // SUB-COMPONENT
        AbstractCompatibilityChecker<AbstractUnoCard> compatibilityChecker = CompatibilityChecker.getInstance();

        // MAIN COMPONENT SETTINGS
        discardedPile.setCompatibilityChecker(compatibilityChecker);

        // MAIN COMPONENT INITIALIZATION
        discardedPile.initialize();
    }
}
