package juno.model.card;

/**
 * This interface defines the methods to
 * recognize the action in the Uno card game.
 */
public interface AbstractUnoAction {

    /**
     * Returns true if this action is a wild
     * action, otherwise returns false.
     * @return A boolean
     */
    boolean isWildAction();


    /**
     * Returns true if this action is wild
     * draw four, otherwise returns false.
     * @return A boolean
     */
    boolean isWildDrawFourAction();

    /**
     * Returns true if this action is skip,
     * otherwise returns false.
     * @return A boolean
     */
    boolean isSkipAction();

    /**
     * Returns true if this action is reverse,
     * otherwise returns false.
     * @return A boolean
     */
    boolean isReverseAction();

    /**
     * Returns true if this action is draw two,
     * otherwise returns false.
     * @return A boolean
     */
    boolean isDrawTwoAction();
}
