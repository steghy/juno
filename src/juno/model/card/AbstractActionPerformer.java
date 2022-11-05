package juno.model.card;

import juno.model.deck.AbstractDeck;
import juno.model.player.shift.AbstractInverter;
import juno.model.player.players.AbstractPlayersManager;
import juno.model.player.hands.AbstractHandsManager;
import juno.model.player.shift.AbstractTurnMover;
import juno.model.player.shift.AbstractTurnJumper;

public abstract class AbstractActionPerformer<T, E, C> implements InterfaceActionPerformer<E, C> {

    private AbstractDeck<E> deck;
    private AbstractTurnMover nextTurnClass;
    private AbstractTurnJumper skipper;
    private AbstractHandsManager<T, E> handsManager;
    private AbstractInverter inverter;
    private AbstractPlayersManager<T> playersManager;

    void setDeck(AbstractDeck<E> deck) {
        this.deck = deck;
    }
    void setHandsManager(AbstractHandsManager<T, E> handsManager) {
        this.handsManager = handsManager;
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
    void setPlayersManager(AbstractPlayersManager<T> playersManager){
        this.playersManager = playersManager;
    }

    AbstractDeck<E> getDeck() {
        return deck;
    }
    AbstractHandsManager<T, E> getHandsManager() {
        return handsManager;
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
    AbstractPlayersManager<T> getPlayersManager() {
        return this.playersManager;
    }
}