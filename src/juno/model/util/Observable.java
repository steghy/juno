package juno.model.util;

public interface Observable {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void updateAll();
}