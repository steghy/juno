package main.config;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
/**
 * Classe per la filtrazione di mappe in base a specifici valori
 * contenuti all'interno di liste. Utile per filtrare gli argomenti
 * inseriti nel comando per lanciare la applicazione
 * @author steghy
 *
 */
public class ArgumentsFilter {
	
	/**
	 * Filtra la mappa in input specificata in base ai valori contenuti all'interno
	 * della lista spacificata. Ritorna una mappa contenente soltanto le coppie chiave
	 * valore le cui chiavi sono presenti sia nella lista specificata che nella mappa
	 * sorgente
	 * @param list Una lista
	 * @param source Una mappa
	 * @return Una mappa
	 */
	public static Map<String, Optional<Object>> filter(List<String> list, Map<String, Optional<Object>> source) {
		
		Map<String, Optional<Object>> output = new HashMap<>();
		
		source.keySet()
			.stream()
			.filter(k->list.contains(k))
			.forEach(k->addOptional(k, source, output));
		
		return output;
	}
	
	private static void addOptional(String k, Map<String, Optional<Object>> source, Map<String, Optional<Object>> output) {
		output.put(k, source.get(k));
	}
}
