package juno.model.deck.test;

import juno.model.card.Action;
import juno.model.card.Card;
import juno.model.card.Color;
import juno.model.deck.Deck;
import juno.model.deck.exceptions.DeckIsEmptyException;

public class DeckTester {

	public static void main(String[] args) {

		Deck deckInstance = Deck.getInstance();
		deckInstance.generateDeck(2).shuffle();
		
		/* Counters */
		int totalNumericCards = 0;
		int totalJollyCards = 0;
		int totalActionCards = 0;
		int redCards = 0;
		int blueCards = 0;
		int greenCards = 0;
		int yellowCards = 0;
		
		/* Index card to print */
		int count = 1;
		
		while(true) {
			
			try {
				Card card = deckInstance.draw();
				
				/* Cards specification */
				Color color = card.getColor();
				Action action = card.getAction();

				if(action == null) {
					totalNumericCards++;
				} else {
					if(action.isJolly()) {
						totalJollyCards++;
					} totalActionCards++;
				}
				
				if(color == Color.RED) {
					redCards++;
				} else if(color == Color.BLUE) {
					blueCards++;
				} else if(color == Color.GREEN) {
					greenCards++;
				} else if(color == Color.YELLOW) {
					yellowCards++;
				} 
				
				System.out.println(count + ")" +  card);
				count ++;
			} catch (DeckIsEmptyException e) {
				break;
			}

		}
		
		System.out.println("_____________________");
		System.out.println("NUMERIC CARDS: " + totalNumericCards);
		System.out.println("JOLLY CARDS: " + totalJollyCards);
		System.out.println("ACTION CARDS: " + totalActionCards); 
		System.out.println("RED CARDS: " + redCards);
		System.out.println("BLUE CARDS: " + blueCards);
		System.out.println("GREEN CARDS: " + greenCards);
		System.out.println("YELLOW CARDS: " + yellowCards);
	}
	
}
