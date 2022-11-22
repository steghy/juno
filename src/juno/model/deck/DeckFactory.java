package juno.model.deck;

import juno.model.card.*;

import java.util.ArrayList;
import java.util.Collection;

class DeckFactory
        extends AbstractDeckFactory<InterfaceUnoCard> {

    private static DeckFactory instance;

    private DeckFactory() {}

    static DeckFactory getInstance(){
        if(instance == null) instance = new DeckFactory();
        return instance;
    }

    @Override
    public Collection<InterfaceUnoCard> getDeck() {
        Collection<InterfaceUnoCard> cards = this.getCardFactory().getCards();
        Collection<InterfaceUnoCard> deck = new ArrayList<>();
        cards.forEach(card -> {
            deck.add(card);
            if(card.action() != null) {
                if(card.action().isWildAction() ||
                        card.action().isWildDrawFourAction()) {
                    deck.add(card); deck.add(card);
                }
            } if(card.action() != null || card.value() != null && !card.value().isValueZero()) {
                deck.add(card);
            }
        }); return deck;
    }
}