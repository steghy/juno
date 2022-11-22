package juno.model.subjects.shift;

import juno.model.deck.AbstractDeck;
import juno.model.subjects.hands.InterfaceHandsManager;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractFirstSubjectManager<T, E>
        implements InterfaceFirstSubjectManager {

    private InterfaceHandsManager<T, E> handsManager;
    private AbstractDeck<E> deck;

    public void setHandsManager(@NotNull InterfaceHandsManager<T, E> handsManager) {
        this.handsManager = handsManager;
    }

    public void setDeck(@NotNull AbstractDeck<E> deck) {
        this.deck = deck;
    }

    public InterfaceHandsManager<T, E> getHandsManager() {
        return this.handsManager;
    }

    public AbstractDeck<E> getDeck() {
        return this.deck;
    }

}
