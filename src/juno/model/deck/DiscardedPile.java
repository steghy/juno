package juno.model.deck;

import juno.model.card.AbstractUnoCard;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DiscardedPile extends AbstractDiscardedPile<AbstractUnoCard> implements Subject {

    private Stack<AbstractUnoCard> discardedPile;
    private List<Observer> observerList;
    private boolean init;
    private static DiscardedPile instance;

    private DiscardedPile() {}

    public static DiscardedPile getInstance() {
        if(instance == null) {
            instance = new DiscardedPile();
        } return instance;
    }

    @Override
    public void discard(AbstractUnoCard card) {
        if(init) {
            if(discardedPile.isEmpty()) {
                throw new IllegalArgumentException("DiscardedPile is empty");
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
        } else {
            throw new IllegalArgumentException("DiscardedPile isn't initialized");
        }
    }

    @Override
    public int size() {
        if(init) {
            return discardedPile.size();
        } else {
            throw new IllegalArgumentException("DiscardedPile isn't initialized");
        }
    }

    @Override
    public void clear() {
        discardedPile.clear();
    }

    @Override
    public List<AbstractUnoCard> items() {
        return discardedPile;
    }

    @Override
    public AbstractUnoCard lastCard() {
        return discardedPile.peek();
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
        observerList.forEach(observer -> observer.update(this));
    }

    /**
     * Initialize this instance
     */
    public void initialize() {
        if(this.getCompatibilityChecker() == null) {
            throw new IllegalArgumentException("AbstractCompatibilityChecker isn't set");
        }
        observerList = new ArrayList<>();
        discardedPile = new Stack<>();
        init = true;
    }
}
