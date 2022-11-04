package juno.model.deck;

import juno.model.card.AbstractUnoCard;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Deck extends AbstractDeck<AbstractUnoCard> implements Subject {

    private List<Observer> observerList;
    private Stack<AbstractUnoCard> deck;
    private AbstractUnoCard lastCard;
    private static Deck instance;
    private boolean init;

    private Deck() {}

     public static Deck getInstance() {
        if(instance == null) {
            instance = new Deck();
        } return instance;
    }

    @Override
    public AbstractUnoCard draw() {
        if(init) {
            if(deck.isEmpty()) {
                throw new IllegalArgumentException("Deck is empty");
            } else if(deck.size() <= 4) {
                this.getDeckRefiller().refill(deck);
                this.getMixer().shuffle(deck);
            } lastCard = deck.pop();
            updateAll();
            return lastCard;
        } else {
            throw new IllegalArgumentException("Deck not initialized");
        }
    }

    @Override
    public AbstractUnoCard lastItem() {
        return lastCard;
    }

    @Override
    public void generate() {
        deck.clear();
        deck.addAll(this.getDeckFactory().getDeck());
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
     void initialize() {
        if(this.getDeckRefiller() == null) {
            throw new IllegalArgumentException("AbstractDeckRefiller isn't set");
        } if(this.getMixer() == null) {
            throw new IllegalArgumentException("AbstractMixer isn't set");
        } if(this.getDeckFactory() == null) {
            throw new IllegalArgumentException("AbstractDeckFactory isn't set");
         }
        observerList = new ArrayList<>();
        deck = new Stack<>();
        init = true;
    }
}