package juno.model.deck;

import java.util.List;
import java.util.Random;

/**
 * This class defines mixer.
 * @param <T> The items type
 */
public class Mixer<T> implements AbstractMixer<T> {

    /** The Mixer instance */
    private static Mixer<?> instance;

    /* Builds the Mixer instance */
    private Mixer() {}

    /**
     * Returns the Mixer instance.
     * @return The Mixer instance.
     */
    public static Mixer<?> getInstance() {
        if(instance == null) {
            instance = new Mixer<>();
        } return instance;
    }

    @Override
    public void shuffle(List<T> data) {
        Random random = new Random();
        int size = data.size();
        if(size == 0){
           throw new IllegalArgumentException("Invalid data length");
        }
        for(int i = 0; i < 250; i++) {
            T lastObject = data.get(size - 1);
            data.remove(size - 1);
            data.add(random.nextInt(size), lastObject);
        }
    }
}
