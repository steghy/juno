package juno.model.deck;

import juno.model.card.AbstractUnoCard;

public class DeckConfigurator {

    private DeckConfigurator() {}

    @SuppressWarnings("unchecked")
    public static void configure() {

        // MAIN COMPONENTS
        Deck deck = Deck.getInstance();
        AbstractDiscardedPile<AbstractUnoCard> discardedPile = DiscardedPile.getInstance();

        // SUB-COMPONENTS
        AbstractDeckFactory<AbstractUnoCard> deckFactory = DeckFactory.getInstance();
        AbstractCardFactory<AbstractUnoCard> cardFactory = CardFactory.getInstance();
        AbstractDeckRefiller<AbstractUnoCard> deckRefiller = DeckRefiller.getInstance();

        // SETTING SUB-COMPONENTS
        deckFactory.setCardFactory(cardFactory);
        deckRefiller.setDiscardedPile(discardedPile);

        // MAIN COMPONENT SETTINGS
        deck.setDeckRefiller(deckRefiller);
        deck.setMixer((AbstractMixer<AbstractUnoCard>) Mixer.getInstance());
        deck.setDeckFactory(deckFactory);

        // INITIALIZATION
        deck.initialize();
    }
}
