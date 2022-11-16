package juno.model.data;

import java.util.Map;

public interface Exportable<T, E> {

    Map<T, E> export();
}
