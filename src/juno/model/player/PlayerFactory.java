package juno.model.player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author steghy
 */
public class PlayerFactory extends AbstractPlayerFactory<AbstractPlayer> {

    /* The PlayerFactory instance */
    private static PlayerFactory instance;

    /* Builds the PlayerFactory instance */
    private PlayerFactory() {}

    /**
     * Returns the PlayerFactory instance.
     * @return The PlayerFactory instance.
     */
    public static PlayerFactory getInstance() {
        if(instance == null) {
            instance = new PlayerFactory();
        } return instance;
    }

    @Override
    public List<AbstractPlayer> getPlayers(int num, String name) {
        List<AbstractPlayer> players = new ArrayList<>(this.getNameFactory().getNames(num)
                .stream()
                .map(Player::new)
                .toList());
        players.add(new Player(name));
        return players;
    }
}
