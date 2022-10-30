package juno.model.deck;

import juno.model.card.AbstractUnoCard;

public class ObserverExample implements Observer{

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
        if(object instanceof AbstractDiscardPile<?> discardPile) {
           System.out.println("Prima carta nella pila delle carte scartate " + discardPile.get(discardPile.size() - 1));
        }
    }
}
