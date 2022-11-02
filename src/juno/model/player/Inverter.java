package juno.model.player;

import juno.model.util.Donut;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.ArrayList;
import java.util.List;

public class Inverter<T> implements AbstractInverter<T>, Subject {

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
    public void invert(Donut<T> items) {
        items.invert();
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
