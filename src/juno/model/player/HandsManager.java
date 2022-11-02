package juno.model.player;

import juno.model.card.AbstractUnoCard;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HandsManager extends AbstractHandsManager<AbstractPlayer, AbstractUnoCard> implements Subject {

    private final List<Observer> observerList;
    private static HandsManager instance;

    private HandsManager() {
        observerList = new ArrayList<>();
    }

    public static HandsManager getInstance() {
        if(instance == null) {
            instance = new HandsManager();
        } return instance;
    }

    @Override
    public void addItem(AbstractPlayer player, AbstractUnoCard item) {
        Map<AbstractPlayer, List<AbstractUnoCard>> hands = getHands();
        if(hands != null) {
            if(hands.containsKey(player)) {
                hands.get(player).add(item);
            } else {
                throw new IllegalArgumentException("Invalid player key: " + player);
            }
        } else {
            throw new IllegalArgumentException("HandsMap isn't initialized");
        }
    }

    @Override
    public void removeItemTo(AbstractPlayer player, AbstractUnoCard item) {
        Map<AbstractPlayer, List<AbstractUnoCard>> hands = getHands();
        if(hands != null) {
            if(hands.containsKey(player)) {
                hands.get(player).remove(item);
            } else {
                throw new IllegalArgumentException("Invalid player key: " + player);
            }
        } else {
            throw new IllegalArgumentException("Hands are not initialized");
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
}
