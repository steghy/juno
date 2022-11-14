package juno.model.subjects.players;

public interface AbstractPlayersManager<T> {

    T currentSubject();

    T nextSubject();
}

