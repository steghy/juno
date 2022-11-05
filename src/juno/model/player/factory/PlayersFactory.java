package juno.model.player.factory;

import juno.model.util.Observer;
import juno.model.util.Subject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayersFactory extends AbstractPlayersFactory<AbstractPlayer> implements Subject {

    private final List<Observer> observerList;
    private Collection<AbstractPlayer> players;
    private static PlayersFactory instance;

    private PlayersFactory() {
        observerList = new ArrayList<>();
    }

    public static PlayersFactory getInstance() {
        if(instance == null) {
            instance = new PlayersFactory();
        } return instance;
    }

    @Override
    public void generate(int num, String name) {
        if(this.getNameFactory() != null) {
            players = new ArrayList<>(this.getNameFactory().getNames(num)
                    .stream()
                    .map(Player::new)
                    .toList());
            players.add(new Player(name));
            updateAll();
        } else {
            throw new IllegalArgumentException("AbstractNameFactory isn't set");
        }
    }

    @Override
    public Collection<AbstractPlayer> getPlayers() {
        if(players != null) {
            return players;
        } else {
            throw new IllegalArgumentException("Players has not been generated");
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
}
