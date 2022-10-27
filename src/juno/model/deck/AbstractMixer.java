package juno.model.deck;


import java.util.List;

public interface AbstractMixer<E> {

    void shuffle(List<E> data);
}
