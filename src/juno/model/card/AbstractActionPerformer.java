package juno.model.card;

import juno.model.deck.AbstractDeck;
import juno.model.player.AbstractCardPlayerManager;

public abstract class AbstractActionPerformer<T, E> {

    private AbstractDeck<E> deck;
    private AbstractCardPlayerManager<T, E> cardPlayerManager;

    public abstract void performAction(AbstractUnoCard card, AbstractUnoColor color);

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
