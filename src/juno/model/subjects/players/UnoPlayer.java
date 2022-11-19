package juno.model.subjects.players;

import java.util.List;

public class UnoPlayer<T> implements AbstractUnoPlayer<T> {

    private String name;
    private List<T> items;
    private static UnoPlayer<?> instance;

    public static UnoPlayer<?> getInstance() {
        if(instance == null) {
            instance = new UnoPlayer<>();
        } return instance;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void addItem(T item) {
        items.add(item);
    }

    @Override
    public void removeItem(T item) {
        items.remove(item);
    }

    public void name(String name) {
        this.name = name;
    }
}
