package juno.model.player;

import juno.model.util.Donut;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.ArrayList;
import java.util.List;

public class Nexter extends AbstractNexter<AbstractPlayer> implements Subject {

    private final List<Observer> observerList;
    private AbstractInverter<AbstractPlayer> inverter;
    private static ShiftManager instance;

    private ShiftManager() {
        observerList = new ArrayList<>();
    }

    private static ShiftManager getInstance(){
        if(instance == null) {
            instance = new ShiftManager();
        } return instance;
    }

    @Override
    public void next() {
        Donut<AbstractPlayer> players = getDonut();
        if(players != null) {
            players.next();
            updateAll();
        } else {
            throw new IllegalArgumentException("");
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
