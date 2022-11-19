package juno.model.card;

import juno.model.deck.AbstractDiscardedPile;
import juno.model.subjects.factory.AbstractSubject;
import juno.model.util.Observer;
import juno.model.util.Observable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ActionPerformer extends AbstractActionPerformer<AbstractSubject, AbstractUnoCard, AbstractUnoColor> implements Observable, Observer {

    private final List<Observer> observerList;
    private static ActionPerformer instance;

    private ActionPerformer(){
        observerList = new ArrayList<>();
    }

     public static ActionPerformer getInstance() {
        if(instance == null) {
            instance = new ActionPerformer();
        } return instance;
    }

    @Override
    public void performAction(@NotNull AbstractUnoCard card, AbstractUnoColor color) {
        AbstractUnoCardAction action = card.action();
        if(action.isWildAction()) {
            performWildAction(card, color);
        } else if(action.isWildDrawFourAction()) {
            performWildAction(card, color);
            performDrawAction(4);
        } else if(action.isSkipAction()) {
            getSkipper().skip();
        } else if(action.isReverseAction()) {
            getInverter().invert();
        } else if(action.isDrawTwoAction()) {
            performDrawAction(2);
        }
    }

    @Override
    public void update(Object object) {
        if(object instanceof AbstractDiscardedPile<?> discardedPile) {
            Object lastCard = discardedPile.lastItem();
            if (lastCard instanceof AbstractUnoCard card) {
                AbstractUnoCardAction action = card.action();
                if (!action.isWildAction() && !action.isWildDrawFourAction()) {
                    performAction(card, null);
                }
            } else {
                throw new IllegalArgumentException("Invalid object type: " + lastCard.getClass());
            }
        } else {
            throw new IllegalArgumentException("Invalid object type: " + object.getClass());
        }
    }


    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(null));
    }

    private void performWildAction(@NotNull AbstractUnoCard card, @NotNull AbstractUnoColor color) {
        card.color().setUnoColor(color);
    }

    private void performDrawAction(int num) {
        for(int i = 0; i < num; i++) {
            getItemAdder().addItemTo(getPlayersManager().nextSubject(), getDeck().draw());
        }
    }
}