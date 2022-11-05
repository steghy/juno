package juno.model.player.hands;

import juno.model.player.factory.InterfacePlayersFactory;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.*;

public class HandsManager<T, E> implements AbstractHandsManager<T, E>, Subject, Observer{

    private Map<T, Collection<E>> map;
    private final List<Observer> observerList;
    private static HandsManager<?, ?> instance;

    private HandsManager() {
        observerList = new ArrayList<>();
    }

    public static HandsManager<?, ?> getInstance() {
        if(instance == null) {
            instance = new HandsManager<>();
        } return instance;
    }

    @Override
    public void addItem(T subject, E item) {
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
    public void removeItemTo(T subject, E item) {
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
    public Collection<E> getItemsOf(T subject) {
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
    @SuppressWarnings("unchecked")
    public void update(Object object) {
        if(object instanceof InterfacePlayersFactory<?> playersFactory) {
            map = new HashMap<>();
            playersFactory.getPlayers().forEach(subject -> map.put((T)subject, new ArrayList<>()));
        }
    }
}
