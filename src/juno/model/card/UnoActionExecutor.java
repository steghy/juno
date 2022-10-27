package juno.model.card;

import juno.model.deck.AbstractUnoDeck;
import juno.model.game.AbstractUnoTurnController;
import juno.model.game.AbstractUnoGameData;

/**
 * @author steghy
 */
public class UnoActionExecutor implements AbstractUnoActionExecutor {

    @Override
    public void execute(AbstractUnoCardAction action,
                        AbstractUnoDeck<AbstractUnoCard> deck,
                        AbstractUnoGameData gameData,
                        AbstractUnoTurnController turnController){


        // COLORED CARDS ACTIONS
        if(action.isDrawTwoAction()) {
            gameData.addCardToPlayer(deck.draw(), turnController.getNextPlayer());
            gameData.addCardToPlayer(deck.draw(), turnController.getNextPlayer());
        } else if(action.isReverseAction()) {
            turnController.reverseTurn();
        } else if(action.isSkipAction()) {
            turnController.skipTurn();
        }

        // JOLLY ACTION
        else if(action.isWildAction()){
            // CHANGE COLOR HERE
        } else if(action.isWildDrawFourAction()) {
            gameData.addCardToPlayer(deck.draw(), turnController.getNextPlayer());
            gameData.addCardToPlayer(deck.draw(), turnController.getNextPlayer());
            gameData.addCardToPlayer(deck.draw(), turnController.getNextPlayer());
            gameData.addCardToPlayer(deck.draw(), turnController.getNextPlayer());
            // CHANGE COLOR HERE
        }
    }
}
