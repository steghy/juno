package juno.model.deck;

import juno.model.card.AbstractUnoAction;
import juno.model.card.AbstractUnoCard;
import juno.model.card.AbstractUnoColor;

import java.util.Stack;

public class DiscardedCards extends Stack<AbstractUnoCard> implements AbstractDiscardedCards<AbstractUnoCard> {

    public void put(AbstractUnoCard card){
        AbstractUnoCard topCard = this.peek();

        // TOP CARD SPECIFICATIONS
        AbstractUnoColor topCardColor = topCard.color();
        AbstractUnoAction topCardAction = topCard.action();
        int topCardValue = topCard.value();

        // CARD SPECIFICATIONS
        AbstractUnoColor cardColor = card.color();
        AbstractUnoAction cardAction = card.action();
        int cardValue = card.value();

        // JOLLY CASE
        if(cardAction.isWildAction() || cardAction.isWildDrawFourAction()) this.put(card);

        // ACTION CASE
        else if(topCardValue == -1 && cardValue == -1) {
            if(topCardAction.isSkipAction() && cardAction.isSkipAction()) this.put(card);
            else if(topCardAction.isReverseAction() && cardAction.isReverseAction()) this.put(card);
            else if(topCardAction.isDrawTwoAction() && cardAction.isDrawTwoAction()) this.put(card);
        }

        // COLOR CASE
        else if(topCardColor.isBlue() && cardColor.isBlue()) this.put(card);
        else if (topCardColor.isRed() && cardColor.isRed()) this.put(card);
        else if(topCardColor.isGreen() && cardColor.isGreen()) this.put(card);
        else if(topCardColor.isYellow() && cardColor.isYellow()) this.put(card);

        // NUMBER CASE
        else if(topCardValue == cardValue) this.put(card);
    }
}