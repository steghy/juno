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

import juno.model.deck.AbstractDeck;
import juno.model.subjects.hands.InterfaceItemAdder;
import juno.model.subjects.players.InterfaceSubjectsManager;
import juno.model.subjects.shift.InterfaceInverter;
import juno.model.subjects.shift.InterfaceTurnJumper;
import juno.model.subjects.shift.InterfaceTurnMover;

public abstract class AbstractActionPerformer<T, E, C> implements InterfaceActionPerformer<E, C> {

    private AbstractDeck<E> deck;
    private InterfaceTurnMover nextTurnClass;
    private InterfaceTurnJumper skipper;
    private InterfaceItemAdder<T, E> itemAdder;
    private InterfaceInverter inverter;
    private InterfaceSubjectsManager<T> playersManager;

    void setDeck(AbstractDeck<E> deck) {
        this.deck = deck;
    }
    void setItemAdder(InterfaceItemAdder<T, E> itemAdder) {
        this.itemAdder = itemAdder;
    }
    void setSkipper(InterfaceTurnJumper skipper) {
        this.skipper = skipper;
    }
    void setNextTurnClass(InterfaceTurnMover nextTurnClass) {
        this.nextTurnClass = nextTurnClass;
    }
    void setInverter(InterfaceInverter inverter) {
        this.inverter = inverter;
    }
    void setPlayersManager(InterfaceSubjectsManager<T> playersManager){
        this.playersManager = playersManager;
    }

    AbstractDeck<E> getDeck() {
        return deck;
    }
    InterfaceItemAdder<T, E> getItemAdder() {
        return itemAdder;
    }
    InterfaceTurnMover getNextTurn() {
        return nextTurnClass;
    }
    InterfaceTurnJumper getSkipper() {
        return skipper;
    }
    InterfaceInverter getInverter() {
        return this.inverter;
    }
    InterfaceSubjectsManager<T> getPlayersManager() {
        return this.playersManager;
    }
}