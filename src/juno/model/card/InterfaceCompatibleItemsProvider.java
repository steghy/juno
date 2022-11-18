package juno.model.card;

import java.util.List;

public interface InterfaceCompatibleItemsProvider<T> {

    List<T> getCompatibleItems(List<T> items);
}
