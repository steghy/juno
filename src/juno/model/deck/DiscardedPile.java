package juno.model.deck;

import juno.model.util.Observer;
import juno.model.util.Observable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DiscardedPile<T>
        extends AbstractDiscardedPile<T>
        implements Observable {

    private final Stack<T> discardedPile;
    private final List<Observer> observerList;
    private static DiscardedPile<?> instance;

    private DiscardedPile() {
        discardedPile = new Stack<>();
        observerList = new ArrayList<>();
    }

    public static DiscardedPile<?> getInstance() {
        if(instance == null) instance = new DiscardedPile<>();
        return instance;
    }

    @Override
    public void discard(@NotNull T card) {
        if(discardedPile.isEmpty()) {
            discardedPile.push(card);
        } else {
            if(this.getCompatibilityChecker().areCompatible(discardedPile.peek(), card)) {
                discardedPile.push(card);
                updateAll();
            } else {
                throw new IllegalArgumentException(
                        "Incompatible card: " +
                        discardedPile.peek() + ", " + card);
            }
        }
    }

    @Override
    public void clear() {
        discardedPile.clear();
    }

    @Override
    public List<T> items() {
        return new ArrayList<>(discardedPile);
    }

    @Override
    public T lastItem() {
        return discardedPile.peek();
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
        observerList.forEach(observer -> observer.update(this));
    }
}