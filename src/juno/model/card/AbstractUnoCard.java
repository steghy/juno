package juno.model.card;

/**
 * AbstractUnoCard.
 */
public interface AbstractUnoCard {

    /**
     * Returns the action.
     * @return An Object that describes the
     *         action of the UnoCard.
     */
    Object getAction();

    /**
     * Returns the color.
     * @return An object that describes the
     *         color of the UnoCard.
     */
    Object getColor();

    /**
     * Returns the value.
     * @return An int value that describes
     *         the numeric value of the UnoCard
     */
    int getValue();

    boolean isCompatibleWith(AbstractUnoCard card);
}