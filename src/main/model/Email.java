package main.model;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class Email {
	
	/* */
	static final String EMAIL = "email";
	
	/** email */
	private String email;
	
	/**
	 * Costruisce una email 
	 * @param email la email
	 */
	public Email(String email) {
		this.email = email;
	}
	
	/**
	 * Ritorna le email
	 * @return la email
	 */
	public String getEmail() {
		return this.email;
	}
}
