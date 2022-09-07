package main.model;
/**
 * Classe per la rappresentazione, gestione
 * di email.
 * @author steghy
 *
 */
public class Email {
	
	/** key per i data */
	public static final String EMAIL = "email";
	
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
