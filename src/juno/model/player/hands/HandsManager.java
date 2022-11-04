package juno.model.player.hands;

import juno.model.card.AbstractUnoCard;
import juno.model.player.factory.AbstractPlayer;
import juno.model.player.factory.InterfacePlayersFactory;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandsManager implements AbstractHandsManager<AbstractPlayer, AbstractUnoCard>, Subject, Observer{

    private Map<AbstractPlayer, List<AbstractUnoCard>> map;
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
    public void addItem(AbstractPlayer subject, AbstractUnoCard item) {
        if(map != null) {
            if(map.containsKey(subject)) {
                map.get(subject).add(item);
            } else {
                throw new IllegalArgumentException("Invalid key: " + subject);
            }
        } else {
            throw new IllegalArgumentException("HandsMap isn't set");
        }
    }

    @Override
    public void removeItemTo(AbstractPlayer subject, AbstractUnoCard item) {
        if(map != null) {
            if(map.containsKey(subject)) {
                map.get(subject).remove(item);
            } else {
                throw new IllegalArgumentException("Invalid key: " + subject);
            }
        } else {
            throw new IllegalArgumentException("HandsMap isn't set");
        }
    }

    @Override
    public List<AbstractUnoCard> getCardsOf(AbstractPlayer subject) {
        if(map != null) {
            if(map.containsKey(subject)) {
                return map.get(subject);
            } else {
                throw new IllegalArgumentException("Invalid key: " + subject);
            }
        } else {
            throw new IllegalArgumentException("HandsMap isn't set");
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

    @Override
    public void update(Object object) {
        if(object instanceof InterfacePlayersFactory<?> playersFactory) {
            map = new HashMap<>();
            playersFactory.getPlayers().forEach(player -> map.put((AbstractPlayer) player, new ArrayList<>()));
        }
    }
}
