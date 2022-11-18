package juno.model.subjects.hands;

import juno.model.util.Observer;
import juno.model.util.Observable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemRemover<T, E> implements AbstractItemRemover<T, E>, Observable, Observer {

    private Map<?, ? extends List<?>> handsMap;
    private final List<Observer> observerList;
    private static ItemRemover<?, ?> instance;

    private ItemRemover() {
        observerList = new ArrayList<>();
    }

    public static ItemRemover<?, ?> getInstance() {
        if(instance == null) {
            instance = new ItemRemover<>();
        } return instance;
    }

    public void setHandsMap(Map<T, List<E>> handsMap) {
        this.handsMap = handsMap;
    }

    @Override
    public void removeItemTo(@NotNull T subject,@NotNull E item) {
        if(handsMap != null) {
            if(handsMap.containsKey(subject)) {
                // is index usage better ? maybe
                handsMap.get(subject).remove(item);
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
        if(object instanceof AbstractHandsProvider<?,?> handsMaintainer) {
            handsMap = new HashMap<>();
            this.handsMap = handsMaintainer.getHandsMap();
        } else {
            throw new IllegalArgumentException("Invalid Subject object (" + object + ")");
        }
    }

}
