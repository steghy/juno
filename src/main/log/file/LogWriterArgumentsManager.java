package main.log.file;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import main.config.ArgumentsFilter;
import main.log.color.LogColorsActivationManager;
import main.util.ArgumentsSorter;

/**
 * Classe per la configurazione della classe LogWriterActivationManager
 * mediante opzioni ed argomenti passati da linea di comando.
 * @author steghy
 *
 */
public class LogWriterArgumentsManager {
	
	/** opzione per la abilitazione della scrittura su file */
	public static final String LOG_WRITER_FOPT = "--log-file";
	public static final String LOG_WRITER_SOPT = "-lf";
	
	/** le opzioni possibili */
	private static List<String> options;
	
	/**
	 * Nessuna instanza per questa classe
	 */
	private LogWriterArgumentsManager() {
		
	}
	
	/**
	 * In base alle opzioni ed ai relativi argomenti 
	 * forniti dalla linea di comando, configura le 
	 * abilitazioni della classe LogWriterActivationManager
	 * @param args Gli argomenti contenuti in un array String
	 */
	public static void active(String[] args) {
		
		if(options == null) {
			init();
		}
		
		//organizzazione e filtraggio degli argomenti
		Map<String, Optional<Object>> filteredArgs = ArgumentsFilter
				.filter(options, ArgumentsSorter.getArguments(args));
				
		for(String key: filteredArgs.keySet()) {	
			
			Optional<Object> optional = filteredArgs.get(key);
			
			boolean argument;
	
				//controllo presenza argomento (1)
				if(optional.isEmpty()) {
						
					//bisogna fornire un booleano per ogni opzione
					throw new IllegalArgumentException("the argument "
							+ "for the option is missing, option ("+key+")");
				}
					
				//checks argument type (2) //vengono inseriti in vettori gli args
				@SuppressWarnings("unchecked")
				ArrayList<Object> temp = ((ArrayList<Object>) optional.get());

				//only one argument for one option
				if(temp.size() > 1) {
					throw new IllegalArgumentException("too many arguments "
							+ "for the option:"+key);
				}
					
				String strArg = temp.get(0).toString();
				if(strArg.equals("true")) {
					argument = true;
				}
				else if(strArg.equals("false")) {
					argument = false;
				}
				else {
					throw new IllegalArgumentException("wrong argument: "
								+strArg+" for the option: "+key
								+". It needs to be a boolean.");
				}
					
				//indirizzamento dei dati
				addressing(key, argument);
				}
		
		LogColorsActivationManager.getInstance().update();
	}
	
	/**
	 * Assegna il booleano specificato alla funzionalità della classe LogWriterActivationManager
	 * associata alla key passata in input.
	 * @param key L'opzione
	 * @param argument Un booleano
	 */
	private static void addressing(String key, boolean argument) {
		
		LogWriterActivationManager instance = LogWriterActivationManager.getInstance();
		
		//main activation
		if(key.equals(LOG_WRITER_FOPT) || key.equals(LOG_WRITER_SOPT)) {
			instance.setStatus(argument);
		}
	}
	
	
	/**
	 * Inizializza la lista contenente tutte le opzioni
	 * per la linea di comando
	 */
	private static void init() {
		
		options = new ArrayList<>();
		
		options.add(LOG_WRITER_FOPT);
		options.add(LOG_WRITER_SOPT);
		
	}

}
