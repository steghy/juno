
package main.log.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import main.config.ArgumentsFilter;
import main.util.ArgumentsSorter;

/**
 * Classe per l'amministrazione delle abilitazioni dei
 * processi di stampa a video mediante la classe Debug.
 * @author steghy
 *
 */
public class LogArgumentsManager {
	
	/** debug terminal options */
	public static final String LOG_FOPT = "--log";
	public static final String LOG_SOPT = "-l";
	
	/** debug process terminal options */
	public static final String LOG_LOAD_PRC_FOPT = "--log-loadprc";
	public static final String LOG_LOAD_PRC_SOPT = "-llp";
	
	public static final String LOG_CONF_PRC_FOPT = "--log-confprc";
	public static final String LOG_CONF_PRC_SOPT = "-lcp";
	
	public static final String LOG_SUPP_PRC_FOPT = "--log-supplyprc";
	public static final String LOG_SUPP_PRC_SOPT = "-lsp";
	
	/** debug sub-process terminal options */
	public static final String LOG_SUBPRC_LOAD_FOPT = "--log-load-subprc";
	public static final String LOG_SUBPRC_LOAD_SOPT = "-llsp";
	
	public static final String LOG_SUBPRC_CONF_FOPT = "--log-conf-subprc";
	public static final String LOG_SUBPRC_CONF_SOPT = "-lcsp"; 
	
	public static final String LOG_SUBPRC_SUPP_FOPT = "--log-supp-subprc";
	public static final String LOG_SUBPRC_SUPP_SOPT = "-lssp";
	
	/** debug instructions terminal options */
	public static final String LOG_INSTR_LOAD_FOPT = "--log-loadinst";
	public static final String LOG_INSTR_LOAD_SOPT = "-lli";
	
	public static final String LOG_INSTR_CONF_FOPT = "--log-confinst";
	public static final String LOG_INSTR_CONF_SOPT = "-lci";
	
	public static final String LOG_INSTR_SUPP_FOPT = "--log-supplyinst";
	public static final String LOG_INSTR_SUPP_SOPT = "-lsi";
	
	/** debug communications terminal options */
	public static final String LOG_COM_FOPT = "--log-com";
	public static final String LOG_COM_SOPT = "-lc";
	
	
	/** le opzioni in lista delle riga di comando */
	private static List<String> options;

	/**
	 * Non si devono istanziarne oggetti
	 */
	private LogArgumentsManager() {

	}
	
	/**
	 * Imposta le variabili statiche della classe Debug per abilitare
	 * le stampe. La mappa fornita in input contiene le coppie 
	 * DebugDaAttivare-booleano.
	 * @param args Una mappa
	 */
	@SuppressWarnings("unchecked")
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
			ArrayList<Object> temp = ((ArrayList<Object>) optional.get());

			//only one argument for one option
			if(temp.size() > 1) {
				throw new IllegalArgumentException("too many arguments "
						+ "for the option:"+key);
			}
			
			String strArg = temp.get(0).toString();
			if(strArg.equals(Boolean.toString(true))) {
				argument = true;
			}
			else if(strArg.equals(Boolean.toString(false))) {
				argument = false;
			}
			else {
				throw new IllegalArgumentException("wrong argument: "
						+strArg+" for the option: "+key);
			}
			
			//indirizzamento dei dati
			LogArgumentsManager.addressing(key, argument);
		}
		
		LogActivationManager.getInstance().update();
	}
	
	/**
	 * Indirizza il valore booleano specificato nel canale di Debug associato
	 * alla key (dove la key è la opzione per l'attivazione/disattivazione del canale). 
	 * @param key La opzione
	 * @param argument Un booleano
	 */
	private static void addressing(String key, boolean argument) {
		
		LogActivationManager instance = LogActivationManager.getInstance();
		
		//main
		if(key.equals(LOG_FOPT) || key.equals(LOG_SOPT)) {
			instance.setLogMainStat(argument);
		}
		
		//processes
		else if(key.equals(LOG_LOAD_PRC_FOPT) || key.equals(LOG_LOAD_PRC_SOPT)) {
			instance.setLoadProStat(argument);
		}
		else if(key.equals(LOG_CONF_PRC_FOPT) || key.equals(LOG_CONF_PRC_SOPT)) {
			instance.setConfProStat(argument);
		}
		else if(key.equals(LOG_SUPP_PRC_FOPT) || key.equals(LOG_SUPP_PRC_SOPT)) {
			instance.setSuppProStat(argument);
		}
		
		//sub-processes
		else if(key.equals(LOG_SUBPRC_LOAD_FOPT) || key.equals(LOG_SUBPRC_LOAD_SOPT)) {
			instance.setLoadSUBProStat(argument);
		}
		else if(key.equals(LOG_SUBPRC_CONF_FOPT) || key.equals(LOG_SUBPRC_CONF_SOPT)) {
			instance.setConfSUBProStat(argument);
		}
		else if(key.equals(LOG_SUBPRC_SUPP_FOPT) || key.equals(LOG_SUBPRC_SUPP_SOPT)) {
			instance.setSuppSUBProStat(argument);
		}
		
		//instructions
		else if(key.equals(LOG_INSTR_LOAD_FOPT) || key.equals(LOG_INSTR_LOAD_SOPT)) {
			instance.setLoadInstStat(argument);
		}
		else if(key.equals(LOG_INSTR_CONF_FOPT) || key.equals(LOG_INSTR_CONF_SOPT)) {
			instance.setConfInstStat(argument);
		}
		else if(key.equals(LOG_INSTR_SUPP_FOPT) || key.equals(LOG_INSTR_SUPP_SOPT)) {
			instance.setSuppInstStat(argument);
		}
		
		//communications
		else if(key.equals(LOG_COM_FOPT) || key.equals(LOG_COM_FOPT)) {
			instance.setCommStat(argument);
		}			
	}
	
	/**
	 * Costruisce una lista contenente tutte le opzioni per la
	 * abilitazione delle stampe per la classe Debug.
	 * @return Una lista
	 */
	private static void init() {
				
		options = new ArrayList<>();
		
		//aggiunta delle opzioni
		options.add(LOG_FOPT);     options.add(LOG_SOPT);
		
		//processes
		options.add(LOG_LOAD_PRC_FOPT); options.add(LOG_LOAD_PRC_SOPT);
		options.add(LOG_CONF_PRC_FOPT); options.add(LOG_CONF_PRC_SOPT);
		options.add(LOG_SUPP_PRC_FOPT); options.add(LOG_SUPP_PRC_SOPT);
		
		//sub-processes
		options.add(LOG_SUBPRC_LOAD_FOPT); options.add(LOG_SUBPRC_LOAD_SOPT);
		options.add(LOG_SUBPRC_CONF_FOPT); options.add(LOG_SUBPRC_CONF_SOPT);
		options.add(LOG_SUBPRC_SUPP_FOPT); options.add(LOG_SUBPRC_SUPP_SOPT);
		
		//instructions
		options.add(LOG_INSTR_LOAD_FOPT); options.add(LOG_INSTR_LOAD_SOPT);
		options.add(LOG_INSTR_CONF_FOPT); options.add(LOG_INSTR_CONF_SOPT);
		options.add(LOG_INSTR_SUPP_FOPT); options.add(LOG_INSTR_SUPP_SOPT);
		
		//communications
		options.add(LOG_COM_FOPT); options.add(LOG_COM_SOPT);
	}
}
