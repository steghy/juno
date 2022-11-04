package juno.model.player.players;

public interface AbstractPlayersManager<T> {

    T currentPlayer();

    T nextPlayer();
}

