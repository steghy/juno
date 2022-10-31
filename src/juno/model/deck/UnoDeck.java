package juno.model.deck;

import juno.model.card.AbstractUnoCard;
import java.util.ArrayList;
import java.util.List;

/**
 * @author steghy
 */
public class UnoDeck implements AbstractUnoDeck<AbstractUnoCard>, Subject{

    /* Deck component */
    private AbstractDeck<AbstractUnoCard> deck;

    /* DiscardedPile component */
    private AbstractDiscardPile<AbstractUnoCard> discardedPile;

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

    /* Init value */
    private boolean init;

    /* The UnoDeck instance */
    private static UnoDeck instance;

    /* The observers list */
    private final List<Observer> observerList;

    private UnoDeck() {
        init = false;
        observerList = new ArrayList<>();
    }

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
            }

            if(deck.size() <= 4) {
              refiller.refill(deck, discardedPile);
              mixer.shuffle(deck);
          }
          lastCardDrawn = deck.draw();
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
                    discardedPile.discard(card);
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

    /**
     * Initialize the UnoDeck instance
     */
    void initialize() {
        if(deck == null) {
            throw new IllegalArgumentException("Deck is not set");
        } if(discardedPile == null) {
            throw new IllegalArgumentException("Factory is not set");
        } if(refiller == null) {
            throw new IllegalArgumentException("Refiller is not set");
        } if(compatibilityChecker == null) {
            throw new IllegalArgumentException("Compatibility checker is not set");
        } if(mixer == null) {
            throw new IllegalArgumentException("Mixer not set");
        } if(factory == null) {
            throw new IllegalArgumentException("Factory is not set");
        } init = true;
    }

    /**
     * Start the game.
     */
    public void start() {
       if(init) {
           reset();
           this.deck.addAll(factory.getDeck());
           mixer.shuffle(deck);
           lastCardInserted = deck.draw();
           discardedPile.discard(lastCardInserted);
           updateAll();
       } else {
           throw new IllegalArgumentException("Not initialized");
       }
    }

    public void reset() {
        if(init) {
            this.deck.clear();
            this.discardedPile.clear();
            this.lastCardInserted = null;
            this.lastCardDrawn = null;
            updateAll();
        }
    }

    /**
     * Sets the AbstractDeck object of this instance
     * @param deck An AbstractDeck object
     */
    void setDeck(AbstractDeck<AbstractUnoCard> deck) {
        this.deck = deck;
    }

    /**
     * Sets the AbstractDiscardedPile object of this instance.
     * @param discardedPile An AbstractDiscardedPile object.
     */
    void setDiscardedPile(AbstractDiscardPile<AbstractUnoCard> discardedPile) {
        this.discardedPile = discardedPile;
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
}
