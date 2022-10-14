package juno.model.user;

import java.util.Map;

import juno.annotation.ConfigurableAnnotation;
import juno.exception.DataTypeException;
import juno.main.init.Configurable;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
@ConfigurableAnnotation
public class Email implements Configurable{
	
	/* Email */
	private String email;


	/**
	 * Builds an email
	 * @param email The email
	 */
	public Email(String email) {
		this.email = email;
	}

	
	/**
	 * Returns the email
	 * @return The email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Returns the domain of this email
	 * @return The domain of this email
	 */
	public String getDomain() {
		String[] temp = this.toString().split(".");
		return temp[temp.length-1];
	}


	@Override
	public void configure(Map<String, Object> data) throws DataTypeException {
		this.email = (String) data.get("email");
	}
}
