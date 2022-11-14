package juno.model.subjects.hands;

import juno.model.card.AbstractUnoCard;
import juno.model.subjects.factory.AbstractSubject;

public class HandsInitializer {

    private HandsInitializer() {}

    @SuppressWarnings("unchecked")
    public static void initialize() {
        // OBSERVERS
        ItemAdder<AbstractSubject, AbstractUnoCard<?, ?, ?>> itemAdder =
                (ItemAdder<AbstractSubject, AbstractUnoCard<?, ?, ?>>) ItemAdder.getInstance();

        ItemRemover<AbstractSubject, AbstractUnoCard<?, ?, ?>> itemRemover =
                (ItemRemover<AbstractSubject, AbstractUnoCard<?,?,?>>) ItemRemover.getInstance();

        HandsManager<AbstractSubject, AbstractUnoCard<?, ?, ?>> handsManager =
                (HandsManager<AbstractSubject, AbstractUnoCard<?,?,?>>) HandsManager.getInstance();

        // SUBJECT
        HandsProvider<AbstractSubject, AbstractUnoCard<?, ?, ?>> handsProvider =
                (HandsProvider<AbstractSubject, AbstractUnoCard<?,?,?>>) HandsProvider.getInstance();

        // ADDING OBSERVERS
        handsProvider.addObserver(itemAdder);
        handsProvider.addObserver(itemRemover);
        handsProvider.addObserver(handsManager);
    }
}
