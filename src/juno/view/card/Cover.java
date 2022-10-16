package juno.view.card;

import java.io.File;

import juno.model.util.PathGenerator;

/**
 * Cover class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Cover {
	
	/** Graphic covers directories */
	static final File COVER_DIR = new File(PathGenerator.generate("data/images/cards/cover"));
	
	/* The instance */
	private static Cover instance;
	
	/**
	 * Returns the instance of this class
	 * @return The instance of this class
	 */
	public static Cover getInstance() {
		if(instance == null) {
			instance = new Cover();
		} return instance;
	}
}
