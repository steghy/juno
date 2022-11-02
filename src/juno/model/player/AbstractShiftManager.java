package juno.model.player;

import juno.model.util.Donut;

public abstract class AbstractShiftManager<T> implements InterfaceShiftManager<T> {

    private Donut<T> subjects;
    private InterfacePlayerFactory<T> playerFactory;

    /**
     * Sets the InterfacePlayerFactory object of this instance.
     * @param playerFactory An InterfacePlayerFactory object.
     */
    public void setPlayerFactory(InterfacePlayerFactory<T> playerFactory) {
        this.playerFactory = playerFactory;
    }

    /**
     * Returns the InterfacePlayerFactory<T> object of this instance.
     * @return An InterfacePlayerFactory<T> object.
     */
    public InterfacePlayerFactory<T> getPlayerFactory() {
        return playerFactory;
    }

    /**
     * Returns the Donut<T> object of this instance.
     * @return A Donut<T> object.
     */
    public Donut<T> getDonut() {
        return subjects;
    }
}
