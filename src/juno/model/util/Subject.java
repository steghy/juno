package juno.model.util;


/**
 * Subject interface.
 * Subject-Observer desing pattern.
 */
public interface Subject {

    /**
     * Adds the specified Observer object
     * in the ObserverList
     * @param observer An Observer object
     */
    void addObserver(Observer observer);

    /**
     * Remove the specified Observer object
     * from the ObserverList.
     * @param observer An Observer object
     */
    void removeObserver(Observer observer);

    /**
     * Update all the Observer object contained
     * in the ObserverList.
     */
    void updateAll();
}
