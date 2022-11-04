package juno.model.player.players;

import juno.model.util.Donut;

public interface AbstractPlayersMantainer<T> {

    Donut<T> getPlayers();
}
