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
    AbstractUnoCardAction action();

    /**
     * Returns the color.
     * @return An object that describes the
     *         color of the UnoCard.
     */
    AbstractUnoCardColor color();

    /**
     * Returns the value.
     * @return An int value that describes
     *         the numeric value of the UnoCard
     */
    AbstractUnoCardValue value();


    /**
     * Sets the special wild card color
     * @param color An AbstractUnoColor object
     */
    void setWildCardColor(AbstractUnoCardColor color);

}