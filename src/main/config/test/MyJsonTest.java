package main.config.test;

import java.io.IOException;
import main.config.Exporter;
import main.log.color.LogColorsArgumentsManager;
import main.log.file.LogWriterArgumentsManager;
import main.log.main.LogArgumentsManager;
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
	
	// create JSON
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
	
	// read JSON
	private static void readJsonTest() throws IOException {
	}
		
	
		
	

}
