package main.init.test;

import main.init.Init;
import main.log.LogActivator;

/**
 * Init class test
 * @author steghy
 * @email steghy.github@proton.me
 */
public class InitTest {

	/**
	 * Main method
	 * @param args The command-line arguments
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		LogActivator.active(args);
		Init.init();
	}

}
