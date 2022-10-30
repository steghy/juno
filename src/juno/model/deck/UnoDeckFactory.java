package juno.model.deck;

import juno.model.card.AbstractUnoCard;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class defines the method
 * to generate the Uno cards deck.
 */
public class UnoDeckFactory extends AbstractDeckFactory<AbstractUnoCard> {

    /* The UnoDeckFactory instance */
    private static UnoDeckFactory instance;


    /* Builds the UnoDeckFactory */
    private UnoDeckFactory() {}


    /**
     * Returns the UnoDeckFactory instance.
     * @return The UnoDeckFactor instance.
     */
    public static UnoDeckFactory getInstance(){
        if(instance == null){
            instance = new UnoDeckFactory();
        } return instance;
    }

    @Override
    public Collection<AbstractUnoCard> getDeck() {

        if(this.getFactory() == null) {
            throw new IllegalArgumentException("Factory not set");
        }

        Collection<AbstractUnoCard> cards = this.getFactory().getCards();
        Collection<AbstractUnoCard> deck = new ArrayList<>();
        cards.forEach(card -> {
            deck.add(card);
            if(card.action() != null) {
                if(card.action().isWildAction() ||
                        card.action().isWildDrawFourAction()) {
                    deck.add(card); deck.add(card);
                }
            }

            if(card.action() != null || card.value() != null && !card.value().isValueZero()) {
                deck.add(card);
            }
        });

        return deck;
    }
}