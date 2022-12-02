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

import juno.model.card.InterfaceCard;
import juno.model.card.actions.InterfaceAction;
import juno.model.card.colors.InterfaceColor;
import juno.model.card.values.InterfaceValue;
import org.jetbrains.annotations.NotNull;

/**
 * This class defines a compatibility checker
 * between two 'InterfaceCard' type cards.
 * The 'areCompatible(el1, el2)' method returns
 * true when the two specified elements are compatible.
 * @author Simone Gentili
 */
class CompatibilityChecker
        implements InterfaceCompatibilityChecker<InterfaceCard> {

    /* The CompatibilityChecker instance */
    private static CompatibilityChecker instance;

    /* Builds the CompatibilityChecker instance */
    private CompatibilityChecker() {}

    /**
     * Returns the CompatibilityChecker instance.
     * @return The CompatibilityChecker instance.
     */
    static CompatibilityChecker getInstance(){
        if(instance == null) instance = new CompatibilityChecker();
        return instance;
    }

    @Override
    public boolean areCompatible(@NotNull InterfaceCard card,
                                 @NotNull InterfaceCard otherCard){
        // Card specifications.
        InterfaceColor  cardColor  = card.color();
        InterfaceAction cardAction = card.action();
        InterfaceValue  cardValue  = card.value();

        // Other card specification.
        InterfaceColor  otherCardColor  = otherCard.color();
        InterfaceAction otherCardAction = otherCard.action();
        InterfaceValue  otherCardValue  = otherCard.value();

        // Jolly case.
        if (otherCardAction != null && otherCardAction.isJolly()) return true;

        // Color case.
        if (cardColor != null && otherCardColor != null) {
            if (cardColor.isBlue() && otherCardColor.isBlue()) {
                return true;
            } if (cardColor.isGreen() && otherCardColor.isGreen()) {
                return true;
            } if (cardColor.isYellow() && otherCardColor.isYellow()) {
                return true;
            } if (cardColor.isRed() && otherCardColor.isRed()) {
                return true;
            }
        }

        // Action case
        if (cardAction != null && otherCardAction != null) {
            if (cardAction.isSkip() && otherCardAction.isSkip()) {
                return true;
            } if (cardAction.isInvert() && otherCardAction.isInvert()) {
                return true;
            } if (cardAction.isDrawTwo() && otherCardAction.isDrawTwo()) {
                return true;
            }
        }

        // Number case
        if (cardValue != null && otherCardValue != null) {
            if (cardValue.isZero() && otherCardValue.isZero()){
                return true;
            } if (cardValue.isOne() && otherCardValue.isOne()) {
                return true;
            } if (cardValue.isTwo() && otherCardValue.isTwo()) {
                return true;
            } if (cardValue.isThree() && otherCardValue.isThree()) {
                return true;
            } if (cardValue.isFour() && otherCardValue.isFour()) {
                return true;
            } if (cardValue.isFive() && otherCardValue.isFive()) {
                return true;
            } if (cardValue.isSix() && otherCardValue.isSix()) {
                return true;
            } if (cardValue.isSeven() && otherCardValue.isSeven()) {
                return true;
            } if (cardValue.isEight() && otherCardValue.isEight()) {
                return true;
            } return cardValue.isNine() && otherCardValue.isNine();
        } return false;
    }

}