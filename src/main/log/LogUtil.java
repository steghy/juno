package main.log;
/**
 * Classe per il contenimento di metodi di utilità 
 * condivisi
 * @author steghy
 *
 */
public class LogUtil {
	
	/**
	 * Trasforma l'oggetto passato in input in booleano
	 * @param object Un Object
	 * @return un booleano
	 */
	public static boolean toBoolean(Object object) {
		String string = object.toString();
		if(string.equals(Boolean.toString(true))) {
			return true;
		}
		else if(string.equals(Boolean.toString(false))) {
			return false;
		}
		else {
			throw new IllegalArgumentException("Data error"
					+ ", I don't recognize the value" + string);
		}
	}

}
