package juno.model.card;

import juno.model.deck.AbstractDeck;
import juno.model.player.InterfaceHandsManager;
import juno.model.player.InterfaceShiftManager;

public abstract class AbstractActionPerformer<T, E, C> implements InterfaceActionPerformer<E, C> {

    private AbstractDeck<E> deck;
    private InterfaceShiftManager<T> shiftManager;
    private InterfaceHandsManager<T, E> handsManager;

    /**
     * Sets the AbstractDeck object of this instance.
     * @param deck An AbstractDeck object.
     */
    public void setDeck(AbstractDeck<E> deck) {
        this.deck = deck;
    }

    /**
     * Sets the InterfaceHandsManager object of this instance.
     * @param handsManager An InterfaceHandsManager object.
     */
    public void setCardPlayerManager(InterfaceHandsManager<T, E> handsManager) {
        this.handsManager = handsManager;
    }

    /**
     * Sets the InterfaceShiftManager object of this instance.
     * @param shiftManager An InterfaceShiftManager object.
     */
    public void setShiftManager(InterfaceShiftManager<T> shiftManager) {
        this.shiftManager = shiftManager;
    }

    /**
     * Returns the AbstractDeck object of this instance.
     * @return An AbstractDeck object.
     */
    public AbstractDeck<E> getDeck() {
        return deck;
    }

    /**
     * Returns the InterfaceHandsManager object of this instance.
     * @return An InterfaceHandsManager object.
     */
    public InterfaceHandsManager<T, E> getCardPlayerManager() {
        return handsManager;
    }

    /**
     * Returns the InterfaceShiftManager object of this instance.
     * @return An InterfaceShiftManager object.
     */
    public InterfaceShiftManager<T> getShiftManager() {
        return shiftManager;
    }
}