package juno.model.card;

public interface AbstractUnoCard<T, E, C> {

    T action();

    E color();

    C value();

}