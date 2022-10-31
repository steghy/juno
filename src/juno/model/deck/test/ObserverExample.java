package juno.model.deck.test;

import juno.model.card.AbstractUnoCard;
import juno.model.deck.AbstractDiscardPile;
import juno.model.deck.Observer;
import juno.model.deck.Subject;
import juno.model.deck.UnoDeck;

public class ObserverExample implements Observer {

    public ObserverExample(Subject subject) {
        subject.addObserver(this);
    }

    public ObserverExample() {

    }

    public void subscribe(Subject subject) {
        subject.addObserver(this);
    }

    @Override
    public void update(Object object) {
        if(object instanceof UnoDeck unoDeck) {
           System.out.println("Prima carta nella pila delle carte scartate " + unoDeck.getLastCardInserted());
        }
    }
}
