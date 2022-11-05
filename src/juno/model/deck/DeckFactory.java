package juno.model.deck;

import juno.model.card.*;

import java.util.ArrayList;
import java.util.Collection;

class DeckFactory extends AbstractDeckFactory<AbstractUnoCard<
        AbstractUnoCardAction,
        AbstractUnoCardColor<AbstractUnoColor>,
        AbstractUnoCardValue>> {

    private static DeckFactory instance;

    private DeckFactory() {}

    static DeckFactory getInstance(){
        if(instance == null){
            instance = new DeckFactory();
        } return instance;
    }

    @Override
    public Collection<AbstractUnoCard<
            AbstractUnoCardAction,
            AbstractUnoCardColor<AbstractUnoColor>,
            AbstractUnoCardValue>> getDeck() {

        if(this.getCardFactory() == null) {
            throw new IllegalArgumentException("Factory not set");
        }

        Collection<AbstractUnoCard<
                AbstractUnoCardAction,
                AbstractUnoCardColor<AbstractUnoColor>,
                AbstractUnoCardValue>> cards = this.getCardFactory().getCards();
        Collection<AbstractUnoCard<
                AbstractUnoCardAction,
                AbstractUnoCardColor<AbstractUnoColor>,
                AbstractUnoCardValue>> deck = new ArrayList<>();
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