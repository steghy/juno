package juno.model.player.hands;

import java.util.List;

public interface AbstractItemAdder<T, E> {

    void addItemTo(T subject, E item);
}
