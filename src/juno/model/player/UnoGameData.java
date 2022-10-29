package juno.model.player;

import juno.model.card.AbstractUnoCard;

import java.util.List;
import java.util.Map;

/**
 * @author steghy
 */
public class UnoGameData implements AbstractUnoGameData<AbstractPlayer, AbstractUnoCard> {



    /* Game data */
    private Map<AbstractPlayer, List<AbstractUnoCard>> data;

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
    public Map<AbstractPlayer, List<AbstractUnoCard>> getGameData(){
        return data;
    }
}
