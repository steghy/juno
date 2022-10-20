package juno.view.card.test;

import javax.swing.*;

import juno.model.card.Card;
import juno.model.card.Color;
import juno.model.card.Action;
import juno.model.util.PathGenerator;
import juno.view.card.GCard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Classe di test per la classe GCard
 * @author steghy
 * @email steghy.github@proton.me
 */
public class GCardTester {
	
	static int count;
	
	/**
	 * Metodo main per il test della classe GCard
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// Test here

		GCard.getInstance().init();
		GCard.getInstance().getCards().entrySet().stream()
			.forEach(entry -> {
				System.out.println(entry.getKey() + " | " + entry.getValue());
				count++;
			});
		System.out.println("Number of cards: " + count);
		// Graphic card image test
		cardImageTest();
		
		// Init JButtons cards

	}	
		
	public static void cardImageTest() {
		
		String[] pathNames = {"data", "images", "cards", "red"};
		String cardsPath = PathGenerator.generate(pathNames);
		File cardsDirectory = new File(cardsPath);

		if(cardsDirectory.exists()) {
			System.out.println("Cards directory exists");
		} else {
			System.out.println("Cards directory not exists");
		}

		JFrame frame = new JFrame();
		
		String red1CardPath = PathGenerator.generate(cardsPath, "red-1.png");
		File red1CardFile = new File(red1CardPath);

		if(red1CardFile.exists()) {
			System.out.println("Red-1 card exists");
		} else {
			System.out.println("Red-1 card not exists");
		}

		class ActionSpy implements ActionListener {
			
			public static final String CARD = "CARD ACTION";

			@Override
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if(e.getActionCommand().equals(CARD)) {
					JButton card = (JButton) source;
					System.out.println("A card was pressed, card : " + card.getName());
				}
			}
			
		}

		GCard cardProvider = GCard.getInstance();
		cardProvider.init();
		Card card = new Card(-1, null, Action.WILD_DRAW_FOUR);
		JButton button = cardProvider.getGraphicCard(card);

		JButton picLabel = new JButton(new ImageIcon(red1CardPath, "RedCard1"));
		picLabel.addActionListener(new ActionSpy());
		picLabel.setActionCommand(ActionSpy.CARD);
		picLabel.setName("RED CARD1");
		
		ImageIcon image = (ImageIcon) picLabel.getIcon();
		String description =  image.getDescription();
		System.out.println("Card description: " + description);
	

		// Frame options
		frame.add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(true);
		frame.pack();
		frame.setVisible(true);
	}

}