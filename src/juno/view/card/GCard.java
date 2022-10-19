package juno.view.card;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import juno.exception.FileAlreadyExistsException;
import juno.exception.FileNotFoundException;
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
	private Map<String, String[]> cards;
	
	/* The instance */
	private static GCard instance;

	/* Singleton Pattern */
	private GCard() throws FileNotFoundException, FileAlreadyExistsException {
		init();
	}

	
	/**
	 * Returns the instance
	 * @return The instance
	 * @throws FileAlreadyExistsException 
	 * @throws FileNotFoundException 
	 */
	public static GCard getInstance() throws FileNotFoundException, FileAlreadyExistsException {
		if(instance == null) {
			instance = new GCard();
		} return instance;
	}
	
	
	/**
	 * 
	 * @param card The card
	 * @return The path of the card
	 * @throws FileNotFoundException If there are a missing path
	 */
	public String getGraphicCardOf(Card card) throws FileNotFoundException {
		
		/* Card specifications */
		Action action = card.getAction();
		Color color = card.getColor();
		int value = card.getValue();
		
		/* File separator */
		String div = System.getProperty("file.separator");
		
		String[] paths;

		// Colored card case
		if(color != null) {
			paths = cards.get(color.name().toLowerCase());
		} else {
			paths = cards.get("jolly");
		} 
		for(String path : paths){
			String[] names = path.split(div);
			String name = names[names.length -1].split(".")[0];
			if(color == null && name.equals(action.name())) {
				return path;
			} else if(color != null 
					&& value == -1 
					&& action.name()
					.toLowerCase()
					.equals(name)) {
				return path;
			} else if (color != null 
					&& value != -1
					&& (value + "")
					.equals(name)) {
				return path;
			}
		} throw new FileNotFoundException("");
	}
	
	private void init() throws FileNotFoundException, FileAlreadyExistsException {
		String[] fileNames = {"data", "images", "cards"};
		File main = new File(PathGenerator.generate(fileNames));
		if(!main.exists()) {
			throw new FileNotFoundException(main.getPath());
		} else if(!main.isDirectory()) {
			throw new FileAlreadyExistsException(main.getPath());
		} 

		cards = new HashMap<>();

		List<String> names = List.of("red", "blue", "green", "yellow", "jolly");
		for(String name : main.list()) {
			if(names.contains(name)) {
				File path = new File(PathGenerator.generate(main.getPath(), name));
				for(String fileName : path.list()) {
				}
			} else {
				throw new FileNotFoundException(name + " not found");
			}
		} 
	}
	
	public static void main(String[] args) {
		try {
			GCard.getInstance();
		} catch (FileNotFoundException | FileAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}