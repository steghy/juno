package juno.model.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class PlayerProvider implements AbstractPlayerProvider{

    private Collection<AbstractPlayer> players;

    private static PlayerProvider instance;

    private PlayerProvider(){}

    public static PlayerProvider getInstance(){
        if(instance == null) {
            instance = new PlayerProvider();
        } return instance;
    }

    public void setPlayers(AbstractPlayer... players) {
        if(players == null || players.length < 2 ) {
            throw new IllegalArgumentException("At least two players");
        }

        this.players = new ArrayList<>();
        this.players.addAll(Arrays.asList(players));
    }

    @Override
    public Collection<AbstractPlayer> getPlayers() {
        return players;
    }
}
