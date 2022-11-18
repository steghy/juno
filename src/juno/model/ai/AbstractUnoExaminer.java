package juno.model.ai;

import juno.model.card.AbstractCompatibleItemsProvider;
import juno.model.subjects.hands.AbstractHandsManager;
import juno.model.subjects.players.AbstractSubjectsManager;

public abstract class AbstractUnoExaminer<T, E> implements InterfaceUnoExaminer<E> {

    private AbstractSubjectsManager<T> subjectsManager;
    private AbstractHandsManager<T, E> handsManager;
    private AbstractCompatibleItemsProvider<E> compatibleItemsProvider;

    public void setSubjectsManager(AbstractSubjectsManager<T> subjectsManager) {
        this.subjectsManager = subjectsManager;
    }

    public void setHandsManager(AbstractHandsManager<T, E> handsManager) {
        this.handsManager = handsManager;
    }

    public void setCompatibleItemsProvider(AbstractCompatibleItemsProvider<E> compatibleItemsProvider) {
        this.compatibleItemsProvider = compatibleItemsProvider;
    }

    public AbstractSubjectsManager<T> getSubjectsManager() {
        return subjectsManager;
    }

    public AbstractHandsManager<T, E> getHandsManager() {
        return handsManager;
    }

    public AbstractCompatibleItemsProvider<E> getCompatibleItemsProvider() {
        return compatibleItemsProvider;
    }
}
