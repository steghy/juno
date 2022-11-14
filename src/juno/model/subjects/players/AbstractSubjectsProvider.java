package juno.model.subjects.players;

import juno.model.util.Donut;

public interface AbstractSubjectsProvider<T> {

    Donut<T> getSubjects();
}
