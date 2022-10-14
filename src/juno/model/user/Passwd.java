package juno.model.user;
/**
 * Classe per la rappresentazione, gestione
 * di passwd
 * @author steghy
 *
 */
public class Passwd {
	
	/** key per i data */
	public static final String PASSWD = "passwd";

	//passwd in chiaro
	private String passwd;
	
	/**
	 * Costruisce una semplice passwd
	 * @param passwd La passwd
	 */
	public Passwd(String passwd) {
		this.passwd = passwd;
	}
	
	/**
	 * Restituisce la passwd
	 * @return la passwd
	 */
	public String getPasswd() {
		return this.passwd;
	}
	
	/**
	 * Imposta la passwd specificata
	 * @param passwd La passwd
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}