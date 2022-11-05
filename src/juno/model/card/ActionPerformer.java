package juno.model.card;

import juno.model.deck.AbstractDiscardedPile;
import juno.model.player.factory.AbstractPlayer;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.ArrayList;
import java.util.List;

public class ActionPerformer extends AbstractActionPerformer<
        AbstractPlayer,
        AbstractUnoCard<
                AbstractUnoCardAction,
                AbstractUnoCardColor<AbstractUnoColor>,
                AbstractUnoCardValue>,
        AbstractUnoColor>
        implements Subject, Observer {

    private final List<Observer> observerList;
    private boolean init;
    private static ActionPerformer instance;

    private ActionPerformer(){
        observerList = new ArrayList<>();
        init = false;
    }

     public static ActionPerformer getInstance() {
        if(instance == null) {
            instance = new ActionPerformer();
        } return instance;
    }

    @Override
    public void performAction(AbstractUnoCard<
            AbstractUnoCardAction,
            AbstractUnoCardColor<AbstractUnoColor>,
            AbstractUnoCardValue> card,
                              AbstractUnoColor color) {
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
                    getSkipper().skip();
                } else if(action.isReverseAction()) {
                    getInverter().invert();
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
    @SuppressWarnings("unchecked")
    public void update(Object object) {
        if(init) {
            if(object instanceof AbstractDiscardedPile<?> discardedPile) {
                Object lastCard = discardedPile.lastItem();
                if(lastCard instanceof AbstractUnoCard<?, ?, ?> card) {
                    AbstractUnoCardAction action = (AbstractUnoCardAction) card.action();
                    if(action != null) {
                        if(!action.isWildAction() && !action.isWildDrawFourAction()) {
                            performAction((AbstractUnoCard<
                                    AbstractUnoCardAction,
                                    AbstractUnoCardColor<AbstractUnoColor>,
                                    AbstractUnoCardValue>) card,
                                    null);
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

    void initialize() {
        if(getDeck() == null) {
            throw new IllegalArgumentException("AbstractUnoDeck isn't set");
        } if(getHandsManager() == null) {
            throw new IllegalArgumentException("InterfaceHandsManager isn'2 set");
        } if(getNextTurn() == null) {
            throw new IllegalArgumentException("InterfaceShiftManager isn't set");
        } if(getInverter() == null) {
            throw new IllegalArgumentException("AbstractInverter isn't set");
        } if(getPlayersManager() == null) {
            throw new IllegalArgumentException("AbstractPlayerManager isn't set");
        } if(getSkipper() == null) {
            throw new IllegalArgumentException("AbstractSkipper isn't set");
        } init = true;
    }

    private void performWildAction(AbstractUnoCard<
            AbstractUnoCardAction,
            AbstractUnoCardColor<AbstractUnoColor>,
            AbstractUnoCardValue> card,
                                   AbstractUnoColor color) {
        card.color().setUnoColor(color);
    }

    private void performDrawAction(int num) {
        for(int i = 0; i < num; i++) {
            getHandsManager().addItem(getPlayersManager().nextPlayer(), getDeck().draw());
        }
    }
}