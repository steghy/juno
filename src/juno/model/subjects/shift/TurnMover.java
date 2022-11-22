package juno.model.subjects.shift;

import juno.model.subjects.players.InterfaceSubjectsProvider;
import juno.model.util.Donut;
import juno.model.util.Observer;
import juno.model.util.Observable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TurnMover<T> implements InterfaceTurnMover, Observable, Observer {

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
            this.subjects = (Donut<T>) obj.getSubjects();
        } else {
            throw new IllegalArgumentException("Invalid Subject object (" + object + ")");
        }
    }
}
