package juno.model.subjects.hands;

import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class HandsManager<T, E>
        implements InterfaceHandsManager<T, E>, Observer{

    private Map<?, ? extends List<?>> handsMap;
    private static HandsManager<?, ?> instance;

    private HandsManager() {}

    public static HandsManager<?, ?> getInstance() {
        if(instance == null) instance = new HandsManager<>();
        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<E> getItemsOf(@NotNull T subject) {
        if(handsMap != null) {
            if(handsMap.containsKey(subject)) {
                return (List<E>) handsMap.get(subject);
            } else {
                throw new IllegalArgumentException("Invalid subject (" + subject + ")");
            }
        } else {
            throw new IllegalArgumentException("HandsMap is null");
        }
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceHandsProvider<?, ?> handsMaintainer) {
            handsMap = new HashMap<>();
            this.handsMap = handsMaintainer.getHandsMap();
        } else {
            throw new IllegalArgumentException("Invalid Subject object (" + object + ") " +
                    "InterfaceHandsProvider expected.");
        }
    }
}