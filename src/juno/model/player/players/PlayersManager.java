package juno.model.player.players;

import juno.model.player.factory.AbstractPlayer;
import juno.model.util.Donut;
import juno.model.util.Observer;

public class PlayersManager implements AbstractPlayersManager<AbstractPlayer>, Observer {

    private Donut<AbstractPlayer> players;
    private static PlayersManager instance;

    private PlayersManager() {}

     public static PlayersManager getInstance() {
        if(instance == null) {
            instance = new PlayersManager();
        } return instance;
    }

    @Override
    public AbstractPlayer currentPlayer() {
        if(players != null) {
            return players.current();
        } else {
            throw new IllegalArgumentException("Players aren't set");
        }
    }

    @Override
    public AbstractPlayer nextPlayer() {
        if(players != null) {
            return players.peek();
        } else {
            throw new IllegalArgumentException("Players aren't set");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(Object object) {
        if(object instanceof AbstractPlayersMantainer<?> obj) {
            this.players = (Donut<AbstractPlayer>) obj.getPlayers();
        }
    }
}
