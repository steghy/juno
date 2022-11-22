package juno.model.subjects.players;

public interface InterfaceSubjectsManager<T> {

    T currentSubject();

    T nextSubject();
}