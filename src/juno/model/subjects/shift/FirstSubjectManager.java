package juno.model.subjects.shift;

import juno.model.subjects.players.InterfaceSubjectsProvider;
import juno.model.util.Donut;
import juno.model.util.Observer;
import juno.model.util.Observable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FirstSubjectManager<T, E>
        extends AbstractFirstSubjectManager<T, E>
        implements Observable, Observer {

    private Donut<T> subjects;
    private final List<Observer> observerList;
    private static FirstSubjectManager<?, ?> instance;

    private FirstSubjectManager() {
       observerList = new ArrayList<>();
    }

    public static FirstSubjectManager<?, ?> getInstance() {
        if(instance == null) instance = new FirstSubjectManager<>();
        return instance;
    }


    @Override
    public void setFirst() {
        if(subjects != null) {
            if(super.getHandsManager() != null) {
                subjects.initialize(0);
                setFirstRecursive(null);
                updateAll();
            } else {
                throw new IllegalArgumentException("Hands Manager is null");
            }
        } else {
           throw new IllegalArgumentException("Subjects is null");
        }
    }

    private void setFirstRecursive(@NotNull Collection<T> subjects) {

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
            throw new IllegalArgumentException("Invalid Subject type (" + object.getClass() + ") " +
                    "InterfaceSubjectsProvider expected.");
        }
    }
}