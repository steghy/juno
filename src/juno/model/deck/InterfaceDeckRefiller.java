package juno.model.deck;

import java.util.List;

public interface InterfaceDeckRefiller<T> {

    void refill(List<T> deck);
}
