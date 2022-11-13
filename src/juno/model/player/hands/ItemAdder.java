package juno.model.player.hands;


import juno.model.util.Observer;
import juno.model.util.Subject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemAdder<T, E> implements AbstractItemAdder<T, E>, Subject, Observer {

    private List<Observer> observerList;
    private Map<T, List<E>> handsMap;
    private List<E> latestItemsAdded;
    private static ItemAdder<?, ?> instance;

    private ItemAdder() {
        observerList = new ArrayList<>();
        handsMap = new HashMap<>();
        latestItemsAdded = new ArrayList<>();
    }

    public static ItemAdder<?, ?> getInstance() {
        if(instance == null) {
            instance = new ItemAdder<>();
        } return instance;
    }

    @Override
    public void addItemTo(@NotNull T subject,@NotNull E item) {
        if(handsMap.containsKey(subject)) {
            handsMap.get(subject).add(item);
        } else {
            throw new IllegalArgumentException("Invalid subject (" + subject + ")");
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

    @Override
    @SuppressWarnings("unchecked")
    public void update(Object object) {
        if(object instanceof AbstractHandsMaintainer<?, ?> handsMaintainer) {
            handsMap = (Map<T, List<E>>) handsMaintainer.getHandsMap();
        } else {
            throw new IllegalArgumentException("Invalid Subject instance");
        }
    }
}
