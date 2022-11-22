package juno.model.card;

import java.util.Collection;
import java.util.List;

@FunctionalInterface
public interface InterfaceItemsSelector<E> {

    List<E> getCompatibleItems(Collection<E> items);
}
