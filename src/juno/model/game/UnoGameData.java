package juno.model.game;

import juno.model.card.AbstractUnoCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author steghy
 */
public class UnoGameData implements AbstractUnoGameData {

    /* Game data */
    private Map<AbstractPlayer, ArrayList<AbstractUnoCard>> data;

    /* The UnoGameData instance */
    private static UnoGameData instance;

    /* Builds the UnoGameData instance */
    private UnoGameData(){}

    /**
     * Returns the UnoGameData instance
     * @return The UnoGameData instance
     */
    public static UnoGameData getInstance() {
        if(instance == null){
            instance = new UnoGameData();
        } return instance;
    }

    @Override
    public Map<AbstractPlayer, ArrayList<AbstractUnoCard>> getGameData(){
        return data;
    }


    @Override
    public void addCardToPlayer(AbstractUnoCard card, AbstractPlayer player) {
       if(data.containsKey(player)) {
           data.get(player).add(card);
       } else {
           throw new IllegalArgumentException("Invalid player");
       }
    }

    /* Initialize the UnoGameData instance */
    public void init(AbstractPlayer player1,
                     AbstractPlayer player2){
        data = new HashMap<>();
        data.put(player1, new ArrayList<>());
        data.put(player2, new ArrayList<>());
    }

    /* Initialize the UnoGameData instance */
    public void init(AbstractPlayer player1,
                     AbstractPlayer player2,
                     AbstractPlayer player3){
        data = new HashMap<>();
        data.put(player1, new ArrayList<>());
        data.put(player2, new ArrayList<>());
        data.put(player3, new ArrayList<>());
    }

    /* Initialize the UnoGameData instance */
    public void init(AbstractPlayer player1,
                     AbstractPlayer player2,
                     AbstractPlayer player3,
                     AbstractPlayer player4){
        data = new HashMap<>();
        data.put(player1, new ArrayList<>());
        data.put(player2, new ArrayList<>());
        data.put(player3, new ArrayList<>());
        data.put(player4, new ArrayList<>());
    }
}
