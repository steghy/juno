package juno.model.card;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CompatibleItemsProvider<T> extends AbstractCompatibleItemsProvider<T> {

    private static CompatibleItemsProvider<?> instance;

    private CompatibleItemsProvider() {}

    private static CompatibleItemsProvider<?> getInstance() {
        if(instance == null) {
            instance = new CompatibleItemsProvider<>();
        } return instance;
    }

    @Override
    public List<T> getCompatibleItems(@NotNull List<T> items) {
        return items.stream()
                .filter(item -> getCompatibilityChecker()
                        .areCompatible(getDiscardedPile()
                                .lastItem(), item))
                .toList();
    }
}
