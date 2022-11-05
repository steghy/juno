package juno.model.player.shift;

import juno.model.player.players.AbstractPlayersMantainer;
import juno.model.util.Donut;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FirstPlayerManager<T, E> extends AbstractFirstPlayerManager<T, E> implements Subject, Observer {

    private Donut<T> players;
    private final List<Observer> observerList;
    private static FirstPlayerManager<?, ?> instance;

    private FirstPlayerManager() {
       observerList = new ArrayList<>();
    }

    public static FirstPlayerManager<?, ?> getInstance() {
        if(instance == null) {
            instance = new FirstPlayerManager<>();
        } return instance;
    }


    @Override
    public void setFirst() {
        if(players != null) {
            if(getHandsManager() != null) {
                players.initialize(0);
                setFirstRecursive(null);
                updateAll();
            } else {
                throw new IllegalArgumentException("AbstractHandsManager isn't set");
            }
        } else {
           throw new IllegalArgumentException("Players aren't set");
        }
    }

    private void setFirstRecursive(Collection<T> subjects) {

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
            this.players = (Donut<T>) obj.getPlayers();
        }
    }
}
