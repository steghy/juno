/*
 *
 * MIT License
 *
 * Copyright (c) 2022 Simone Gentili
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package juno.model.deck;

import juno.model.card.*;
import org.jetbrains.annotations.NotNull;

/**
 * @author Simone Gentili
 */
class CompatibilityChecker
        implements InterfaceCompatibilityChecker<InterfaceUnoCard> {

    /* The CompatibilityChecker instance */
    private static CompatibilityChecker instance;

    /* Builds the CompatibilityChecker instance */
    private CompatibilityChecker(){}

    /**
     * Returns the CompatibilityChecker instance.
     * @return The CompatibilityChecker instance.
     */
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