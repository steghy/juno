package juno.model.game;

/**
 * @author steghy
 */
public class Player implements AbstractPlayer {

    /* The Player object name */
    private final String playerName;

    /**
     * Builds a Player
     * @param playerName A String object that represents the
     *          Player object name
     */
    public Player(String playerName){
       this.playerName = playerName;
    }


    @Override
    public String getPlayerName(){
        return this.playerName;
    }
}
