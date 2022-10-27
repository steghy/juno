package juno.model.deck;

import juno.model.card.AbstractUnoCardAction;
import juno.model.card.AbstractUnoCard;
import juno.model.card.AbstractUnoCardColor;
import juno.model.card.AbstractUnoCardValue;

/**
 * @author steghy
 */
public class UnoCardController implements AbstractUnoCardController {

    @Override
    public boolean areCompatible(AbstractUnoCard card, AbstractUnoCard otherCard){

        // CARD SPECIFICATIONS
        AbstractUnoCardColor cardColor = card.color();
        AbstractUnoCardAction cardAction = card.action();
        AbstractUnoCardValue cardValue = card.value();

        // OTHER CARD SPECIFICATIONS
        AbstractUnoCardColor otherCardColor = otherCard.color();
        AbstractUnoCardAction otherCardAction = otherCard.action();
        AbstractUnoCardValue otherCardValue = otherCard.value();

        // JOLLY CASE
        if(otherCardAction != null){
            if(otherCardAction.isWildAction() || otherCardAction.isWildDrawFourAction()){
                return true;
            }
        }

        // COLOR CASE
        if(cardColor != null && otherCardColor != null){
            if(cardColor.isBlue() && otherCardColor.isBlue()){
                return true;
            } else if(cardColor.isGreen() && otherCardColor.isGreen()){
                return true;
            } else if(cardColor.isYellow() && otherCardColor.isYellow()){
                return true;
            } else return cardColor.isRed() && otherCardColor.isRed();
        } return false;
    }
}
