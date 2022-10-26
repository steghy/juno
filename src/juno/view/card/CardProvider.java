package juno.view.card;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import juno.init.Paths;
import juno.model.card.Action;
import juno.model.card.UnoCard;
import juno.model.card.Color;
import juno.model.card.AbstractUnoCard;
import juno.model.util.PathGenerator;

/**
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class CardProvider {
	
	/* Card name = Pathh */
	private Map<AbstractUnoCard, Icon> cards;
	
	/* The instance */
	private static CardProvider instance;

	/* Singleton Pattern */
	private CardProvider() {
		init();
	}

	
	/**
	 * Returns the instance
	 * @return The instance
	 * @throws FileAlreadyExistsException 
	 * @throws FileNotFoundException 
	 */
	public static CardProvider getInstance() {
		if(instance == null) {
			instance = new CardProvider();
		} return instance;
	}
	
	
	/**
	 * Returns the Map of the cards - Jbutton
	 * @return A Map
	 */
	public Map<AbstractUnoCard, Icon> getCards(){
		return this.cards;
	}
	
	
	/**
	 * Returns the JButton associated with the
	 * specified Card object
	 * @param card A Card object
	 * @return An Icon object
	 */
	public Icon getGraphicCard(AbstractUnoCard card) {
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
	private void init() {

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
				UnoCard card = new UnoCard(value, color, action);
				ImageIcon image = new ImageIcon(cardPath);
				image.setImage(image.getImage().getScaledInstance(200, 400, 1));
				cards.put(card, image);
			}
		}
	}
}