package juno.model.card;

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
    public List<T> getCompatibleItems(List<T> items) {
        if(getCompatibilityChecker() != null) {
            if(getDiscardedPile() != null) {
                return items.stream()
                        .filter(item -> getCompatibilityChecker()
                                .areCompatible(getDiscardedPile()
                                        .lastItem(), item))
                        .toList();
            } else {
                throw new IllegalArgumentException("DiscardedPile is null");
            }
        } else {
            throw new IllegalArgumentException("CompatibilityChecker is null");
        }
    }
}
