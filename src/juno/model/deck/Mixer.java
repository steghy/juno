package juno.model.deck;

import java.util.List;
import java.util.Random;

public class Mixer<E> implements AbstractMixer<E> {

    /**
     * Mix the data structure passed in input.
     */
    public void shuffle(List<E> data) {
        Random random = new Random();
        int size = data.size();
        for(int i = 0; i < 250; i++) {
            E lastObject = data.get(size - 1);
            data.remove(size - 1);
            data.add(random.nextInt(size), lastObject);
        }
    }
}
