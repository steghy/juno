package juno.model.card;

/**
 * This interface defines the method.
 * to recognize a color of the Uno card game.
 */
public interface AbstractUnoCardColor {

    /**
     * Returns true if this color is red,
     * otherwise returns false.
     * @return A boolean.
     */
    boolean isRed();

    /**
     * Returns true if this color is green,
     * otherwise returns false.
     * @return A boolean.
     */
    boolean isGreen();

    /**
     * Returns true if this color is blue,
     * otherwise returns false.
     * @return A boolean.
     */
    boolean isBlue();

    /**
     * Returns true if this color is yellow,
     * otherwise returns false.
     * @return A boolean.
     */
    boolean isYellow();
}
