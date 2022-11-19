package juno.model.subjects.ai;

import java.util.List;

public interface InterfaceUnoExaminer<T> {

    T responseRelativeTo(List<T> items, Difficulty difficulty);
}