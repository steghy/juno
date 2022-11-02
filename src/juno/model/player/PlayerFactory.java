package juno.model.player;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author steghy
 */
public class PlayerFactory extends AbstractPlayerFactory<AbstractPlayer> {

    private Collection<AbstractPlayer> players;
    private static PlayerFactory instance;

    private PlayerFactory() {}

    public static PlayerFactory getInstance() {
        if(instance == null) {
            instance = new PlayerFactory();
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
}
