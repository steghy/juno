package juno.model.subjects.hands;


import juno.model.util.Observer;
import juno.model.util.Observable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemAdder<T, E> implements AbstractItemAdder<T, E>, Observable, Observer {

    private final List<Observer> observerList;
    private Map<?, ? extends List<?>> handsMap;
    private static ItemAdder<?, ?> instance;

    private ItemAdder() {
        observerList = new ArrayList<>();
    }

    public static ItemAdder<?, ?> getInstance() {
        if(instance == null) {
            instance = new ItemAdder<>();
        } return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addItemTo(@NotNull T subject,@NotNull E item) {
        if(handsMap != null) {
            if(handsMap.containsKey(subject)) {
                ((List<E>) handsMap.get(subject)).add(item);
                updateAll();
            } else {
                throw new IllegalArgumentException("Invalid subject (" + subject + ")");
            }
        } else {
            throw new IllegalArgumentException("Hands map is null");
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
    public void update(Object object) {
        if(object instanceof AbstractHandsProvider<?, ?> handsMaintainer) {
            handsMap = new HashMap<>();
            this.handsMap = handsMaintainer.getHandsMap();
        } else {
            throw new IllegalArgumentException("Invalid Subject object (" + object + ")");
        }
    }
}
