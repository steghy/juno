package main.log.tests;

import java.io.IOException;

import main.config.DataProvider;
import main.config.Loader;
import main.log.main.LogActivationManager;
import main.log.main.LogArgumentsManager;
import main.log.color.LogColorsArgumentsManager;
import main.util.PathGenerator;

public class LogActivationManagerTest {
	
	public static void main(String[] args) throws IOException {
		
		LogArgumentsManager.active(args);
		LogColorsArgumentsManager.active(args);
		
		String dir = "/.logs";
		//String logs_activation_expo = "/logs-activation.json";
		//String logs_activation_load_all_true = "/logs-activation-all-true.json";
		String logs_activation_load_all_false = "/logs-activation-all-false.json";
		
		//String path_expo = PathGenerator.generate(dir + logs_activation_expo);
		//String path_load_all_true = PathGenerator.generate(dir + logs_activation_load_all_true);
		String path_load_all_false = PathGenerator.generate(dir + logs_activation_load_all_false);
		
		//Export
		//Exporter.write(path_expo, LogActivationManager.getInstance());
		
		//Import
		Loader.load(DataProvider.load(path_load_all_false), LogActivationManager.getInstance());
	}

}
