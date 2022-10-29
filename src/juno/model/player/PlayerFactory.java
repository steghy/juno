package juno.model.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerFactory implements AbstractUnoGameData.AbstractPlayerFactory {

    private List<AbstractPlayer> players;

    private static PlayerFactory instance;

    private PlayerFactory(){}

    public static PlayerFactory getInstance(){
        if(instance == null) {
            instance = new PlayerFactory();
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
    public List<AbstractPlayer> getPlayers() {
        return players;
    }
}
