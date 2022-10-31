package juno.model.player;

import juno.model.card.AbstractUnoCard;
import juno.model.deck.Observer;
import juno.model.deck.Subject;
import juno.model.util.Donut;

import java.util.ArrayList;
import java.util.List;

/**
 * @author steghy
 */
public class UnoCardPlayerManager implements AbstractCardPlayerManager<AbstractPlayer, AbstractUnoCard>, Subject {

    /* The AbstractCardPlayerComponent component */
    private AbstractCardPlayerMap<AbstractPlayer, List<AbstractUnoCard>> cardPlayerMap;

    /* AbstractPlayerFactory component */
    private AbstractPlayerFactory<AbstractPlayer> factory;

    /* Players */
    private Donut<AbstractPlayer> players;

    /* The current player */
    private AbstractPlayer currentPlayer;

    /* init value */
    private boolean init;

    private List<Observer> observerList;

    /* The UnoCardPlayerManager instance */
    private static UnoCardPlayerManager instance;

    /* Builds the UnoCardPlayerManager instance */
    private UnoCardPlayerManager() {
        observerList = new ArrayList<>();
        init = false;
    }

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
        }
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
        } else {
            throw new IllegalArgumentException("Not initialized");
        }
    }

    /**
     * Initialize the UnoCardPlayerManager
     */
    public void initialize() {
        if(cardPlayerMap == null) {
            throw new IllegalArgumentException("CardPlayer component not set");
        } if(factory == null) {
            throw new IllegalArgumentException("Factory not set");
        } init = true;
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