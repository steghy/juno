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
     * Sets the AbstractCardPlayerManager object of this instance.
     * @param cardPlayerManager An AbstractCardPlayerManager object.
     */
    public void setCardPlayerManager(AbstractCardPlayerManager<T, E> cardPlayerManager) {
        this.cardPlayerManager = cardPlayerManager;
    }

    /**
     * Returns the AbstractDeck object of this instance.
     * @return An AbstractDeck object.
     */
    public AbstractDeck<E> getDeck() {
        return deck;
    }

    /**
     * Returns the AbstractCardPlayerManager object of this instance.
     * @return An AbstractCardPlayerManager object.
     */
    public AbstractCardPlayerManager<T, E> getCardPlayerManager() {
        return cardPlayerManager;
    }

}
