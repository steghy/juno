package juno.model.subjects.hands;

import java.util.List;
import java.util.Map;

public interface AbstractHandsProvider<T, E> {

    Map<T, List<E>> getHandsMap();
}
