package juno.model.subjects.ai;

import juno.model.subjects.players.InterfaceUnoPlayer;

public interface InterfaceUnoAi<T> extends InterfaceUnoPlayer<T> {

    T makeAChoice();

}
