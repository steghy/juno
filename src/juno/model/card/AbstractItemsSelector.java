package juno.model.card;

import java.util.Collection;
import java.util.List;

public interface AbstractItemsSelector<E> {

    List<E> getCompatibleItems(Collection<E> items);
}
