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
import juno.model.subjects.InterfacePlayer;
import juno.model.subjects.ai.InterfaceAi;
import juno.model.util.Donut;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class CardEffectActivator
        extends AbstractCardEffectActivator<InterfaceCard, Donut<InterfacePlayer<InterfaceCard>>, InterfaceColor>
        implements Observer {

    // The CardEffectActivator instance.
    private static CardEffectActivator instance;

    // Builds the CardEffectActivator instance.
    private CardEffectActivator() {}

    /**
     * Returns the CardEffectActivator instance.
     * @return The CardEffectActivator instance.
     */
    public static CardEffectActivator getInstance() {
        if(instance == null) instance = new CardEffectActivator();
        return instance;
    }

    @Override
    public void activate(@NotNull InterfaceCard card) {
        InterfaceAction action = card.action();
        Donut<InterfacePlayer<InterfaceCard>> players =
                Objects.requireNonNull(getPlayersProvider()).provide();
        if(action != null) {
            if(action.isInvert()) Objects.requireNonNull(getInverter()).invert();
            else if(action.isSkip()) Objects.requireNonNull(getTurnJumper()).next();
            else if(action.isDrawTwo() || action.isDrawFour()) {
                InterfacePlayer<InterfaceCard> nextPlayer = players.peek();
                Deck<InterfaceCard> deck = (Deck<InterfaceCard>)
                        Objects.requireNonNull(getDeck());
                nextPlayer.add(deck.draw());
                nextPlayer.add(deck.draw());
                if(action.isDrawFour()) {
                    nextPlayer.add(deck.draw());
                    nextPlayer.add(deck.draw());
                } Objects.requireNonNull(getTurnJumper()).next();
            } if(action.isJolly()) {
                InterfacePlayer<InterfaceCard> currentPlayer = players.current();
                if(currentPlayer instanceof InterfaceAi<?, ?> aiPlayer) {
                    Object temp = aiPlayer.color();
                    if(temp instanceof InterfaceColor color) {
                        Objects.requireNonNull(getActualColor()).set(color);
                    } else throw new IllegalArgumentException(
                            "Invalid object type: " + temp.getClass() +
                                    ". InterfaceColor type expected.");
                }
            }
        }
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof InterfaceDiscardedPile<?> discardedPile) {
            if(discardedPile.size() > 1)
                activate((InterfaceCard) discardedPile.provide());
        } else throw new IllegalArgumentException(
                "Invalid object type: " + object.getClass() +
                        ". InterfaceDiscardedPile type expected");
    }

}