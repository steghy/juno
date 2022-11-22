package juno.model.subjects.hands;

import juno.model.card.InterfaceUnoCard;
import juno.model.subjects.factory.InterfaceSubject;

public class HandsInitializer {

    private HandsInitializer() {}

    @SuppressWarnings("unchecked")
    public static void initialize() {
        // OBSERVERS
        ItemAdder<InterfaceSubject, InterfaceUnoCard> itemAdder =
                (ItemAdder<InterfaceSubject, InterfaceUnoCard>) ItemAdder.getInstance();

        ItemRemover<InterfaceSubject, InterfaceUnoCard> itemRemover =
                (ItemRemover<InterfaceSubject, InterfaceUnoCard>) ItemRemover.getInstance();

        HandsManager<InterfaceSubject, InterfaceUnoCard> handsManager =
                (HandsManager<InterfaceSubject, InterfaceUnoCard>) HandsManager.getInstance();

        // SUBJECT
        HandsProvider<InterfaceSubject, InterfaceUnoCard> handsProvider =
                (HandsProvider<InterfaceSubject, InterfaceUnoCard>) HandsProvider.getInstance();

        // ADDING OBSERVERS
        handsProvider.addObserver(itemAdder);
        handsProvider.addObserver(itemRemover);
        handsProvider.addObserver(handsManager);
    }
}