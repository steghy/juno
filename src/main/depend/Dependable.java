package main.depend;

import java.util.List;

/**
 * interfaccia per il collegamento con il
 * controllore delle dipendenze
 * @author steghy
 *
 */
public interface Dependable {

	//fornisce una lista dei nomi dei files
	List<String> provideDependencies();
	
	//fornisce il luogo in cui ricercare i file
	String provideLocationDependencies();
}
