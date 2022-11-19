package juno.model.deck;

import juno.model.util.Observer;
import juno.model.util.Observable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DeckRefiller<T> extends AbstractDeckRefiller<T> implements Observable {

    private final List<Observer> observerList;
    private static DeckRefiller<?> instance;

    private DeckRefiller() {
        observerList = new ArrayList<>();
    }

    public static DeckRefiller<?> getInstance() {
        if(instance == null) {
            instance = new DeckRefiller<>();
        } return instance;
    }

    @Override
    public void refill(@NotNull List<T> deck) {
        AbstractDiscardedPile<T> discardedPile = this.getDiscardedPile();
        T lastCard = discardedPile.lastItem();
        List<T> cards = discardedPile.items();
        cards.remove(cards.size() - 1);
        deck.addAll(cards);
        discardedPile.clear();
        discardedPile.discard(lastCard);
        updateAll();
    }

    @Override
    public void addObserver(@NotNull Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(null));

    }
}