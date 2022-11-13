package juno.model.player.hands;

import java.util.List;
import java.util.Map;

public interface AbstractHandsMaintainer<T, E> {

    Map<T, List<E>> getHandsMap();
}
