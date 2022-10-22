package juno.view.card.test;

import javax.swing.JFrame;
import javax.swing.JLabel;
import juno.view.card.CardCover;

public class CardCoverTester {
	public static void main(String[] args) {
		CardCover cover = CardCover.getInstance();
		// JButton coverComponent = new JButton(cover.getIcon());
		JLabel coverComponent = new JLabel(cover.getIcon());
		JFrame frame = new JFrame();
		frame.add(coverComponent);
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
