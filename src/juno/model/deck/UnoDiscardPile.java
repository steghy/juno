package juno.model.deck;

import juno.model.card.AbstractUnoCard;
import java.util.Stack;

/**
 * @author steghy
 */
public class UnoDiscardPile extends Stack<AbstractUnoCard> implements AbstractDiscardPile<AbstractUnoCard> {


    /* The AbstractUnoCardController object */
    private AbstractCompatibilityChecker<AbstractUnoCard> compatibilityChecker;

    /* The DiscardedCards instance */
    private static UnoDiscardPile instance;


    /* Builds the DiscardedCards instance */
    private UnoDiscardPile(){}

    /**
     * Returns the DiscardedCards instance
     * @return The DiscardedCards instance
     */
    public static UnoDiscardPile getInstance(){
        if(instance == null){
            instance = new UnoDiscardPile();
        } return instance;
    }


    /**
     * Sets the AbstractCompatibilityChecker object of this instance.
     * @param compatibilityChecker An AbstractCompatibilityChecker
     */
    public void setCompatibilityChecker(AbstractCompatibilityChecker<AbstractUnoCard> compatibilityChecker) {
        this.compatibilityChecker = compatibilityChecker;
    }

    @Override
    public void discard(AbstractUnoCard card){
        if(this.isEmpty()) {
            this.push(card);
        } else if(compatibilityChecker.areCompatible(this.peek(), card)){
            this.push(card);
        } else {
            throw new IllegalArgumentException("Incompatible " +
                    "cards: " + this.peek() + ", " + card);
        }
    }
}