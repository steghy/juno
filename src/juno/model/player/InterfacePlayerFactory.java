package juno.model.player;

import java.util.Collection;

public interface InterfacePlayerFactory<T> {

    void generate(int num, String name);

    Collection<T> getPlayers();
}
