package juno.model.deck;


import java.util.List;

public interface AbstractMixer<T> {

    void shuffle(List<T> data);
}
