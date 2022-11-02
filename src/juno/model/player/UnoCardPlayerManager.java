package juno.model.player;

import juno.model.card.AbstractUnoCard;
import juno.model.util.Observer;
import juno.model.util.Subject;
import juno.model.util.Donut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author steghy
 */
public class UnoCardPlayerManager implements AbstractCardPlayerManager<AbstractPlayer, AbstractUnoCard>, Subject {

    /* The AbstractCardPlayerComponent component */
    private Map<AbstractPlayer, List<AbstractUnoCard>> cardPlayerMap;

    /* AbstractPlayerFactory component */
    private AbstractPlayerFactory<AbstractPlayer> factory;

    /* Players */
    private Donut<AbstractPlayer> players;

    /* The current player */
    private AbstractPlayer currentPlayer;

    /* init value */
    private boolean init;

    /* Observer List */
    private List<Observer> observerList;

    /* The UnoCardPlayerManager instance */
    private static UnoCardPlayerManager instance;

    /* Builds the UnoCardPlayerManager instance */
    private UnoCardPlayerManager() {}

    /**
     * Returns the UnoCardPlayerManager instance.
     * @return The UnoCardPlayerManager instance.
     */
    public static UnoCardPlayerManager getInstance() {
        if(instance == null) {
            instance = new UnoCardPlayerManager();
        } return instance;
    }

    @Override
    public void start(int num, String humanName) {
        if(init) {
            players.addAll(factory.getPlayers(num, humanName));
            players.forEach(player -> cardPlayerMap.put(player, new ArrayList<>()));
            updateAll();
        } else {
            throw new IllegalArgumentException("Not initialized");
        }
    }

    public void setFirstPlayer() {

    }

    @Override
    public List<AbstractUnoCard> getCardOf(AbstractPlayer player) {
        if(init) {
           if(cardPlayerMap.containsKey(player)) {
              return cardPlayerMap.get(player);
           } else {
               throw new IllegalArgumentException("Invalid player");
           }
        } else {
            throw new IllegalArgumentException("Not initialized");
        }
    }

    @Override
    public AbstractPlayer getNextPlayer() {
        return players.peek();
    }

    @Override
    public void addCardTo(AbstractPlayer player, AbstractUnoCard card) {
        if(init) {
            if(cardPlayerMap.containsKey(player)) {
                cardPlayerMap.get(player).add(card);
                updateAll();
            } else {
                throw new IllegalArgumentException("Invalid player");
            }
        } else {
            throw new IllegalArgumentException("Not initialized");
        }
    }

    @Override
    public void removeCardTo(AbstractPlayer player, AbstractUnoCard card) {
        if(init) {
            if(cardPlayerMap.containsKey(player)) {
                if(!cardPlayerMap.get(player).remove(card)) {
                    throw new IllegalArgumentException("Invalid card");
                } else {
                    updateAll();
                }
            } else {
                throw new IllegalArgumentException("Invalid player");
            }
        } else {
            throw new IllegalArgumentException("Not initialized");
        }
    }

    @Override
    public void invert() {
        if(init) {
            players.invert();
            updateAll();
        } else {
            throw new IllegalArgumentException("Not initialized");
        }
    }

    @Override
    public void next() {
        if(init) {
            currentPlayer = players.next();
            updateAll();
        } else  {
            throw new IllegalArgumentException("Not initialized");
        }
    }

    @Override
    public AbstractPlayer getCurrentPlayer() {
        return players.current();
    }

    @Override
    public List<AbstractPlayer> getPlayers() {
        return new ArrayList<>(players);
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
     * Sets the AbstractPlayerFactory object of this instance.
     * @param factory An AbstractPlayerFactory object.
     */
    void setFactory(AbstractPlayerFactory<AbstractPlayer> factory) {
        this.factory = factory;
    }


    /**
     * Initialize the UnoCardPlayerManager
     */
    void initialize() {
        if(factory == null) {
            throw new IllegalArgumentException("Factory not set");
        }
        players = new Donut<>();
        cardPlayerMap = new HashMap<>();
        observerList = new ArrayList<>();
        init = true;
    }
}