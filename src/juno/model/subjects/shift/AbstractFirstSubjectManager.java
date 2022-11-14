package juno.model.subjects.shift;

import juno.model.deck.AbstractDeck;
import juno.model.subjects.hands.AbstractHandsManager;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractFirstSubjectManager<T, E> implements InterfaceFirstSubjectManager {

    private AbstractHandsManager<T, E> handsManager;
    private AbstractDeck<E> deck;

    public void setHandsManager(@NotNull AbstractHandsManager<T, E> handsManager) {
        this.handsManager = handsManager;
    }

    public void setDeck(@NotNull AbstractDeck<E> deck) {
        this.deck = deck;
    }

    public AbstractHandsManager<T, E> getHandsManager() {
        return this.handsManager;
    }

    public AbstractDeck<E> getDeck() {
        return this.deck;
    }

}
