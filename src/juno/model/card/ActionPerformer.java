package juno.model.card;

import juno.model.player.AbstractPlayer;

/**
 * @author steghy
 */
public class ActionPerformer extends AbstractActionPerformer<AbstractPlayer, AbstractUnoCard> {

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

                } else if(action.isReverseAction()) {

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

         }
    }

    /** Initialize the ActionPerformer instance */
    void initialize() {
         if(this.getDeck() == null) {
             throw new IllegalArgumentException("AbstractUnoDeck not set");
         } if(this.getCardPlayerManager() == null) {
             throw new IllegalArgumentException("AbstractCardPlayerManager not set");
        } init = true;
    }
}
