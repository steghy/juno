package juno.model.deck.test;

import juno.model.deck.DeckConfigurator;
import juno.model.deck.DiscardedPileConfigurator;

public class ConfigurationTester {

    public static void main(String[] args) {
        DeckConfigurator.configure();
        DiscardedPileConfigurator.configure();
    }
}
