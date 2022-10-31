package juno.model.deck;

import juno.model.card.*;

/**
 * @author steghy
 */
class UnoCardCompatibilityChecker implements AbstractCompatibilityChecker<AbstractUnoCard> {

    /* The UnoCardCompatibilityChecker instance */
    private static UnoCardCompatibilityChecker instance;

    /* Builds the UnoCardCompatibilityChecker instance */
    private UnoCardCompatibilityChecker(){}

    /**
     * Returns the UnoCardCompatibilityChecker instance.
     * @return The UnoCardCompatibilityChecker instance.
     */
    static UnoCardCompatibilityChecker getInstance(){
        if(instance == null){
            instance = new UnoCardCompatibilityChecker();
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
            AbstractUnoColor color = cardColor.getUnoColor();
            AbstractUnoColor otherColor = otherCardColor.getUnoColor();
            if(color.isBlue() && otherColor.isBlue()){
                return true;
            } else if(color.isGreen() && otherColor.isGreen()){
                return true;
            } else if(color.isYellow() && otherColor.isYellow()){
                return true;
            } else if(color.isRed() && otherColor.isRed()) {
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
