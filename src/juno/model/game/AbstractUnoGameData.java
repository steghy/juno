package juno.model.game;

import juno.model.card.AbstractUnoCard;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author steghy
 */
public interface AbstractUnoGameData {

    /**
     * Returns the Map that contains the AbstractPlayer
     * objects and its AbstractUnoCard objects.
     *
     * @return A Map object.
     */
    Map<AbstractPlayer, ArrayList<AbstractUnoCard>> getGameData();

    /**
     * Adds the specified AbstractUnoCard to the
     * specified AbstractPlayer's hand.
     * @param card An AbstractUnoCard object.
     * @param player An AbsractPlayer object.
     */
    void addCardToPlayer(AbstractUnoCard card, AbstractPlayer player);
}
