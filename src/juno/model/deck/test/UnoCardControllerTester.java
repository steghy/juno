package juno.model.deck.test;

import juno.model.card.*;
import juno.model.deck.*;

public class UnoCardControllerTester {

    public static void main(String[] args){

        // UNO DECK
        UnoDeck unoDeck = UnoDeck.getInstance();

        // UNO DISCARDED CARDS
        UnoDiscardPile unoDiscardPile = UnoDiscardPile.getInstance();

        // UNO DECK GENERATOR
        UnoDeckFactory generator = UnoDeckFactory.getInstance();

        // UNO DECK SETTINGS
        unoDeck.setDiscardedPile(unoDiscardPile);
        unoDeck.setRefiller(new UnoDeckRefiller<>());
        unoDeck.setMixer(new Mixer<>());

        // UNO DISCARDED CARDS SETTINGS
        unoDiscardPile.setCompatibilityChecker(UnoCardCompatibilityChecker.getInstance());

        // UNO DECK GENERATOR SETTINGS
        generator.setFactory(UnoCardFactory.getInstance());

        // GENERATING CARDS & SHUFFLE
        unoDeck.addAll(generator.getDeck());

        boolean colorTest = false;
        boolean numberTest = false;
        boolean jollyTest = true;

        if(colorTest) {
            // NUMERIC CARD : 1 - RED - null
            AbstractUnoCard cardToPut = new UnoCard(null, UnoCardColor.RED, UnoCardAction.SKIP);

            // NUMERIC CARD : 1 - BLUE - null
            AbstractUnoCard cardInTop = new UnoCard(UnoCardValue.ZERO, UnoCardColor.RED, null);

            // TESTING COLOR COMPATIBLE
            unoDiscardPile.discard(cardInTop);
            System.out.println("Top card on 'DiscardedCardsDeck':" + unoDiscardPile.peek());

            System.out.println("Card to put: " + cardToPut);
            unoDiscardPile.discard(cardToPut);
        }


        if(numberTest) {
            // NUMERIC CARD : 1 - RED - null
            AbstractUnoCard cardToPut = new UnoCard(UnoCardValue.NINE, UnoCardColor.RED, null);

            // NUMERIC CARD : 1 - BLUE - null
            AbstractUnoCard cardInTop = new UnoCard(UnoCardValue.NINE, UnoCardColor.BLUE, null);

            // TESTING COLOR COMPATIBLE
            unoDiscardPile.discard(cardInTop);
            System.out.println("Top card on 'DiscardedCardsDeck':" + unoDiscardPile.peek());

            System.out.println("Card to put: " + cardToPut);
            unoDiscardPile.discard(cardToPut);
        }

        if(jollyTest) {
            // NUMERIC CARD : 1 - RED - null
            AbstractUnoCard cardToPut = new UnoCard(null, null, UnoCardAction.WILD_DRAW_FOUR);

            // NUMERIC CARD : 1 - BLUE - null
            AbstractUnoCard cardInTop = new UnoCard(UnoCardValue.ONE, UnoCardColor.BLUE, null);

            // TESTING COLOR COMPATIBLE
            unoDiscardPile.discard(cardInTop);
            System.out.println("Top card on 'DiscardedCardsDeck':" + unoDiscardPile.peek());

            System.out.println("Card to put: " + cardToPut);
            unoDiscardPile.discard(cardToPut);
        }
    }
}
