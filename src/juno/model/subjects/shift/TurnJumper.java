package juno.model.subjects.shift;

import juno.model.subjects.players.InterfaceSubjectsProvider;
import juno.model.util.Donut;
import juno.model.util.Observer;
import juno.model.util.Observable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TurnJumper<T> implements
        InterfaceTurnJumper, Observable, Observer {

    private Donut<T> subjects;
    private final List<Observer> observerList;
    private static TurnJumper<?> instance;

    private TurnJumper() {
        observerList = new ArrayList<>();
    }

    public static TurnJumper<?> getInstance(){
        if(instance == null) instance = new TurnJumper<>();
        return instance;
    }

    public void skip() {
        if(subjects != null) {
            subjects.next();
            subjects.next();
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
        observerList.forEach(observer -> observer.update(this));
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceSubjectsProvider<?> obj) {
            this.subjects = (Donut<T>) obj.getSubjects();
        } else {
            throw new IllegalArgumentException("Invalid Subject object (" + object +")");
        }
    }
}