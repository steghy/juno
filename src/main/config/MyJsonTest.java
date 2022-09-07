package main.config;


import java.io.IOException;

import main.log.main.LogArgumentsManager;
import main.log.color.LogColorsArgumentsManager;
import main.log.file.LogWriterArgumentsManager;
import main.model.Email;
import main.model.Passwd;
import main.model.User;
import main.model.UserConfigurator;
import main.util.PathGenerator;

/**
 * Classe di test per la classe MyJSON. In aggiunta tale classe mi permette
 * di testare il componente "Log", ovvero una package che ho creato per la 
 * realizzazione di un registro che contiene gli eventi scelti avvenuti nel 
 * programma.
 * @author steghy
 *
 */
public class MyJsonTest {
	
	
	public static String path = PathGenerator.generate("user-data.json");		

	/**
	 * Classe main
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
	
	/**
	 * Test per la scrittura di file json con la classe MyJson
	 * @throws IOException 
	 */
	private static void createJsonTest() throws IOException {
		
		//configurazione User
		User user = new User();
		user.setUserName("steghy");
		user.setAge(24);
		user.setCellphone(3802679518L);
		user.setEmail(new Email("gentilis98@gmail.com"));
		user.setName("Simone");
		user.setLastName("Gentili");
		user.setPasswd(new Passwd("enter"));
		user.setCountry("Italy");	
		
		//scrittura file json
		UserConfigurator.export(user, "user-data.json");
	}
	
	/**
	 * Test per la lettura di file json con la classe MyJson
	 * @throws IOException se accade qualcosa di brutto
	 */
	private static void readJsonTest() throws IOException {
		
		User user = new User();
		UserConfigurator.configure(user, "user-data.json");
		
		user.getAge();
	}
		
	
		
	

}
