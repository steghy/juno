package juno.model.card.test;

import juno.exception.DeckIsEmptyException;
import juno.model.card.Action;
import juno.model.card.Card;
import juno.model.card.Color;
import juno.model.deck.Deck;

public class DeckTester {

	public static void main(String[] args) {

		// Il mazzo viene generato e successivamente viene
		// mischiato. 
		Deck deckInstance = Deck.getInstance();
		deckInstance.generateDeck(4).shuffle();
		
		
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
				/* Pescata della carta
				 * Questo metodo lancia
				 * una eccezione nel caso 
				 * in cui il mazzo sia vuoto
				 * al momento della pescata
				 * (DeckIsEmptyException)
				 */
				Card card = deckInstance.draw();

				/* Card specifications */
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
				e.printStackTrace();
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
