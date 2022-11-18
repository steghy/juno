package juno.model.subjects.players;

public interface AbstractSubjectsManager<T> {

    T currentSubject();

    T nextSubject();
}

