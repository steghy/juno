package juno.model.player.shift;

import juno.model.player.players.AbstractPlayersMantainer;
import juno.model.util.Donut;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.ArrayList;
import java.util.List;

public class Inverter<T> implements AbstractInverter, Subject, Observer{

    private Donut<T> subjects;
    private final List<Observer> observerList;
    private static Inverter<?> instance;

    private Inverter() {
        observerList = new ArrayList<>();
    }

    public static Inverter<?> getInstance() {
       if(instance == null) {
           instance = new Inverter<>();
       } return instance;
    }

    @Override
    public void invert() {
        if(subjects != null) {
            subjects.invert();
            updateAll();
        } else {
            throw new IllegalArgumentException("Subjects not present");
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
            subjects = (Donut<T>) obj.getPlayers();
        }
    }
}
