package main.model;

import java.io.File;
import java.io.IOException;

import main.config.DataProvider;
import main.config.Exporter;
import main.config.Loader;
import main.util.PathGenerator;

/**
 * This class defines the users directory manager for the 
 * User class.
 * @author steghy
 *
 */
public class UserDataManager {

	// users directory name
	public static final String USER_DIR_NAME = ".users"; 
	
	// default (static) users directory location
	public static final String DEF_USER_PATH = 
			PathGenerator.generate(USER_DIR_NAME);
	
	// dynamic users directory location
	private String userPath = DEF_USER_PATH;

	// instance 
	private static UserDataManager instance;
	

	/**
	 * Singleton pattern
	 */
	private UserDataManager() {
		
	}
	

	/**
	 * Returns the only instance of this class
	 * @return A UserDataManager
	 */
	public static UserDataManager getInstance() {
		if(instance == null) {
			instance = new UserDataManager();
		}
		return instance;
	}

	
	public void configure(User user, String fileName) throws IOException {
		String filePath = PathGenerator.generate(userPath, fileName);
		Loader.load(DataProvider.load(filePath), user);
	}

	
	public void export(User user, String fileName) throws IOException {
		String filePath = PathGenerator.generate(userPath, fileName);
		Exporter.exportJson(filePath, user);
	}

	
	public void setUserPath(String path) {
		File file = new File(path);
		if(file.isDirectory()) {
			userPath = path;
		}
		else {
			throw new IllegalArgumentException("The specified path"
					+ "needs to be a directory");
		}
	}

}
