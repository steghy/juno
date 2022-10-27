package juno.model.deck;

import juno.model.card.AbstractUnoCard;
import java.util.Stack;

/**
 * @author steghy
 */
public class UnoDiscardedCards extends Stack<AbstractUnoCard> implements AbstractUnoDiscardedCards<AbstractUnoCard> {


    /* The AbstractUnoCardController object */
    private AbstractUnoCardController controller;

    /* The DiscardedCards instance */
    private static UnoDiscardedCards instance;


    /* Builds the DiscardedCards instance */
    private UnoDiscardedCards(){}

    /**
     * Returns the DiscardedCards instance
     * @return The DiscardedCards instance
     */
    public static UnoDiscardedCards getInstance(){
        if(instance == null){
            instance = new UnoDiscardedCards();
        } return instance;
    }


    /**
     * Sets the AbstactUnoCardController of this instance
     * @param controller An AbstactUnoCardController object
     */
    public void setUnoCardController(AbstractUnoCardController controller){
        this.controller = controller;
    }

    @Override
    public void put(AbstractUnoCard card){
        if(this.isEmpty()) {
            this.push(card);
        } else if(controller.areCompatible(this.peek(), card)){
            this.push(card);
        } else {
            throw new IllegalArgumentException("Incompatible " +
                    "cards: " + this.peek() + ", " + card);
        }
    }
}