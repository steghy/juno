package juno.view.card.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import juno.model.card.Action;
import juno.model.card.Card;
import juno.model.card.Color;
import juno.view.card.CardProvider;

/**
 * Classe di test per la classe GCard
 * @author steghy
 * @email steghy.github@proton.me
 */
public class CardProviderTester {
	
	static int count;
	
	/**
	 * Metodo main per il test della classe GCard
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		cardImageTest();
	}	
		
	public static void cardImageTest() {
		
		JFrame frame = new JFrame();
		
		CardProvider cardProvider = CardProvider.getInstance();
		Card card1 = new Card(-1, null, Action.WILD_DRAW_FOUR);
		Card card2 = new Card(9, Color.RED, null);
		Icon icon1 = cardProvider.getGraphicCard(card1);
		Icon icon2 = cardProvider.getGraphicCard(card2);
		JButton cardComponent = new JButton(icon1);
		cardComponent.setSelectedIcon(icon2);
		// JLabel cardComponent = new JLabel(icon);

		class ActionButton implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if(source instanceof JButton) {
					JButton button = (JButton) source;
					if(button.isSelected()) {
						button.setSelected(false);
					} else {
						button.setSelected(true);
					}
				} else if(source instanceof JLabel) {
					JLabel label = (JLabel) source;
				}
			}
		}
		
		// cardComponent.addActionListener(new ActionButton());

		// Frame options
		frame.add(cardComponent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(true);
		frame.pack();
		frame.setVisible(true);
	}

}