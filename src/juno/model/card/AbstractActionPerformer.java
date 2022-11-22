package juno.model.card;

import juno.model.deck.AbstractDeck;
import juno.model.subjects.hands.InterfaceItemAdder;
import juno.model.subjects.shift.InterfaceInverter;
import juno.model.subjects.players.InterfaceSubjectsManager;
import juno.model.subjects.shift.InterfaceTurnMover;
import juno.model.subjects.shift.InterfaceTurnJumper;

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