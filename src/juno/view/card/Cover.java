package juno.view.card;

import java.io.File;

import javax.swing.ImageIcon;

import juno.model.util.PathGenerator;

/**
 * Cover class.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Cover {
	
	/** Graphic covers directories */
	private ImageIcon cover;
	
	/* The instance */
	private static Cover instance;
	
	/* Builds the cover object */
	private Cover() {
		init();
	}

	/**
	 * Returns the instance of this class
	 * @return The instance of this class
	 */
	public static Cover getInstance() {
		if(instance == null) {
			instance = new Cover();
		} return instance;
	}
	
	private void init() {
		String[] pathNames = {"data", "images", "card", "cover"};
		String path = PathGenerator.generate(pathNames);
		cover = new ImageIcon(path);
	}
}
