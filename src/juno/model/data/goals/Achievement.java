package juno.model.data.goals;

/**
 * This interface describes achievement.
 * @author Simone Gentili
 */
@FunctionalInterface
public interface Achievement {

    /**
     * Returns true if, and only if,
     * this achievement is unlocked.
     * @return A boolean.
     */
    boolean isUnlocked();

}