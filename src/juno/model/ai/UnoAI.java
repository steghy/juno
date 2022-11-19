package juno.model.ai;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UnoAI<T> extends AbstractUnoAI<T> {

    private Difficulty difficulty;
    private String name;
    private List<T> items;

    public UnoAI(@NotNull String name, @NotNull Difficulty difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public UnoAI(@NotNull String name) {
        this.name = name;
    }

    public UnoAI(@NotNull Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public UnoAI() {}

    @Override
    public T makeAChoice() {
        if(getCompatibleItemsProvider() != null) {
            if(getUnoExaminer() != null) {
                if(items != null) {
                    if(items.size() != 0) {
                        if(difficulty != null) {
                            return getUnoExaminer().responseRelativeTo(items, difficulty);
                        } else {
                            throw new IllegalArgumentException("Difficulty is null");
                        }
                    } else {
                        throw new IllegalArgumentException("Items size is zero");
                    }
                } else {
                    throw new IllegalArgumentException("Items is null");
                }
            } else {
                throw new IllegalArgumentException("UnoExaminer is null");
            }
        } else {
            throw new IllegalArgumentException("CompatibleItemsProvider is null");
        }
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

    public void setDifficulty(@NotNull Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
