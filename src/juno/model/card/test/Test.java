package juno.model.card.test;
import javax.swing.*;

import juno.model.util.PathGenerator;

import java.awt.*;
public class Test {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();

		Icon icon = new ImageIcon(PathGenerator.generate("uno-cards-deck.svg"));

		Container container = frame.getContentPane();
		container.add(new JLabel(icon));

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int screenX = (int)dimension.getWidth();
		int screenY = (int) dimension.getHeight();
		int frameX = frame.getWidth();
		int frameY = frame.getHeight();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation((screenX - frameX) / 2, (screenY - frameY) / 2);
		frame.setVisible(true);
		frame.pack();
		frame.setVisible(true);
	}

}
