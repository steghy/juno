package juno.model.deck;

import juno.model.card.*;
import org.jetbrains.annotations.NotNull;

class CompatibilityChecker
        implements InterfaceCompatibilityChecker<InterfaceUnoCard> {

    private static CompatibilityChecker instance;

    private CompatibilityChecker(){}

    static CompatibilityChecker getInstance(){
        if(instance == null) instance = new CompatibilityChecker();
        return instance;
    }

    @Override
    public boolean areCompatible(@NotNull InterfaceUnoCard card,
                                 @NotNull InterfaceUnoCard otherCard){

        // CARD SPECIFICATIONS
        InterfaceUnoCardColor<InterfaceUnoColor> cardColor = card.color();
        InterfaceUnoCardAction cardAction = card.action();
        InterfaceUnoCardValue cardValue = card.value();

        // OTHER CARD SPECIFICATIONS
        InterfaceUnoCardColor<InterfaceUnoColor> otherCardColor = otherCard.color();
        InterfaceUnoCardAction otherCardAction = otherCard.action();
        InterfaceUnoCardValue otherCardValue = otherCard.value();

        // JOLLY CASE
        if(otherCardAction != null){
            if(otherCardAction.isWildAction() || otherCardAction.isWildDrawFourAction()){
                return true;
            }
        }

        // COLOR CASE
        if(cardColor != null && otherCardColor != null){
            InterfaceUnoColor color = cardColor.getUnoColor();
            InterfaceUnoColor otherColor = otherCardColor.getUnoColor();
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
            } if(cardValue.isValueOne() && otherCardValue.isValueOne()){
                return true;
            } if(cardValue.isValueTwo() && otherCardValue.isValueTwo()){
                return true;
            } if(cardValue.isValueThree() && otherCardValue.isValueThree()){
                return true;
            } if(cardValue.isValueFour() && otherCardValue.isValueFour()){
                return true;
            } if(cardValue.isValueFive() && otherCardValue.isValueFive()){
                return true;
            } if(cardValue.isValueSix() && otherCardValue.isValueSix()){
                return true;
            } if(cardValue.isValueSeven() && otherCardValue.isValueSeven()){
                return true;
            } if(cardValue.isValueEight() && otherCardValue.isValueEight()){
                return true;
            }
            return cardValue.isValueNine() && otherCardValue.isValueNine();
        } return false;
    }
}