package juno.model.subjects.hands;

import juno.model.subjects.factory.InterfaceSubjectsFactory;
import juno.model.util.Observer;
import juno.model.util.Observable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandsProvider<T, E> implements AbstractHandsProvider<T, E>, Observable, Observer {

    private Map<T, List<E>> handsMap;
    private final List<Observer> observerList;
    private static HandsProvider<?, ?> instance;

    private HandsProvider() {
        observerList = new ArrayList<>();
    }

    public static HandsProvider<?, ?> getInstance() {
        if(instance == null) {
            instance = new HandsProvider<>();
        } return instance;
    }

    @Override
    public Map<T, List<E>> getHandsMap() {
        if(handsMap != null) {
            return handsMap;
        } else {
            throw new IllegalArgumentException("Hands map is null");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(Object object) {
        if(object instanceof InterfaceSubjectsFactory<?> subjectFactory) {
            handsMap = new HashMap<>();
            subjectFactory.getSubjects().forEach(subject -> handsMap.put((T) subject, new ArrayList<>()));
        } else {
            throw new IllegalArgumentException("Invalid Subject object (" + object + ")");
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
}
