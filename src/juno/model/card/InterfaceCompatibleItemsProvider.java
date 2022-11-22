package juno.model.card;

import java.util.List;

@FunctionalInterface
public interface InterfaceCompatibleItemsProvider<T> {

    List<T> getCompatibleItems(List<T> items);
}
