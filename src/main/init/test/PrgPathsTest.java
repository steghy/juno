package main.init.test;

import main.init.PrgPaths;
import main.log.Log;
import main.log.LogActivator;
import main.log.LogColorActivator;
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
		LogActivator.active(args);
		LogColorActivator.active(args);
		Log.print(LogMessage.ICONF_DATA, PrgPaths.getPaths());
	}
}

