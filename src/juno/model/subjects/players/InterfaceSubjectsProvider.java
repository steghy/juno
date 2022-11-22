package juno.model.subjects.players;

import juno.model.util.Donut;

public interface InterfaceSubjectsProvider<T> {

    Donut<T> getSubjects();
}