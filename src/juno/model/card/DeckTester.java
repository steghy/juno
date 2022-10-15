package juno.model.card;

import java.util.Stack;

public class DeckTester {

	public static void main(String[] args) {
		Deck instance = Deck.getInstance();
		instance.generateDeck(4);
		// instance.shuffle();
		Stack<Card> deck = instance.getDeck();
		System.out.println("NUMBER OF CARDS: " + deck.size());
		
		int numericCards = 0;
		int jollyCards = 0;
		int actionCards = 0;
		
		int redCards = 0;
		int blueCards = 0;
		int greenCards = 0;
		int yellowCards = 0;
		
		int count = 1;
		
		while(!deck.isEmpty()) {

			Card card = deck.pop();
			Color color = card.getColor();
			Action action = card.getAction();
			if(card.getValue() != -1) {
				numericCards++;
			}

			if(color == Color.RED) {
				redCards++;
			} else if(color == Color.BLUE) {
				blueCards++;
			} else if(color == Color.GREEN) {
				greenCards++;
			} else if(color == Color.YELLOW) {
				yellowCards++;
			} else if(color == null) {
				jollyCards++;
			}
			
			if(color != null && 
			   card.getValue() == -1 &&
			   action != Action.WILD_CARD_FOUR &&
			   action != Action.WILD) {
				actionCards++;
			}
			System.out.println(count + ")" +  card);
			count ++;
		}
		
		System.out.println("_____________________");
		System.out.println("NUMERIC CARDS: " + numericCards);
		System.out.println("JOLLY CARDS: " + jollyCards);
		System.out.println("ACTION CARDS: " + actionCards); 
		System.out.println("RED CARDS: " + redCards);
		System.out.println("BLUE CARDS: " + blueCards);
		System.out.println("GREEN CARDS: " + greenCards);
		System.out.println("YELLOW CARDS: " + yellowCards);
	}
	
}
