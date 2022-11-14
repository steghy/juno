package juno.model.subjects.players;

import juno.model.subjects.factory.InterfaceSubjectsFactory;
import juno.model.util.Donut;
import juno.model.util.Observer;
import juno.model.util.Observable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SubjectsProvider<T> implements AbstractSubjectsProvider<T>, Observable, Observer {

    private Donut<T> subjects;
    private final List<Observer> observerList;
    private static SubjectsProvider<?> instance;

    private SubjectsProvider() {
        observerList = new ArrayList<>();
    }

    public static SubjectsProvider<?> getInstance() {
        if(instance == null) {
            instance = new SubjectsProvider<>();
        } return instance;
    }

    @Override
    public Donut<T> getSubjects() {
        if(subjects != null) {
            return subjects;
        } else {
            throw new IllegalArgumentException("Players is null");
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
        if(object instanceof InterfaceSubjectsFactory<?> playersFactory) {
            subjects = new Donut<>();
            subjects.addAll((Collection<? extends T>) playersFactory.getSubjects());
            updateAll();
        } else {
            throw new IllegalArgumentException("Invalid Subject object (" + object + ")");
        }
    }
}