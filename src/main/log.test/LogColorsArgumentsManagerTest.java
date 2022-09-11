package main.log.tests;

import java.io.IOException;

import main.config.MyJsonTest;
import main.log.main.Log;
import main.log.main.LogArgumentsManager;
import main.log.color.LogColorsArgumentsManager;
import main.log.messages.LogMessage;

public class LogColorsArgumentsManagerTest {

	public static void main(String... args) throws IOException {
		
		
		/**
		 * TEST DEBUG COLOR MANGER CMD
		 */
		LogArgumentsManager.active(args);
		LogColorsArgumentsManager.active(args);
		
		Log.print(LogMessage.SCONF_PROC, "DEBUG COLOR MANAGER TEST");
		
		LogColorsArgumentsManager.active(args);
		
		/**
		 * Programma di prova per la verifica
		 * delle stampe
		 */
		MyJsonTest.main(args);
		
	}
}
