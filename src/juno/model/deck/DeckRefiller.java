package juno.model.deck;


import juno.model.card.AbstractUnoCard;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.List;

/**
 * @author steghy
 */
public class DeckRefiller extends AbstractDeckRefiller<AbstractUnoCard> implements Subject {

    private List<Observer> observerList;
    private static DeckRefiller instance;

    private DeckRefiller() {}

    public static DeckRefiller getInstance() {
        if(instance == null) {
            instance = new DeckRefiller();
        } return instance;
    }

    @Override
    public void refill(List<AbstractUnoCard> deck) {
        AbstractDiscardedPile<AbstractUnoCard> discardedPile = this.getDiscardedPile();
        if(discardedPile == null) {
            throw new IllegalArgumentException("AbstractDiscardedPile isn't set");
        }
        AbstractUnoCard lastCard = discardedPile.lastItem();
        List<AbstractUnoCard> cards = discardedPile.items();
        cards.remove(cards.size() - 1);
        deck.addAll(cards);
        discardedPile.clear();
        discardedPile.discard(lastCard);
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(null));

    }
}