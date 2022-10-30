package juno.model.deck.test;

import juno.model.card.AbstractUnoCard;
import juno.model.deck.*;

public class UnoDeckTester {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // MAIN COMPONENT
        UnoDeck unoDeck = UnoDeck.getInstance();

        // SUB COMPONENTS SETTINGS
        DeckComponent<AbstractUnoCard> deckComponent = (DeckComponent<AbstractUnoCard>) DeckComponent.getInstance();
        DiscardedPileComponent<AbstractUnoCard> discardedPileComponent = (DiscardedPileComponent<AbstractUnoCard>) DiscardedPileComponent.getInstance();
        UnoDeckFactory factory = UnoDeckFactory.getInstance();
        factory.setFactory(UnoCardFactory.getInstance());

        // MAIN COMPONENT SETTINGS
        unoDeck.setDeck(deckComponent);
        unoDeck.setDiscardedPile(discardedPileComponent);
        unoDeck.setRefiller((AbstractDeckRefiller<AbstractUnoCard>) DeckRefiller.getInstance());
        unoDeck.setCompatibilityChecker(UnoCardCompatibilityChecker.getInstance());
        unoDeck.setMixer((AbstractMixer<AbstractUnoCard>) Mixer.getInstance());
        unoDeck.setFactory(UnoDeckFactory.getInstance());

        // INITIALIZATION
        unoDeck.initialize();
    }
}
