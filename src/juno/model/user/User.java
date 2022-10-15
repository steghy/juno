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
	private String email;
	
	/* Telephone number */
	private long telephoneNumber;
	
	/* Country */
	private String country;
	
	/* Age */
	private int age;
	
	/* User instance */
	private static User instance;
	
	
	/* Buids an empty User instance */
	private User() {}
	
	
	/**
	 * Returns the User instance
	 * @return The User instance
	 */
	public static User getInstance() {
		if(instance == null) {
			instance = new User();
		} return instance;
	}
	
	/**
	 * Sets the email 
	 * @param email The email
	 */
	public void setEmail(String email) {
		this.email = email;
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
	public String getEmail() {
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

	
	@Override
	public void configure(Data data) throws DataException {

		// Data consistency check
		if(!data.getName().equals(UserData.DATA_NAME.name())) {
			throw new DataException("No " + UserData.DATA_NAME.name() 
								  + "key found.");
		}

		Map<String, Object> userData = data.getData();
		if(Arrays.asList(UserData.values()).stream()
			.filter(k -> {
				return !userData.containsKey(k.name());
			}).count() != 0) {
			throw new DataException("Corrupted data");
		}
		
		this.username = (String) userData.get(UserData.USER_NAME.name());
		this.name = (String) userData.get(UserData.NAME.name());
		this.lastName = (String) userData.get(UserData.LAST_NAME.name());
		this.country = (String) userData.get(UserData.COUNTRY.name());
		this.age = (Integer) userData.get(UserData.AGE.name());
		this.email = (String) userData.get(UserData.EMAIL.name());
		Object obj = userData.get(UserData.TELEPHONE_NUMBER.name());
		long temp = 0;
		if(obj instanceof Long) {
			temp = (long)obj;
		} else if(obj instanceof Integer) {
			temp = Integer.toUnsignedLong((Integer)obj);
		} this.telephoneNumber = temp;
	} 

	
	@Override
	public Data provideData() {
		Map<String, Object> data = new HashMap<>();
		data.put(UserData.USER_NAME.name(), this.username);
		data.put(UserData.NAME.name(), this.name);
		data.put(UserData.LAST_NAME.name(), this.lastName);
		data.put(UserData.COUNTRY.name(), this.country);
		data.put(UserData.TELEPHONE_NUMBER.name(), this.telephoneNumber);
		data.put(UserData.EMAIL.name(),this.email);
		data.put(UserData.AGE.name(), this.age);
		return (new Data(data, UserData.DATA_NAME.name()));
	}
}