package juno.model.player.test;

import juno.model.player.players.AbstractPlayersMantainer;
import juno.model.util.Observer;
import juno.model.util.Subject;

public class InverterObserver implements Observer {

    public InverterObserver(Subject subject) {
        subject.addObserver(this);
    }

    @Override
    public void update(Object object) {
        if(object instanceof AbstractPlayersMantainer<?> players) {
            System.out.println("[InverterObserver] notificato da Players");
        }
    }
}
