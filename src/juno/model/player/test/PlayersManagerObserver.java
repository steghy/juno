package juno.model.player.test;

import juno.model.player.players.AbstractPlayersMantainer;
import juno.model.util.Observer;
import juno.model.util.Subject;

public class PlayersManagerObserver implements Observer {

    public PlayersManagerObserver(Subject subject) {
       subject.addObserver(this);
    }

    public void update(Object object) {
        if(object instanceof AbstractPlayersMantainer<?> players) {
            System.out.println("[PlayersManager] notificato da players.");
        }
    }
}

