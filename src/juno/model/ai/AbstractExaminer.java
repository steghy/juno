package juno.model.ai;

import java.util.List;

public interface AbstractExaminer<T> {

    T examine(List<T> items, int enemyItemsSize);
}