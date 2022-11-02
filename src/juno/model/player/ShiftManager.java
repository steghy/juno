package juno.model.player;

import juno.model.util.Donut;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.List;

public class ShiftManager extends AbstractShiftManager<AbstractPlayer> implements Subject {

    private List<Observer> observerList;
    private static ShiftManager instance;

    private ShiftManager() {}

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
            throw new IllegalArgumentException("")
        }
    }

    @Override
    public AbstractPlayer current() {
        Donut<AbstractPlayer> players = getDonut();
        if(players != null) {
            players.current();
        } else {
            throw new IllegalArgumentException("Players not initialized");
        }
    }

    @Override
    public void invert() {
        Donut<AbstractPlayer> players = getDonut();
        if(players != null) {
            players.invert();
        } else {
            throw new IllegalArgumentException("Players not initialized");
        }
    }

    @Override
    public void setFirst(AbstractPlayer subject) {

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
