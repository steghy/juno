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
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * This class defines a compatibility checker
 * between the specified card and the top card
 * of the discarded pile.
 * @author Simone Gentili
 */
public class CompatibilityChecker
        extends AbstractCompatibilityChecker<InterfaceCard, InterfaceColor> {

    // The CompatibilityChecker instance.
    private static CompatibilityChecker instance;

    // Builds the CompatibilityChecker instance.
    private CompatibilityChecker() {}

    /**
     * Returns the CompatibilityChecker instance.
     * @return The CompatibilityChecker instance.
     */
    public static CompatibilityChecker getInstance(){
        if(instance == null) instance = new CompatibilityChecker();
        return instance;
    }

    @Override
    public boolean isCompatible(@NotNull InterfaceCard card) {

        // Top card of the discarded pile.
        InterfaceDiscardedPile<InterfaceCard> discardedPile = getDiscardedPile();
        Objects.requireNonNull(discardedPile);
        InterfaceCard topCard = discardedPile.provide();
        InterfaceColor  topCardColor  = topCard.color();
        InterfaceAction topCardAction = topCard.action();
        Integer         topCardValue  = topCard.value();

        // Input card.
        InterfaceColor  cardColor  = card.color();
        InterfaceAction cardAction = card.action();
        Integer         cardValue  = card.value();

        // Jolly case.
        if (cardAction != null && cardAction.isJolly()) return true;

        // Color case.
        InterfaceColor actualColor = Objects.requireNonNull(getProvider()).provide();
        if (cardColor != null) {
            if (cardColor.isYellow() && actualColor.isYellow()) {
                return true;
            } if (cardColor.isBlue() && actualColor.isBlue()) {
                return true;
            } if (cardColor.isGreen() && actualColor.isGreen()) {
                return true;
            } if (cardColor.isRed() && actualColor.isRed()) {
                return true;
            }

            if (topCardColor != null) {
                if (cardColor.isBlue() && topCardColor.isBlue()) {
                    return true;
                } if (cardColor.isGreen() && topCardColor.isGreen()) {
                    return true;
                } if (cardColor.isYellow() && topCardColor.isYellow()) {
                    return true;
                } if (cardColor.isRed() && topCardColor.isRed()) {
                    return true;
                }
            }
        }

        // Action case
        if (cardAction != null && topCardAction != null) {
            if (cardAction.isSkip() && topCardAction.isSkip()) {
                return true;
            } if (cardAction.isInvert() && topCardAction.isInvert()) {
                return true;
            } if (cardAction.isDrawTwo() && topCardAction.isDrawTwo()) {
                return true;
            }
        }

        // Number case
        if (cardValue != null && topCardValue != null) {
            return cardValue.equals(topCardValue);
        } return false;
    }

}