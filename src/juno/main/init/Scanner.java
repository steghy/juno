package juno.main.init;

/**
 * Scanner class
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Scanner {
	
	/* The instance of this class */
	private static Scanner instance;
	
	/* Singleton pattern */
	private Scanner() {}
	
	/**
	 * Returns the instance of this class
	 * @return The instance of this class
	 */
	static Scanner getInstance() {
		if(instance == null) {
			instance = new Scanner();
		} return instance;
	}
	
	/**
	 * Scans some paths to search
	 * the lib
	 * @return A boolean
	 */
	boolean scan() {
		return true;
	}

}
