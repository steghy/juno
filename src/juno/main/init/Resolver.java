package juno.main.init;

import java.util.Map;

/**
 * Resolv class
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Resolver {
	
	/* The instance of this class */
	private static Resolver instance;
	
	/* Singleton pattern */
	private Resolver() {}
	
	/**
	 * Returns the instance of this class
	 * @return The instance of this class
	 */
	static Resolver getInstance() {
		if(instance == null) {
			instance = new Resolver();
		} return instance;
	}
	
	/**
	 * Solves issues
	 * @return A boolean
	 */
	boolean solve(Map<String, String> data) {
		return true;
	}

}
