package main.init.test;

import main.init.PrgPaths;
import main.log.Log;
import main.log.LogArgumentsManager;
import main.log.LogColorsArgumentsManager;
import main.log.LogMessage;

/**
 * PrgPaths class test
 * @author steghy
 * @email steghy.github@proton.me
 */
public class PrgPathsTest {
		
	/**
	 * Main mathod 
	 * @param args The arguments
	 */
	public static void main(String[] args) {
		LogArgumentsManager.active(args);
		LogColorsArgumentsManager.active(args);
		Log.print(LogMessage.ICONF_DATA, PrgPaths.getPaths());
	}
}

