package juno.model.player;

import juno.model.util.Observer;
import juno.model.util.Subject;

public class ObserverExample implements Observer {


    public ObserverExample(Subject subject) {
        subject.addObserver(this);
    }


    @Override
    public void update(Object object) {
        if(object instanceof AbstractCardPlayerManager unoCardPlayerManager) {
            // unoCardPlayerManager.getCardOf(unoCardPlayerManager.getCurrentPlayer()).forEach(System.out::println);
        }
    }
}
