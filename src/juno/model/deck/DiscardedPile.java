package juno.model.deck;

import juno.model.card.AbstractUnoCard;
import juno.model.card.AbstractUnoCardAction;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DiscardedPile extends AbstractDiscardedPile<AbstractUnoCard> implements Subject {

    private Stack<AbstractUnoCard> discardedPile;
    private final List<Observer> observerList;
    private boolean init;
    private static DiscardedPile instance;

    private DiscardedPile() {
        observerList = new ArrayList<>();
    }

    public static DiscardedPile getInstance() {
        if(instance == null) {
            instance = new DiscardedPile();
        } return instance;
    }

    @Override
    public void discard(AbstractUnoCard card) {
        if(init) {
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
        return new ArrayList<>(discardedPile);
    }

    @Override
    public AbstractUnoCard lastItem() {
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

    public void initialize() {
        if(this.getCompatibilityChecker() == null) {
            throw new IllegalArgumentException("AbstractCompatibilityChecker isn't set");
        }
        discardedPile = new Stack<>();
        init = true;
    }
}