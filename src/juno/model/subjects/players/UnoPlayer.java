package juno.model.subjects.players;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UnoPlayer<T>
        implements InterfaceUnoPlayer<T> {

    private String name;
    private List<T> items;
    private static UnoPlayer<?> instance;

    public static UnoPlayer<?> getInstance() {
        if(instance == null) instance = new UnoPlayer<>();
        return instance;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void addItem(@NotNull T item) {
        items.add(item);
    }

    @Override
    public void removeItem(@NotNull T item) {
        items.remove(item);
    }

    public void name(@NotNull String name) {
        this.name = name;
    }
}