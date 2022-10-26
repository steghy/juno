package juno.view.card.test;

import java.io.IOException;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import juno.model.card.Action;
import juno.model.card.Card;
import juno.view.card.CardProvider;

/**
 * CardProvider Tester
 * @author steghy
 * @email steghy.github@proton.me
 */
public class CardProviderTester {
	
	static int count;

	/**
	 * Main method
	 * @param args The arguments
	 * @throws IOException description here
	 */
	public static void main(String[] args) throws IOException {
		cardImageTest();
	}	
		
	/** CardImageTest */
	public static void cardImageTest() {
		
		// CARD PROVIDER
		CardProvider cardProvider = CardProvider.getInstance();

		Card card1 = new Card(-1, null, Action.WILD_DRAW_FOUR);

		Icon icon1 = cardProvider.getGraphicCard(card1);

		JButton cardComponent = new JButton(icon1);

		// Frame options
		JFrame frame = new JFrame();
		frame.add(cardComponent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(true);
		frame.pack();
		frame.setVisible(true);
	}

}