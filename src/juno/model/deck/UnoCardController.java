package juno.model.deck;

import juno.model.card.AbstractUnoCardAction;
import juno.model.card.AbstractUnoCard;
import juno.model.card.AbstractUnoCardColor;
import juno.model.card.AbstractUnoCardValue;

/**
 * @author steghy
 */
public class UnoCardController implements AbstractUnoCardController {

    private static UnoCardController instance;

    private UnoCardController(){}

    public static UnoCardController getInstance(){
        if(instance == null){
            instance = new UnoCardController();
        } return instance;
    }

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
            } else if(cardColor.isRed() && otherCardColor.isRed()) {
                return true;
            }
        }

        // ACTION CASE
        if(cardAction != null && otherCardAction != null){
            if(cardAction.isSkipAction() && otherCardAction.isSkipAction()){
                return true;
            } else if(cardAction.isReverseAction() && otherCardAction.isReverseAction()){
                return true;
            } else if(cardAction.isDrawTwoAction() && otherCardAction.isDrawTwoAction()){
                return true;
            }
        }

        // NUMBER CASE
        if(cardValue != null && otherCardValue != null){
            if(cardValue.isValueZero() && otherCardValue.isValueZero()){
                return true;
            } else if(cardValue.isValueOne() && otherCardValue.isValueOne()){
                return true;
            } else if(cardValue.isValueTwo() && otherCardValue.isValueTwo()){
                return true;
            } else if(cardValue.isValueThree() && otherCardValue.isValueThree()){
                return true;
            } else if(cardValue.isValueFour() && otherCardValue.isValueFour()){
                return true;
            } else if(cardValue.isValueFive() && otherCardValue.isValueFive()){
                return true;
            } else if(cardValue.isValueSix() && otherCardValue.isValueSix()){
                return true;
            } else if(cardValue.isValueSeven() && otherCardValue.isValueSeven()){
                return true;
            } else if(cardValue.isValueEight() && otherCardValue.isValueEight()){
                return true;
            } else if(cardValue.isValueNine() && otherCardValue.isValueNine()){
                return true;
            }
        }

        return false;
    }
}
