package juno.view.card;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import juno.exception.FileAlreadyExistsException;
import juno.exception.FileNotFoundException;
import juno.main.init.Paths;
import juno.model.card.Action;
import juno.model.card.Card;
import juno.model.card.Color;
import juno.model.util.PathGenerator;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class GCard {
	
	/* Card name = Pathh */
	private Map<Card, JButton> cards;
	
	/* The instance */
	private static GCard instance;

	/* Singleton Pattern */
	private GCard() {}

	
	/**
	 * Returns the instance
	 * @return The instance
	 * @throws FileAlreadyExistsException 
	 * @throws FileNotFoundException 
	 */
	public static GCard getInstance() {
		if(instance == null) {
			instance = new GCard();
		} return instance;
	}
	
	
	/**
	 * Returns the JButton associated with the
	 * specified Card object
	 * @param card A Card object
	 * @return A JButton object
	 */
	public JButton getGraphicCard(Card card) {
		return this.cards.get(card);
	}

	
	/* Initialize the GCard instance */
	public void init() {
		Paths[] cardsDirectories = {Paths.RCARDS, Paths.BCARDS,
				Paths.YCARDS, Paths.GCARDS, Paths.JCARDS};
		List<Color> colors = Arrays.asList(Color.values());
		for(Paths pathObject : cardsDirectories) {
			String path = pathObject.getPath();
			File cardDir = new File(path); 
			String dirName = cardDir.getName();
			Color color = Color.getColorObject(dirName);
			for(String fileName : cardDir.list()) {
				String absoluteName = fileName.split(".")[0];
				int value = -1;
				Action action = Action.getActionObject(fileName);
				char firstChar = absoluteName.charAt(0);
				if(Character.isDigit(firstChar)) {
					value = firstChar - '0';
				}
				Card card = new Card(value, color, action);
				String cardPath = PathGenerator.generate(path, fileName);
				JButton button = new JButton(new ImageIcon(cardPath));
				cards.put(card, button);
			}
			
			colors.remove(0);
		}
	}

	
	/* Generates the JButton with the specified
	 * image path.
	 */
	private JButton generateJButton(String path) {
		Icon icon = new ImageIcon(path);
		JButton button = new JButton(icon);
		return button;
	}
}