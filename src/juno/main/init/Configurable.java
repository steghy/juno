package juno.main.init;

import java.io.FileNotFoundException;
import java.io.IOException;
import juno.exception.DataException;

/**
 * Configurable interface.
 * @author steghy
 * @email steghy.github@proton.me
 */
public interface Configurable {
		
	/**
	 * Configura l'oggetto sul quale viene invocato
	 * con la mappa passata in input.
	 * @param data La mappa (contente i dati da passare all'invocante)
	 * @throws IOException
	 */
	void configure(Data data) throws DataException, FileNotFoundException;
}
