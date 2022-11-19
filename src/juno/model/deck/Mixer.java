package juno.model.deck;

import juno.model.util.Observer;
import juno.model.util.Observable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mixer<T> implements AbstractMixer<T>, Observable {

    private final List<Observer> observerList;

    private static Mixer<?> instance;

    private Mixer() {
        observerList = new ArrayList<>();
    }

    public static Mixer<?> getInstance() {
        if(instance == null) {
            instance = new Mixer<>();
        } return instance;
    }

    @Override
    public void shuffle(@NotNull List<T> data) {
        int size = data.size();
        if(size == 0){
           throw new IllegalArgumentException("Invalid data length");
        }
        Random random = new Random();
        for(int i = 0; i < 250; i++) {
            T lastObject = data.get(size - 1);
            data.remove(size - 1);
            data.add(random.nextInt(size), lastObject);
        }
    }

    @Override
    public void addObserver(@NotNull Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }
}