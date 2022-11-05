package juno.model.player.players;

import juno.model.util.Donut;
import juno.model.util.Observer;

public class PlayersManager<T> implements AbstractPlayersManager<T>, Observer {

    private Donut<T> subjects;
    private static PlayersManager<?> instance;

    private PlayersManager() {}

     public static PlayersManager<?> getInstance() {
        if(instance == null) {
            instance = new PlayersManager<>();
        } return instance;
    }

    @Override
    public T currentPlayer() {
        if(subjects != null) {
            return subjects.current();
        } else {
            throw new IllegalArgumentException("Players aren't set");
        }
    }

    @Override
    public T nextPlayer() {
        if(subjects != null) {
            return subjects.peek();
        } else {
            throw new IllegalArgumentException("Players aren't set");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(Object object) {
        if(object instanceof AbstractPlayersMantainer<?> obj) {
            this.subjects = (Donut<T>) obj.getPlayers();
        }
    }
}
