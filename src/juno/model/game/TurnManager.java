package juno.model.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TurnManager {


    List<AbstractPlayer> players;

    private static TurnManager instance;

    private TurnManager() {}

    public static TurnManager getInstance() {
        if(instance == null) {
            instance = new TurnManager();
        } return instance;
    }

    public void setPlayers(AbstractPlayer... players) {
        if(players == null || players.length < 2) {
            throw new IllegalArgumentException("Invalid players length");
        }
        this.players = new ArrayList<>();
        this.players.addAll(Arrays.asList(players));
    }

    public void initializeFirstPlayer() {

        Random random = new Random();
        int index = random.nextInt(players.size());

        List<AbstractPlayer> playersClone = new ArrayList<>();
        playersClone.addAll(players);

        players.clear();

        players.add(playersClone.get(index));

        List<AbstractPlayer> rightSide = playersClone.subList(index + 1, playersClone.size());
        List<AbstractPlayer> leftSide = playersClone.subList(0, index);

        players.addAll(rightSide);
        players.addAll(leftSide);
    }

    public List<AbstractPlayer> getPlayers() {
        return players;
    }

}
