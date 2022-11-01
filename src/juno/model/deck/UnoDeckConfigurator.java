package juno.model.deck;

import juno.model.card.AbstractUnoCard;
import juno.model.card.ActionPerformer;

public class UnoDeckConfigurator {

    private UnoDeckConfigurator() {}

    @SuppressWarnings("unchecked")
    public static void configure() {

        // MAIN COMPONENT
        UnoDeck unoDeck = UnoDeck.getInstance();

        // SUB COMPONENTS SETTINGS
        UnoDeckFactory factory = UnoDeckFactory.getInstance();
        factory.setFactory(UnoCardFactory.getInstance());

        // MAIN COMPONENT SETTINGS
        unoDeck.setRefiller((AbstractDeckRefiller<AbstractUnoCard>) UnoDeckRefiller.getInstance());
        unoDeck.setCompatibilityChecker(UnoCardCompatibilityChecker.getInstance());
        unoDeck.setMixer((AbstractMixer<AbstractUnoCard>) Mixer.getInstance());
        unoDeck.setFactory(UnoDeckFactory.getInstance());
        unoDeck.setActionPerformer(ActionPerformer.getInstance());

        // INITIALIZATION
        unoDeck.initialize();
    }
}
