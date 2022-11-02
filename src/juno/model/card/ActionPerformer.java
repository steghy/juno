package juno.model.card;

import juno.model.deck.AbstractDiscardedPile;
import juno.model.player.AbstractPlayer;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.List;

/**
 * @author steghy
 */
public class ActionPerformer extends AbstractActionPerformer<AbstractPlayer, AbstractUnoCard, AbstractUnoColor> implements Subject, Observer {

    private List<Observer> observerList;
    private boolean init;
    private static ActionPerformer instance;

    /* Builds the ActionPerformer instance. */
    private ActionPerformer(){
        init = false;
    }

    /**
     * Returns the ActionPerformer instance.
     * @return The ActionPerformer instance.
     */
     public static ActionPerformer getInstance() {
        if(instance == null) {
            instance = new ActionPerformer();
        } return instance;
    }

    @Override
    public void performAction(AbstractUnoCard card, AbstractUnoColor color) {
        if(init) {
            if(card.action() != null) {
                AbstractUnoCardAction action = card.action();
                if(action.isWildAction() || action.isWildDrawFourAction() && color == null) {
                    throw new IllegalArgumentException("Color is null");
                } if(action.isWildAction()) {
                    performWildAction(card, color);
                } else if(action.isWildDrawFourAction()) {
                    performWildAction(card, color);
                    performDrawAction(4);
                } else if(action.isSkipAction()) {

                } else if(action.isReverseAction()) {
                    getShiftManager().invert();
                } else if(action.isDrawTwoAction()) {
                    performDrawAction(2);
                }
            } else {
                throw new IllegalArgumentException("Not an action card");
            }
        } else {
            throw new IllegalArgumentException("Not initialized");
        }
    }

    @Override
    public void update(Object object) {
        if(init) {
            if(object instanceof AbstractDiscardedPile<?> discardedPile) {
                Object lastCard = discardedPile.lastItem();
                if(lastCard instanceof AbstractUnoCard card) {
                    AbstractUnoCardAction action = card.action();
                    if(action != null) {
                        if(!action.isWildAction() && !action.isWildDrawFourAction()) {
                            performAction(card, null);
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Invalid card");
                }
            } else {
                throw new IllegalArgumentException("Invalid Subject");
            }
        } else {
            throw new IllegalArgumentException("ActionPerformer not initialized");
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(null));
    }

    /** Initialize the ActionPerformer instance */
    void initialize() {
        if(this.getDeck() == null) {
            throw new IllegalArgumentException("AbstractUnoDeck not set");
        } if(this.getCardPlayerManager() == null) {
            throw new IllegalArgumentException("AbstractCardPlayerManager not set");
        } init = true;
    }

    private void performWildAction(AbstractUnoCard card, AbstractUnoColor color) {
        card.color().setUnoColor(color);
    }

    private void performDrawAction(int num) {
        for(int i = 0; i < num; i++) {

        }
    }

}
