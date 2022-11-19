package juno.model.subjects.ai;

import juno.model.subjects.players.AbstractUnoPlayer;

public interface InterfaceUnoAi<T> extends AbstractUnoPlayer<T> {

    T makeAChoice();

}
