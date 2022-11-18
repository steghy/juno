package juno.model.card;

import juno.model.deck.AbstractDeck;
import juno.model.subjects.hands.AbstractItemAdder;
import juno.model.subjects.shift.AbstractInverter;
import juno.model.subjects.players.AbstractSubjectsManager;
import juno.model.subjects.shift.AbstractTurnMover;
import juno.model.subjects.shift.AbstractTurnJumper;

public abstract class AbstractActionPerformer<T, E, C> implements InterfaceActionPerformer<E, C> {

    private AbstractDeck<E> deck;
    private AbstractTurnMover nextTurnClass;
    private AbstractTurnJumper skipper;
    private AbstractItemAdder<T, E> itemAdder;
    private AbstractInverter inverter;
    private AbstractSubjectsManager<T> playersManager;

    void setDeck(AbstractDeck<E> deck) {
        this.deck = deck;
    }
    void setItemAdder(AbstractItemAdder<T, E> itemAdder) {
        this.itemAdder = itemAdder;
    }
    void setSkipper(AbstractTurnJumper skipper) {
        this.skipper = skipper;
    }
    void setNextTurnClass(AbstractTurnMover nextTurnClass) {
        this.nextTurnClass = nextTurnClass;
    }
    void setInverter(AbstractInverter inverter) {
        this.inverter = inverter;
    }
    void setPlayersManager(AbstractSubjectsManager<T> playersManager){
        this.playersManager = playersManager;
    }

    AbstractDeck<E> getDeck() {
        return deck;
    }
    AbstractItemAdder<T, E> getItemAdder() {
        return itemAdder;
    }
    AbstractTurnMover getNextTurn() {
        return nextTurnClass;
    }
    AbstractTurnJumper getSkipper() {
        return skipper;
    }
    AbstractInverter getInverter() {
        return this.inverter;
    }
    AbstractSubjectsManager<T> getPlayersManager() {
        return this.playersManager;
    }
}