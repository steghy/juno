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

package juno.model.card;

import juno.model.subjects.factory.InterfaceSubject;
import juno.model.util.Observable;
import juno.model.util.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ActionPerformer
        extends AbstractActionPerformer<InterfaceSubject, InterfaceUnoCard, InterfaceUnoColor>
        implements Observable, Observer {

    private final List<Observer> observerList;
    private static ActionPerformer instance;

    private ActionPerformer(){
        observerList = new ArrayList<>();
    }

     public static ActionPerformer getInstance() {
        if(instance == null) instance = new ActionPerformer();
        return instance;
    }

    @Override
    public void performAction(@NotNull InterfaceUnoCard card,
                              InterfaceUnoColor color) {
        InterfaceUnoCardAction action = card.action();
        if(action.isWildAction()) {
            performWildAction(card, color);
        } else if(action.isWildDrawFourAction()) {
            performWildAction(card, color);
            performDrawAction(4);
        } else if(action.isSkipAction()) {
            getSkipper().skip();
        } else if(action.isReverseAction()) {
            getInverter().invert();
        } else if(action.isDrawTwoAction()) {
            performDrawAction(2);
        }
    }

    @Override
    public void update(@NotNull Object object) {
        if(object instanceof AbstractDiscardedPile<?> discardedPile) {
            Object lastCard = discardedPile.lastItem();
            if (lastCard instanceof InterfaceUnoCard card) {
                InterfaceUnoCardAction action = card.action();
                if (!action.isWildAction() && !action.isWildDrawFourAction()) {
                    performAction(card, null);
                }
            } else {
                throw new IllegalArgumentException("Invalid object type: " + lastCard.getClass());
            }
        } else {
            throw new IllegalArgumentException("Invalid object type: " + object.getClass());
        }
    }


    @Override
    public void addObserver(@NotNull Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(null));
    }

    private void performWildAction(@NotNull InterfaceUnoCard card,
                                   @NotNull InterfaceUnoColor color) {
        card.color().setUnoColor(color);
    }

    private void performDrawAction(int num) {
        for(int i = 0; i < num; i++) {
            getItemAdder().addItemTo(getPlayersManager().nextSubject(), getDeck().draw());
        }
    }
}