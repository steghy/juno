package juno.main.init;

import java.util.HashMap;
import java.util.Map;

/** 
 * Checker class 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Checker {
	
	/* The instance of this class */
	private static Checker instance;
	
	/* Singleton pattern */
	private Checker() {}
	
	/**
	 * Returns the instance of this class
	 * @return The instance of this class
	 */
	static Checker getInstance() {
		if(instance == null) {
			instance = new Checker();
		} return instance;
	}
	
	/**
	 * Checks the paths 
	 * @return A boolean
	 */
	Map<String, String> check() {
		return new HashMap<String, String>();
	}

}
