package juno.model.deck;


public interface Subject {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void updateAll();
}
