package juno.model.player.shift;

import juno.model.deck.AbstractDeck;
import juno.model.player.hands.AbstractHandsManager;

public abstract class AbstractFirstPlayerManager<T, E> implements InterfaceFirstPlayerManager {

    private AbstractHandsManager<T, E> handsManager;
    private AbstractDeck<E> deck;

    public void setHandsManager(AbstractHandsManager<T, E> handsManager) {
        this.handsManager = handsManager;
    }

    public void setDeck(AbstractDeck<E> deck) {
        this.deck = deck;
    }

    public AbstractHandsManager<T, E> getHandsManager() {
        return this.handsManager;
    }

    public AbstractDeck<E> getDeck() {
        return this.deck;
    }

}
