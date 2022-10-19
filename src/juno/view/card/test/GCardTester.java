package juno.view.card.test;
import javax.imageio.ImageIO;
import javax.swing.*;

import juno.model.util.PathGenerator;

import java.awt.*;
import java.awt.image.BufferedImage;
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
	
		String[] pathNames = {"data", "image", "card", "red", "png"};
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

		JLabel picLabel = new JLabel(new ImageIcon(red1CardPath));

		// Frame options
		frame.add(picLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(true);
		frame.pack();
		frame.setVisible(true);
	}

}
