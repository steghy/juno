package juno.model.deck;

import juno.model.card.AbstractUnoCard;

import java.util.Stack;

public class DiscardedDeck extends Stack<AbstractUnoCard> implements AbstractDiscardedDeck {

    @Override
    public void put(AbstractUnoCard card) throws IllegalArgumentException {
        if(this.isEmpty() || this.peek().isCompatibleWith(card)) {
            this.push(card);
        } else {
            throw new IllegalArgumentException("Incompatible cards");
        }
    }
}
