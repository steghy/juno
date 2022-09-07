package main.model;

import java.util.HashMap;
import java.util.Map;
import main.config.Configurable;
import main.config.DataPackage;
import main.config.Exportable;
import main.log.main.Log;
import main.log.messages.LogMessage;

/**
 * Definisce l'account di un utente dell'applicazione
 * @author steghy
 *
 */
public class User implements Configurable, Exportable {
	
	/** le key da usare per configurare la classe con le map*/
	public static final String DATA_NAME = "user-data";
	public static final String USER_NAME = "user-name";
	public static final String NAME = "name";
	public static final String LAST_NAME = "last-name";
	public static final String EMAIL = "email";
	public static final String CELLPHONE = "cellphone";
	public static final String COUNTRY = "country";
	public static final String PASSWD = "passwd";
	public static final String AGE = "age";
	
	/** dettagli dell'utente*/
	private String userName;
	private String name;
	private String lastName;
	private Email email;
	private long cellphone;
	private String country;
	private Passwd passwd;
	private int age;
		
	/**
	 * Costruisce uno user a partire dallo user name
	 * @param userName Lo username
	 */
	public User() {
		
	}
	
	/**
	 * Imposta la email dell'utente
	 * @param email la email
	 */
	public void setEmail(Email email) {
		//controllo validità email da effettuare
		this.email = email;
	}
	
	/**
	 * Imposta la passwd dell'utente
	 * @param passwd La passwd
	 */
	public void setPasswd(Passwd passwd) {
		this.passwd = passwd;
	}
	
	/**
	 * Imposta l'età dell'utente
	 * @param age L'età
	 */
	public void setAge(int age) {
		if(age <= 0) {
			throw new IllegalArgumentException("User invalid age");
		}
		this.age = age;
	}
	
	/**
	 * Imposta il paese dell'utente
	 * @param country Il paese
	 */
	public void setCountry(String country) {
		//ancora nessuna verifica sulla correttezza del dato
		this.country = country;
	}
	
	/**
	 * Imposta il cellulare dell'utente
	 * @param cellphone Il cellulare
	 */
	public void setCellphone(long cellphone) {
		Long temp = cellphone;
		long length = temp.toString().length();
		
		//momentanea unica accettazione
		if(length != 10) {
			throw new IllegalArgumentException("illegan cellphone number");
		}
		this.cellphone = cellphone;
	}
	
	/**
	 * Imposta il cognome dell'utente
	 * @param lastName Il cognome
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Imposta il nome dell'utente
	 * @param name Il nome
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Imposta lo username dell'utente
	 * @param userName Lo username
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Restituisce lo username
	 * @return Lo username
	 */
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * Restituisce il nome dell'utente
	 * @return il nome
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * restituisce il cognome dell'utente
	 * @return il cognome
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * ritorna il cellulare dell'utente
	 * @return il cellulare
	 */
	public long getCellphone() {
		return this.cellphone;
	}
	
	/**
	 * ritorna la email dell'utente
	 * @return la email
	 */
	public Email getEmail() {
		return this.email;
	}
	
	
	/**
	 * ritorna il paese dell'utente
	 * @return il paese
	 */
	public String getCountry() {
		return this.country;
	}
	
	/**
	 * ritorna l'età dell'utente
	 * @return l'età
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * ritorna la passwd dell'utente
	 * @return la passwd
	 */
	public Passwd getPasswd() {
		return this.passwd;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void configure(DataPackage source) {
		
		Log.print(LogMessage.SCONF_PROC, DATA_NAME);
		Log.print(LogMessage.SCONF_SUBPROC, "");
		
		if(!(source.getName().equals(User.DATA_NAME))) {
			throw new IllegalArgumentException("Wrong data."
					+",no "+DATA_NAME+" key found");
		}
		
		Map<String, Object> data = (HashMap) source.getData();
		
		if(data.isEmpty()) {
			Log.print(LogMessage.C_NO_DATA_FOUND, "");
		}
		
		else {
			
			//user name
			if(data.containsKey(User.USER_NAME)) {
				String temp = (String) data.get(User.USER_NAME);
				this.userName = temp;
			}
			
			//name
			if(data.containsKey(User.NAME)){
				String temp = (String) data.get(User.NAME);
				this.name = temp;
			}
			
			//last name
			if(data.containsKey(User.LAST_NAME)) {
				String temp = (String) data.get(User.LAST_NAME);
				this.lastName = temp;
			}
			
			//country
			if(data.containsKey(User.COUNTRY)) {
				String temp = (String) data.get(User.COUNTRY);
				this.country = temp;
			}
			
			//cellphone
			if(data.containsKey(User.CELLPHONE)) {
				Object obj = data.get(User.CELLPHONE);
				long temp = 0;
				
				//se il numero è stato inserito
				if(obj instanceof Long) {
					temp = (long)obj;
				}
				
				//se il numero non è stato inserito
				if(obj instanceof Integer) {
					temp = Integer.toUnsignedLong((Integer)obj);
				}
				
				this.cellphone = temp;
			}
			
			//age
			if(data.containsKey(User.AGE)) {
				int temp = (Integer) data.get(User.AGE);
				this.age = temp;
			}
			
			//email
			if(data.containsKey(User.EMAIL)) {
				Map<String, Object> temp = (HashMap) data.get(User.EMAIL);
				Email email = new Email((String)temp.get(Email.EMAIL));
				this.email = email;
			}
			
			//passwd
			if(data.containsKey(User.PASSWD)) {
				Map<String, Object> temp = (HashMap) data.get(User.PASSWD);
				Passwd passwd = new Passwd((String)temp.get(Passwd.PASSWD));
				this.passwd = passwd;
			}
		}
		
		Log.print(LogMessage.ICONF_DATA, data);
		Log.print(LogMessage.ECONF_SUBPROC, "");
		Log.print(LogMessage.ECONF_PROC, DATA_NAME);
	}
	
	@Override
	public DataPackage provideData() {
			
		Log.print(LogMessage.SSUPPLY_PROC, DATA_NAME);
		Log.print(LogMessage.SSUPPLY_SUBPROC, "");
	
		Map<String, Object> data = new HashMap<>();
		
		if(this.userName != null) {
			data.put(User.USER_NAME, this.userName);
		}
		
		if(this.name != null) {
			data.put(User.NAME, this.name);
		}
		
		if(this.lastName != null) {
			data.put(User.LAST_NAME, this.lastName);
		}
		
		if(this.country != null) {
			data.put(User.COUNTRY, this.country);
		}
		
		if(this.cellphone != 0) {
			data.put(User.CELLPHONE, this.cellphone);
		}
		
		if(this.email != null) {
			data.put(User.EMAIL,this.email);
		}
			
		if(this.age != 0) {
			data.put(User.AGE, this.age);
		}
		
		if(this.passwd != null) {
			data.put(User.PASSWD, this.passwd);
		}
		
		
		Log.print(LogMessage.ICONF_DATA, data);
		Log.print(LogMessage.ESUPPLY_SUBPROC, "");
		Log.print(LogMessage.ESUPPLY_PROC, DATA_NAME);
		
		return new DataPackage(User.DATA_NAME, data);
	}
	

}
