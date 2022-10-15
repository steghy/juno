package juno.main.init;

import juno.exception.DataException;

/**
 * Configurable interface.
 * @author steghy
 * @email steghy.github@proton.me
 */
public interface Configurable {
		
	/**
	 * Configura l'oggetto invocante con l'oggetto
	 * data fornito in input.
	 * @param data Un oggetto Data
	 * @throws FileNotFoundException 
	 */
	void configure(Data data) throws DataException;
}
