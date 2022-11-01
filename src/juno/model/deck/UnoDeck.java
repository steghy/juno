package juno.model.deck;

import juno.model.card.AbstractActionPerformer;
import juno.model.card.AbstractUnoCard;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author steghy
 */
public class UnoDeck implements AbstractUnoDeck<AbstractUnoCard>, Subject {

    /* Deck component */
    private Stack<AbstractUnoCard> deck;

    /* DiscardedPile component */
    private Stack<AbstractUnoCard> discardedPile;

    /* The ActionPerformer component */
    private AbstractActionPerformer actionPerformer;

    /* Refiller component */
    private AbstractDeckRefiller<AbstractUnoCard> refiller;

    /* The compatibility checker component */
    private AbstractCompatibilityChecker<AbstractUnoCard> compatibilityChecker;

    /* The Mixer component */
    private AbstractMixer<AbstractUnoCard> mixer;

    /* The Deck factory */
    private AbstractDeckFactory<AbstractUnoCard> factory;

    /* The last card drawn */
    private AbstractUnoCard lastCardDrawn;

    /* The last card inserted */
    private AbstractUnoCard lastCardInserted;

    /* Start value */
    private boolean start;

    /* Init value */
    private boolean init;

    /* The observers list */
    private List<Observer> observerList;

    /* The UnoDeck instance */
    private static UnoDeck instance;

    /* Builds the UnoDeck instance */
    private UnoDeck() {
        init = false;
        start = false;
    }

    /**
     * Returns the UnoDeck instance.
     * @return The UnoDeck instance.
     */
    public static UnoDeck getInstance() {
        if(instance == null) {
            instance = new UnoDeck();
        } return instance;
    }

    @Override
    public AbstractUnoCard draw() {
        if(init) {
            if(deck.isEmpty()) {
                throw new IllegalArgumentException("Empty deck");
            } if(deck.size() <= 4) {
              refiller.refill(deck, discardedPile);
              mixer.shuffle(deck);
            }
            lastCardDrawn = deck.pop();
            updateAll();
            return lastCardDrawn;
        } else {
            throw new IllegalArgumentException("Not initialized");
        }
    }

    @Override
    public void discard(AbstractUnoCard card) {
        if(init) {
            if(lastCardInserted != null) {
                if (compatibilityChecker.areCompatible(lastCardInserted, card)) {
                    lastCardInserted = card;
                    updateAll();
                    discardedPile.push(card);
                } else {
                    throw new IllegalArgumentException("Incompatible card");
                }
            }
        } else {
            throw new IllegalArgumentException("Not initialized ");
        }
    }

    @Override
    public AbstractUnoCard getLastCardDrawn() {
        if(lastCardDrawn == null) {
            throw new IllegalArgumentException("The last card drawn is empty");
        } return lastCardDrawn;
    }

    @Override
    public AbstractUnoCard getLastCardInserted() {
        if(lastCardInserted == null) {
            throw new IllegalArgumentException("The last card inserted is empty");
        } return lastCardInserted;
     }

     @Override
    public void start() {
       if(init) {
           reset();
           this.deck.addAll(factory.getDeck());
           mixer.shuffle(deck);
           lastCardInserted = deck.pop();
           discardedPile.push(lastCardInserted);
           start = true;
           updateAll();
       } else {
           throw new IllegalArgumentException("Not initialized");
       }
    }

    @Override
    public boolean status() {
        return start;
    }

    @Override
    public void reset() {
        if(init) {
            this.deck.clear();
            this.discardedPile.clear();
            this.lastCardInserted = null;
            this.lastCardDrawn = null;
            updateAll();
        }
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
     * Sets the AbstractDeckRefiller object of this instance.
     * @param refiller An AbstractDeckRefiller object
     */
    void setRefiller(AbstractDeckRefiller<AbstractUnoCard> refiller){
        this.refiller = refiller;
    }

    /**
     * Sets the AbstractCompatibilityChecker object of this instance.
     * @param compatibilityChecker An AbstractCompatibilityChecker object.
     */
    void setCompatibilityChecker(AbstractCompatibilityChecker<AbstractUnoCard> compatibilityChecker) {
        this.compatibilityChecker = compatibilityChecker;
    }

    /**
     * Sets the AbstractMixer object of this instance.
     * @param mixer An AbstractMixer object.
     */
    void setMixer(AbstractMixer<AbstractUnoCard> mixer) {
        this.mixer = mixer;
    }

    /**
     * Sets the AbstractDeckFactory object of this instance.
     * @param factory An AbstractDeckFactory object.
     */
    void setFactory(AbstractDeckFactory<AbstractUnoCard> factory) {
        this.factory = factory;
    }

    /**
     * Sets the AbstractActionPerfomer object of this instance.
     * @param actionPerformer An AbstractActionPerformer object.
     */
    void setActionPerformer(AbstractActionPerformer actionPerformer) {
        this.actionPerformer = actionPerformer;
    }

    /**
     * Initialize the UnoDeck instance
     */
    void initialize() {
        if(refiller == null) {
            throw new IllegalArgumentException("Refiller is not set");
        } if(compatibilityChecker == null) {
            throw new IllegalArgumentException("Compatibility checker is not set");
        } if(mixer == null) {
            throw new IllegalArgumentException("Mixer not set");
        } if(factory == null) {
            throw new IllegalArgumentException("Factory is not set");
        } if(actionPerformer == null) {
            throw new IllegalArgumentException("Action performer not set");
        }
        deck = new Stack<>();
        discardedPile = new Stack<>();
        observerList = new ArrayList<>();
        init = true;
    }
}
