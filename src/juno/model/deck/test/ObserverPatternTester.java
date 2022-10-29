package juno.model.deck.test;

import juno.model.deck.*;

public class ObserverPatternTester {

    public static void main(String[] args) {
        // UNO DECK
        UnoDeck unoDeck = UnoDeck.getInstance();

        // UNO DISCARDED CARDS
        UnoDiscardPile unoDiscardPile = UnoDiscardPile.getInstance();

        // UNO DECK GENERATOR
        UnoDeckFactory generator = UnoDeckFactory.getInstance();

        // UNO DECK SETTINGS
        unoDeck.setDiscardedPile(unoDiscardPile);
        unoDeck.setRefiller(new UnoDeckRefiller<>());
        unoDeck.setMixer(new Mixer<>());

        // UNO DISCARDED CARDS SETTINGS
        unoDiscardPile.setCompatibilityChecker(UnoCardCompatibilityChecker.getInstance());

        // UNO DECK GENERATOR SETTINGS
        generator.setFactory(UnoCardFactory.getInstance());

        // GENERATING CARDS & SHUFFLE
        unoDeck.addAll(generator.getDeck());

        ObserverExample observer = new ObserverExample(unoDeck);

        unoDeck.draw();

    }
}
