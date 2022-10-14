package juno.model.user;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import juno.exception.DataException;
import juno.main.init.Configurable;
import juno.main.init.Data;
import juno.main.init.Exportable;

/**
 * Classe per la definizione dell'utente
 * all'interno del programma.
 * I campi ritenuti per progettazione indispensabili
 * per creare un oggetto User sono: 
 * - username
 * Un oggetto User è configurabile ed esportabile di
 * modo da salvare e ricaricare i dari dell'utente/i.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class User implements Configurable, Exportable {
	
	/* Username */
	private String username;
	
	/* Name */
	private String name;
	
	/* Lastname */
	private String lastName;
	
	/* Email address */
	private Email email;
	
	/* Telephone number */
	private long telephoneNumber;
	
	/* Country */
	private String country;
	
	/* Passwd */
	private Passwd passwd;
	
	/* Age */
	private int age;
	
	
	/**
	 * Builds a User without informations
	 */
	public User() {}
	
	
	/**
	 * Builds a User with the specified
	 * username
	 * @param username The username
	 */
	public User(String username) {
		this.username = username;
	}
	
	
	/**
	 * Builds a user with all the
	 * informations.
	 * @param username The username
	 * @param name The name
	 * @param lastName The last name
	 * @param email The email
	 * @param telephoneNumber The telephone number
	 * @param country The country
	 * @param passwd The passwd
	 * @param age The age
	 */
	public User(String username, String name,
			String lastName, Email email,
			long telephoneNumber, String country,
			Passwd passwd, int age) {
		this.username = username;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.telephoneNumber = telephoneNumber;
		this.country = country;
		this.passwd = passwd;
		this.age = age;
	}
	
	/**
	 * Sets the email 
	 * @param email The email
	 */
	public void setEmail(Email email) {
		this.email = email;
	}

	
	/**
	 * Sets the passwd
	 * @param passwd The passwd
	 */
	public void setPasswd(Passwd passwd) {
		this.passwd = passwd;
	}
	
	
	/**
	 * Sets the age
	 * @param age The age
	 */
	public void setAge(int age) {
		if(age <= 0) {
			throw new IllegalArgumentException(
					"Invalid user age");
		} this.age = age;
	}
	
	
	/**
	 * Sets the country 
	 * @param country The country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	/**
	 * Sets the telephone number
	 * @param telephoneNumber The telephone number
	 */
	public void setTelephoneNumber(long telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	
	/**
	 * Sets the lastname
	 * @param lastName The lastname
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	/**
	 * Sets the name
	 * @param name The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * Sets the username
	 * @param username The username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	
	/**
	 * Returns the username
	 * @return The username
	 */
	public String getUsername() {
		return this.username;
	}
	
	
	/**
	 * Returns the name
	 * @return The name
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * Returns the lastname
	 * @return The lastname
	 */
	public String getLastname() {
		return this.lastName;
	}

	
	/**
	 * Returns the telephone number
	 * @return The telephone number
	 */
	public long getTelephoneNumber() {
		return this.telephoneNumber;
	}

	
	/**
	 * Returns the email
	 * @return The email
	 */
	public Email getEmail() {
		return this.email;
	}
	
	
	/**
	 * Returns the country
	 * @return the country
	 */
	public String getCountry() {
		return this.country;
	}
	
	
	/**
	 * Returns the age
	 * @return The age
	 */
	public int getAge() {
		return this.age;
	}

	
	/**
	 * Returns the passwd
	 * @return The passwd
	 */
	public Passwd getPasswd() {
		return this.passwd;
	}

	
	@Override
	public void configure(Data data) throws DataException {
		
		Map<String, Object> userData = data.getData();
		
		/* Controllo consistenza dati */
		Arrays.asList(UserData.values()).stream()
		.forEach(k -> {
			if(!userData.containsKey(k) &&
					!k.equals(UserData.DATA_NAME)) {
				throw new DataException();
			}
		});
		
		/* Username */
		this.username = (String) userData.get(UserData.USER_NAME.name());

		/* Name */
		this.name = (String) userData.get(UserData.NAME.name());
		
		/* Lastname */
		this.lastName = (String) userData.get(UserData.LAST_NAME.name());
		
		/* Country */
		this.country = (String) userData.get(UserData.COUNTRY.name());
		
		/* Email */
		this.emailAddress = 

		/* Passwd */

		/* Telephone number */
		Object obj = userData.get(UserData.TELEPHONE_NUMBER.name());
		long temp = 0;
		if(obj instanceof Long) {
			temp = (long)obj;
		} else if(obj instanceof Integer) {
			temp = Integer.toUnsignedLong((Integer)obj);
		} this.telephoneNumber = temp;
	} 
	}
	
	@Override
	public Data provideData() {
		Map<String, Object> data = new HashMap<>();
		data.put(UserData.USER_NAME.name(), this.username);
		data.put(UserData.NAME.name(), this.name);
		data.put(UserData.LAST_NAME.name(), this.lastName);
		data.put(UserData.COUNTRY.name(), this.country);
		data.put(UserData.TELEPHONE_NUMBER.name(), this.telephoneNumber);
		data.put(UserData.EMAIL.name(),this.emailAddress);
		data.put(UserData.AGE.name(), this.age);
		data.put(UserData.PASSWD.name(), this.passwd);
		return (new Data(data, UserData.DATA_NAME.name()));
	}
}