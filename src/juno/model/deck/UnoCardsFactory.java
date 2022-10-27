package juno.model.deck;

import juno.model.card.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author steghy
 */
public class UnoCardsFactory implements AbstractUnoCardsFactory {

    /* The FactoryUnoCard instance */
    private static UnoCardsFactory instance;

    /* Builds the FactoryUnoCard instance */
    private UnoCardsFactory() {}

    /**
     * Returns the FactoryUnoCard instance
     * @return The FactoryUnoCard instance
     */
    public static UnoCardsFactory getInstance(){
        if(instance == null){
            instance = new UnoCardsFactory();
        } return instance;
    }

    @Override
    public List<AbstractUnoCard> getRedCards() {
        List<AbstractUnoCard> redCards = new ArrayList<>();

        // NUMERIC CARDS
        for(UnoCardValue value : UnoCardValue.values()) {
            redCards.add(new UnoCard(value, UnoCardColor.RED, null));
        }

        // ACTION CARDS
        for(UnoCardAction action : UnoCardAction.values()) {
            if(!action.isWildAction() && !action.isWildDrawFourAction()){
                redCards.add(new UnoCard(null, UnoCardColor.RED, action));
            }
        } return redCards;
    }

    @Override
    public List<AbstractUnoCard> getBlueCards() {
        List<AbstractUnoCard> blueCards = new ArrayList<>();

        // NUMERIC CARDS
        for(UnoCardValue value : UnoCardValue.values()) {
            blueCards.add(new UnoCard(value, UnoCardColor.BLUE, null));
        }

        // ACTION CARDS
        for(UnoCardAction action : UnoCardAction.values()) {
            if(!action.isWildAction() && !action.isWildDrawFourAction()){
                blueCards.add(new UnoCard(null, UnoCardColor.BLUE, action));
            }
        } return blueCards;
    }

    @Override
    public List<AbstractUnoCard> getGreenCards() {
        List<AbstractUnoCard> greenCards = new ArrayList<>();

        // NUMERIC CARDS
        for(UnoCardValue value : UnoCardValue.values()) {
            greenCards.add(new UnoCard(value, UnoCardColor.GREEN, null));
        }

        // ACTION CARDS
        for(UnoCardAction action : UnoCardAction.values()) {
            if(!action.isWildAction() && !action.isWildDrawFourAction()){
                greenCards.add(new UnoCard(null, UnoCardColor.GREEN, action));
            }
        } return greenCards;
    }

    @Override
    public List<AbstractUnoCard> getYellowCards() {
        List<AbstractUnoCard> yellowCards = new ArrayList<>();
        for(UnoCardValue value : UnoCardValue.values()){
            yellowCards.add(new UnoCard(value, UnoCardColor.YELLOW, null));
        }
        for(UnoCardAction action : UnoCardAction.values()) {
            if(!action.isWildAction() && !action.isWildDrawFourAction()){
                yellowCards.add(new UnoCard(null, UnoCardColor.YELLOW, action));
            }
        } return yellowCards;
    }

    @Override
    public List<AbstractUnoCard> getJollyCards() {
        List<AbstractUnoCard> jollyCards = new ArrayList<>();
        jollyCards.add(new UnoCard(null, null, UnoCardAction.WILD_DRAW_FOUR)) ;
        jollyCards.add(new UnoCard(null, null, UnoCardAction.WILD)) ;
        return jollyCards;
    }
}
