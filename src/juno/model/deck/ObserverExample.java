package juno.model.deck;


public class ObserverExample implements Observer {

    public ObserverExample(Subject subject) {
        subject.addObserver(this);
    }

    public void update(Object object) {
        if(object instanceof UnoDeck deck) {
            System.out.println("L'ultima carta pescata è " + deck.getLastCard());
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }



}
