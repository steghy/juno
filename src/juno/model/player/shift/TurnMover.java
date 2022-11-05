package juno.model.player.shift;

import juno.model.player.players.AbstractPlayersMantainer;
import juno.model.util.Donut;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.ArrayList;
import java.util.List;

public class TurnMover<T> implements AbstractTurnMover, Subject, Observer {

    private Donut<T> subjects;
    private final List<Observer> observerList;
    private static TurnMover<?> instance;

    private TurnMover() {
        observerList = new ArrayList<>();
    }

    public static TurnMover<?> getInstance(){
        if(instance == null) {
            instance = new TurnMover<>();
        } return instance;
    }

    @Override
    public void next() {
        if(subjects != null) {
            subjects.next();
            updateAll();
        } else {
            throw new IllegalArgumentException("Players aren't set");
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
        observerList.forEach(observer -> observer.update(null));
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(Object object) {
        if(object instanceof AbstractPlayersMantainer<?> obj) {
            this.subjects = (Donut<T>) obj.getPlayers();
        }
    }
}
