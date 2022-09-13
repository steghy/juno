package main.config.test;

import java.io.IOException;

import main.config.DataProvider;
import main.config.Exporter;
import main.config.Loader;
import main.log.LogArgumentsManager;
import main.log.LogColorsArgumentsManager;
import main.log.LogWriterArgumentsManager;
import main.model.Email;
import main.model.Passwd;
import main.model.User;
import main.util.PathGenerator;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class MyJsonTest {
	
	

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		LogArgumentsManager.active(args);
		LogColorsArgumentsManager.active(args);
		LogWriterArgumentsManager.active(args);
		createJsonTest();
		readJsonTest();
	}
	
	/* Creating and exporting JSON file with user information */
	private static void createJsonTest() throws IOException {
		
		String path = PathGenerator.generate("user-data.json");		
		
		// Setting the user informations
		User user = new User();
		user.setUsername("steghy");
		user.setAge(24);
		user.setTelephoneNumber(3802679518L);
		user.setEmail(new Email("gentilis98@gmail.com"));
		user.setName("Simone");
		user.setLastName("Gentili");
		user.setPasswd(new Passwd("enter"));
		user.setCountry("Italy");	
		
		// export the informations
		Exporter.exportJson(path, user);
	}
	
	
	/* Reading JSON file and configure a User instance with the informations */
	private static void readJsonTest() throws IOException {
		String path = PathGenerator.generate("user-data.json");		
		User user = new User();
		Loader.load(DataProvider.load(path), user);
		user.getAge();
	}
		
	
		
	

}
