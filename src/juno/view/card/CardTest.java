package juno.view.card;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import juno.model.util.Os;
import juno.model.util.PathGenerator;

public class CardTest {

	public static void main(String[] args) {
		if(Os.exists(PathGenerator.generate("data/images/cards/jolly/WILD.svg"))) {
			System.out.println("Esiste");
		}
		
		
		Icon icon = new ImageIcon(PathGenerator.generate("data/images/cards/jolly/WILD.svg"));
		JButton graphicCard = new JButton(icon);
		Box box = Box.createVerticalBox();
		box.add(graphicCard);
		JFrame mainFrame = new JFrame();
		mainFrame.add(box);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(500, 500);
		mainFrame.setVisible(true);
	}
}
