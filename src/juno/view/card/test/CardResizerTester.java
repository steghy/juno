package juno.view.card.test;

import javax.swing.ImageIcon;

import juno.view.card.CardResizer;

public class CardResizerTester {

	public static void main(String[] args) {
		String cardPath = "";
		ImageIcon image = new ImageIcon(cardPath);
		image.setImage(CardResizer.getScaledImage(image.getImage()));
	}
}
