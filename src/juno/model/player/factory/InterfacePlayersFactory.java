package juno.model.player.factory;

import java.util.Collection;

public interface InterfacePlayersFactory<T> {

    Collection<T> getPlayers();
}
