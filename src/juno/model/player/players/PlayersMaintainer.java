package juno.model.player.players;

import juno.model.player.factory.AbstractPlayer;
import juno.model.player.factory.InterfacePlayersFactory;
import juno.model.util.Donut;
import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayersMaintainer implements AbstractPlayersMantainer<AbstractPlayer>, Subject, Observer {

    private Donut<AbstractPlayer> players;
    private final List<Observer> observerList;
    private static PlayersMaintainer instance;

    private PlayersMaintainer() {
        observerList = new ArrayList<>();
    }

    public static PlayersMaintainer getInstance() {
        if(instance == null) {
            instance = new PlayersMaintainer();
        } return instance;
    }

    @Override
    public Donut<AbstractPlayer> getPlayers() {
        if(players != null) {
            return players;
        } else {
            throw new IllegalArgumentException("Players Donut isn't set");
        }
    }


    @Override
    public void addObserver(Observer observer) {
       observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void updateAll() {
        observerList.forEach(observer -> observer.update(this));
    }

    @Override
    @SuppressWarnings("unchecked")
    public void update(Object object) {
        if(object instanceof InterfacePlayersFactory<?> playersFactory) {
            players = new Donut<>();
            players.addAll((Collection<? extends AbstractPlayer>) playersFactory.getPlayers());
            updateAll();
        }
    }

    public void subscribe(Subject subject) {
        subject.addObserver(this);
    }
}
