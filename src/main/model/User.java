package main.model;

import java.util.HashMap;
import java.util.Map;

import main.config.Configurable;
import main.config.Data;
import main.config.DataPackage;
import main.config.Exportable;
import main.log.Log;
import main.log.LogMessage;

/**
 * This class defines users.
 * A User if composed by:
 * 		
 * @author steghy
 * @email steghy.github@proton.me
 */
public class User implements Configurable, Exportable {
	
	/* Data keys (for configuration e exportation) */
	static final String DATA_NAME = "user-data";
	static final String USER_NAME = "user-name";
	static final String NAME = "name";
	static final String LAST_NAME = "last-name";
	static final String EMAIL = "email";
	static final String TELEPHONE_NUMBER = "telephone-number";
	static final String COUNTRY = "country";
	static final String PASSWD = "passwd";
	static final String AGE = "age";
	
	/* Username */
	private String username;
	
	/* Name */
	private String name;
	
	/* Lastname */
	private String lastName;
	
	/* Email address */
	private Email emailAddress;
	
	/* Telephone number */
	private long telephoneNumber;
	
	/* Country */
	private String country;
	
	/* Passwd */
	private Passwd passwd;
	
	/* Age */
	private int age;
	
	
	/**
	 * Builds a user
	 */
	public User() {}
	
	
	/**
	 * Builds a user with all the
	 * informations.
	 * @param username The username
	 * @param name The name
	 * @param lastName The last name
	 * @param emailAddress The email address
	 * @param telephoneNumber The telephone number
	 * @param country The country
	 * @param passwd The passwd
	 * @param age The age
	 */
	public User(String username, String name,
			String lastName, Email emailAddress,
			long telephoneNumber, String country,
			Passwd passwd, int age) {
		this.username = username;
		this.name = name;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.telephoneNumber = telephoneNumber;
		this.country = country;
		this.passwd = passwd;
		this.age = age;
	}
	
	/**
	 * Sets the email address 
	 * @param emailAddress The email address
	 */
	public void setEmail(Email emailAddress) {
		// implements email checker
		this.emailAddress = emailAddress;
	}

	
	/**
	 * Sets the passwd
	 * @param passwd The passwd
	 */
	public void setPasswd(Passwd passwd) {
		// implements passwd checker
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
		}
		this.age = age;
	}
	
	
	/**
	 * Sets the country 
	 * @param country The country
	 */
	public void setCountry(String country) {
		// implements data checker for this data
		this.country = country;
	}
	
	
	/**
	 * Sets the telephone number
	 * @param telephoneNumber The telephone number
	 */
	public void setTelephoneNumber(long telephoneNumber) {
		// implements telephone number checker
		this.telephoneNumber = telephoneNumber;
	}
	
	
	/**
	 * Sets the lastname
	 * @param lastName The lastname
	 */
	public void setLastName(String lastName) {
		// implements lastname checker
		this.lastName = lastName;
	}

	
	/**
	 * Sets the name
	 * @param name The name
	 */
	public void setName(String name) {
		// implements name checker
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
	 * Returns the email address
	 * @return The email address
	 */
	public Email getEmailAddress() {
		return this.emailAddress;
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

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void configure(DataPackage source) {
		
		Log.print(LogMessage.SCONF_PROC, DATA_NAME);
		Log.print(LogMessage.SCONF_SUBPROC, "");
		
		if(!(source.getDataObj().getName().equals(User.DATA_NAME))) {
			throw new IllegalArgumentException(
					"Wrong data , no "+DATA_NAME+" key found");
		}
		
		Map<String, Object> data = (HashMap) source.getDataObj().getData(); 

		if(data.isEmpty()) {
			Log.print(LogMessage.C_NO_DATA_FOUND, "");
		}
		
		else {
			
			// User name
			if(data.containsKey(User.USER_NAME)) {
				String temp = (String) data.get(User.USER_NAME);
				this.username = temp;
			}
			
			// Name
			if(data.containsKey(User.NAME)){
				String temp = (String) data.get(User.NAME);
				this.name = temp;
			}
			
			// last name
			if(data.containsKey(User.LAST_NAME)) {
				String temp = (String) data.get(User.LAST_NAME);
				this.lastName = temp;
			}
			
			// country
			if(data.containsKey(User.COUNTRY)) {
				String temp = (String) data.get(User.COUNTRY);
				this.country = temp;
			}
			
			// phone number
			if(data.containsKey(User.TELEPHONE_NUMBER)) {
				Object obj = data.get(User.TELEPHONE_NUMBER);
				long temp = 0;
				
				// if a number had been entered
				if(obj instanceof Long) {
					temp = (long)obj;
				}
				
				// if a number had not been entered
				if(obj instanceof Integer) {
					temp = Integer.toUnsignedLong((Integer)obj);
				}
				
				this.telephoneNumber = temp;
			}
			
			// age
			if(data.containsKey(User.AGE)) {
				int temp = (Integer) data.get(User.AGE);
				this.age = temp;
			}
			
			// email
			if(data.containsKey(User.EMAIL)) {
				Map<String, Object> temp = (HashMap) data.get(User.EMAIL);
				Email email = new Email((String)temp.get(Email.EMAIL));
				this.emailAddress = email;
			}
			
			// passwd
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
	
		// User name
		if(this.username != null) {
			data.put(User.USER_NAME, this.username);
		}
		
		// Name
		if(this.name != null) {
			data.put(User.NAME, this.name);
		}
		
		// Lastname
		if(this.lastName != null) {
			data.put(User.LAST_NAME, this.lastName);
		}
		
		// Country
		if(this.country != null) {
			data.put(User.COUNTRY, this.country);
		}
		
		// Telephone number
		if(this.telephoneNumber != 0) {
			data.put(User.TELEPHONE_NUMBER, this.telephoneNumber);
		}
		
		// Email address
		if(this.emailAddress != null) {
			data.put(User.EMAIL,this.emailAddress);
		}
			
		// Age
		if(this.age != 0) {
			data.put(User.AGE, this.age);
		}
		
		// Passwd
		if(this.passwd != null) {
			data.put(User.PASSWD, this.passwd);
		}
		
		Log.print(LogMessage.ISUPP_DATA, data);
		Log.print(LogMessage.ESUPPLY_SUBPROC, "");
		Log.print(LogMessage.ESUPPLY_PROC, DATA_NAME);
		
		return new DataPackage(new Data(data, DATA_NAME));
	}
	

}
