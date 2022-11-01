package juno.model.card;

import juno.model.deck.AbstractUnoDeck;
import juno.model.player.AbstractCardPlayerManager;
import juno.model.player.AbstractPlayer;

/**
 * @author steghy
 */
public class ActionPerformer implements AbstractActionPerformer {

    /* The AbstractUnoDeck object */
    private AbstractUnoDeck<AbstractUnoCard> unoDeck;

    /* The AbstractCardPlayerManager object */
    private AbstractCardPlayerManager<AbstractPlayer, AbstractUnoCard> cardPlayerManager;

    /* Init value */
    private boolean init;

    /* The ActionPerformer instance */
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
                    cardPlayerManager.next();
                } else if(action.isReverseAction()) {
                    cardPlayerManager.invert();
                } else if(action.isDrawTwoAction()) {
                    performDrawAction(4);
                }
            }
        } else {
            throw new IllegalArgumentException("Not initialized");
        }
    }

    private void performWildAction(AbstractUnoCard card, AbstractUnoColor color) {
         card.color().setUnoColor(color);
    }

    private void performDrawAction(int num) {
         for(int i = 0; i < num; i++) {
             cardPlayerManager.addCardTo(cardPlayerManager.getNextPlayer(), unoDeck.draw());
         }
    }

    /** Initialize the ActionPerformer instance */
    void initialize() {
         if(unoDeck == null) {
             throw new IllegalArgumentException("AbstractUnoDeck not set");
         } if(cardPlayerManager == null) {
             throw new IllegalArgumentException("AbstractCardPlayerManager not set");
        } init = true;
    }

    /**
     * Sets the AbstractUnoDeck object of this instance.
     * @param unoDeck An AbstractUnoDeck object.
     */
    void setUnoDeck(AbstractUnoDeck<AbstractUnoCard> unoDeck) {
        this.unoDeck = unoDeck;
    }

    /**
     * Sets the AbstractCardPlayerManager object of this
     * instance.
     * @param cardPlayerManager An AbstractCardPlayerManager object.
     */
    void setCardPlayerManager(AbstractCardPlayerManager<AbstractPlayer, AbstractUnoCard> cardPlayerManager) {
        this.cardPlayerManager = cardPlayerManager;
    }
}
