package juno.model.ai;

import juno.model.subjects.hands.AbstractHandsManager;
import juno.model.subjects.players.AbstractSubjectsManager;

public abstract class AbstractUnoAi<T, E> implements InterfaceUnoAi<E> {

    private AbstractHandsManager<T, E> handsManager;
    private AbstractSubjectsManager<T> subjectsManager;

    public void setHandsManager(AbstractHandsManager<T, E> handsManager) {
        this.handsManager = handsManager;
    }

    public void setSubjectsManager(AbstractSubjectsManager<T> subjectsManager) {
        this.subjectsManager = subjectsManager;
    }

    public AbstractHandsManager<T, E> getHandsManager() {
        return handsManager;
    }

    public AbstractSubjectsManager<T> getSubjectsManager() {
        return subjectsManager;
    }
}
