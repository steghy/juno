package juno.model.deck.test;

import juno.model.card.*;
import juno.model.deck.*;

public class UnoCardControllerTester {

    public static void main(String[] args){

        // UNO DECK
        UnoDeck unoDeck = UnoDeck.getInstance();

        // UNO DISCARDED CARDS
        UnoDiscardedCards unoDiscardedCards = UnoDiscardedCards.getInstance();

        // UNO DECK SETTINGS
        unoDeck.setDiscardedCards(unoDiscardedCards);
        unoDeck.setManager(UnoDeckManager.getInstance());
        unoDeck.setMixer(new Mixer<>());

        // UNO DISCARDED CARDS SETTINGS
        unoDiscardedCards.setUnoCardController(UnoCardController.getInstance());

        // GENERATING CARDS & SHUFFLE
        UnoDeckGenerator.generate(unoDeck, UnoCardsFactory.getInstance());
        unoDeck.mixDeck();


        boolean colorTest = false;
        boolean numberTest = false;
        boolean jollyTest = true;

        if(colorTest) {
            // NUMERIC CARD : 1 - RED - null
            AbstractUnoCard cardToPut = new UnoCard(null, UnoCardColor.RED, UnoCardAction.SKIP);

            // NUMERIC CARD : 1 - BLUE - null
            AbstractUnoCard cardInTop = new UnoCard(UnoCardValue.ZERO, UnoCardColor.RED, null);

            // TESTING COLOR COMPATIBLE
            unoDiscardedCards.put(cardInTop);
            System.out.println("Top card on 'DiscardedCardsDeck':" + unoDiscardedCards.peek());

            System.out.println("Card to put: " + cardToPut);
            unoDiscardedCards.put(cardToPut);
        }


        if(numberTest) {
            // NUMERIC CARD : 1 - RED - null
            AbstractUnoCard cardToPut = new UnoCard(UnoCardValue.NINE, UnoCardColor.RED, null);

            // NUMERIC CARD : 1 - BLUE - null
            AbstractUnoCard cardInTop = new UnoCard(UnoCardValue.NINE, UnoCardColor.BLUE, null);

            // TESTING COLOR COMPATIBLE
            unoDiscardedCards.put(cardInTop);
            System.out.println("Top card on 'DiscardedCardsDeck':" + unoDiscardedCards.peek());

            System.out.println("Card to put: " + cardToPut);
            unoDiscardedCards.put(cardToPut);
        }

        if(jollyTest) {
            // NUMERIC CARD : 1 - RED - null
            AbstractUnoCard cardToPut = new UnoCard(null, null, UnoCardAction.WILD_DRAW_FOUR);

            // NUMERIC CARD : 1 - BLUE - null
            AbstractUnoCard cardInTop = new UnoCard(UnoCardValue.ONE, UnoCardColor.BLUE, null);

            // TESTING COLOR COMPATIBLE
            unoDiscardedCards.put(cardInTop);
            System.out.println("Top card on 'DiscardedCardsDeck':" + unoDiscardedCards.peek());

            System.out.println("Card to put: " + cardToPut);
            unoDiscardedCards.put(cardToPut);
        }
    }
}
