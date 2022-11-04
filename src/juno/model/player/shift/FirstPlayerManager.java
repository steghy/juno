package juno.model.player.shift;

import juno.model.card.AbstractUnoCard;
import juno.model.deck.AbstractDeck;
import juno.model.player.factory.AbstractPlayer;
import juno.model.player.hands.AbstractHandsManager;
import juno.model.player.players.AbstractPlayersMantainer;
import juno.model.util.Donut;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FirstPlayerManager implements AbstractFirstPlayerManager, Subject, Observer {


    private AbstractHandsManager<AbstractPlayer, AbstractUnoCard> handsManager;
    private AbstractDeck<AbstractUnoCard> deck;
    private Donut<AbstractPlayer> players;
    private final List<Observer> observerList;
    private static FirstPlayerManager instance;

    private FirstPlayerManager() {
       observerList = new ArrayList<>();
    }

    public static FirstPlayerManager getInstance() {
        if(instance == null) {
            instance = new FirstPlayerManager();
        } return instance;
    }


    @Override
    public void setFirst() {
        if(players != null) {
            if(handsManager != null) {
                players.initialize(0);
                updateAll();
            } else {
                throw new IllegalArgumentException("AbstractHandsManager isn't set");
            }
        } else {
           throw new IllegalArgumentException("Players aren't set");
        }
    }

    private void setFirstRecursive(List<AbstractPlayer> playersList) {

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
        observerList.forEach(observer -> observer.update(null));
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(Object object) {
        if(object instanceof AbstractPlayersMantainer<?> obj) {
            this.players = (Donut<AbstractPlayer>) obj.getPlayers();
        }
    }
}
