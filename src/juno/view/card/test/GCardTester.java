package juno.view.card.test;

import javax.swing.*;

import juno.exception.FileAlreadyExistsException;
import juno.exception.FileNotFoundException;
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
	
	/**
	 * Metodo main per il test della classe GCard
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// Test here
		
		// Graphic card image test
		// cardImageTest();
		
		// Init JButtons cards
		GCard cardProvider = GCard.getInstance();
		cardProvider.init();
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

		JButton picLabel = new JButton(new ImageIcon(red1CardPath, "RedCard1"));
		picLabel.addActionListener(new ActionSpy());
		picLabel.setActionCommand(ActionSpy.CARD);
		picLabel.setName("RED CARD1");
		
		ImageIcon image = (ImageIcon) picLabel.getIcon();
		String description =  image.getDescription();
		System.out.println("Card description: " + description);
	

		// Frame options
		frame.add(picLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(true);
		frame.pack();
		frame.setVisible(true);
	}

}
