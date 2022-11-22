package juno.model.subjects.ai;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UnoAI<T>
        extends AbstractUnoAI<T> {

    private Difficulty difficulty;
    private String name;
    private List<T> items;

    public UnoAI(@NotNull String name,
                 @NotNull Difficulty difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public UnoAI(@NotNull Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public UnoAI() {}

    @Override
    public T makeAChoice() {
        return getUnoExaminer().responseRelativeTo(items, difficulty);
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
