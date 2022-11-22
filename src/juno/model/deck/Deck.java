package juno.model.deck;

import juno.model.util.Observer;
import juno.model.util.Observable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Deck<T>
        extends AbstractDeck<T>
        implements Observable {

    private final List<Observer> observerList;
    private final Stack<T> deck;
    private T lastCard;
    private static Deck<?> instance;

    private Deck() {
        observerList = new ArrayList<>();
        deck = new Stack<>();
    }

     public static Deck<?> getInstance() {
        if(instance == null) instance = new Deck<>();
        return instance;
     }

    @Override
    public T draw() {
        if(deck.isEmpty()) {
            throw new IllegalArgumentException("Deck is empty");
        } else if(deck.size() <= 4) {
            this.getDeckRefiller().refill(deck);
            this.getMixer().shuffle(deck);
        } lastCard = deck.pop();
        updateAll();
        return lastCard;
    }

    @Override
    public T lastItem() {
        return lastCard;
    }

    @Override
    public void generate() {
        deck.clear();
        deck.addAll(this.getDeckFactory().getDeck());
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