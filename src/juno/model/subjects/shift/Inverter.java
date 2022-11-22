package juno.model.subjects.shift;

import juno.model.subjects.players.InterfaceSubjectsProvider;
import juno.model.util.Donut;
import juno.model.util.Observer;
import juno.model.util.Observable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Inverter<T> implements
        InterfaceInverter, Observable, Observer{

    private Donut<T> subjects;
    private final List<Observer> observerList;
    private static Inverter<?> instance;

    private Inverter() {
        observerList = new ArrayList<>();
    }

    public static Inverter<?> getInstance() {
       if(instance == null) instance = new Inverter<>();
       return instance;
    }

    @Override
    public void invert() {
        if(subjects != null) {
            subjects.invert();
            updateAll();
        } else {
            throw new IllegalArgumentException("Subjects is null");
        }
    }

    @Override
    public void addObserver(@NotNull Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(null));
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceSubjectsProvider<?> obj) {
            subjects = (Donut<T>) obj.getSubjects();
        } else {
            throw new IllegalArgumentException("Invalid Subject type (" + object.getClass() + ") " +
                    "InterfaceSubjectsProvider expected");
        }
    }
}