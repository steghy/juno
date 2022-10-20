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
	 * Returns the Map of the cards - Jbutton
	 * @return A Map
	 */
	public Map<Card, JButton> getCards(){
		return this.cards;
	}
	
	
	/**
	 * Returns the JButton associated with the
	 * specified Card object
	 * @param card A Card object
	 * @return A JButton object
	 */
	public JButton getGraphicCard(Card card) {
		Object[] result = cards.keySet().stream()
			.filter(k -> k.equals(card)).toArray();
		if(result.length == 0) {
			throw new IllegalArgumentException(""
					+ "Error: Cannot find the specified card");
		} else {
			return cards.get(result[0]);
		}
	}

	
	/* Initialize the GCard instance */
	public void init() {
		this.cards = new HashMap<>();
		
		// Cards paths
		Paths[] cardsDirectories = {Paths.RCARDS, Paths.BCARDS,
				Paths.YCARDS, Paths.GCARDS, Paths.JCARDS};

		for(Paths pathObject : cardsDirectories) {
			String path = pathObject.getPath();
			File cardDir = new File(path); 
			String dirName = cardDir.getName();
			Color color = Color.getColorObject(dirName);

			for(String fileName : cardDir.list()) {
				String absoluteName = fileName.split("[.]")[0];
				// Card specification
				int value = -1;
				Action action = Action.getActionObject(absoluteName);

				// Numeric cards starts with a number
				char firstChar = absoluteName.charAt(0);
				if(Character.isDigit(firstChar)) {
					value = firstChar - '0';
				}

				String cardPath = PathGenerator.generate(path, fileName);
				Card card = new Card(value, color, action);
				JButton button = generateJButton(cardPath);
				cards.put(card, button);
			}
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