package main.log.color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import main.config.ArgumentsFilter;
import main.util.ArgumentsSorter;

public class LogColorsArgumentsManager {
	
	/** debug terminal options */
	public static final String COL_FOPT = "--log-col";
	public static final String COL_SOPT = "-lc";
	
	/** debug process terminal options */
	public static final String LOAD_PRC_COL_FOPT = "--log-col-loadprc";
	public static final String LOAD_PRC_COL_SOPT = "-llpc";
	
	public static final String CONF_PRC_COL_FOPT = "--log-col-confprc";
	public static final String CONF_PRC_COL_SOPT = "-lcpc";
	
	public static final String SUPP_PRC_COL_FOPT = "--log-col-supplyprc";
	public static final String SUPP_PRC_COL_SOPT = "-lspc";
	
	/** debug sub-process terminal options */
	public static final String SUBPRC_LOAD_COL_FOPT = "--log-col-load-subprc";
	public static final String SUBPRC_LOAD_COL_SOPT = "-llspc";
	public static final String SUBPRC_CONF_COL_FOPT = "--log-col-conf-subprc";
	public static final String SUBPRC_CONF_COL_SOPT = "-lcspc"; 
	public static final String SUBPRC_SUPP_COL_FOPT = "--log-col-supp-subprc";
	public static final String SUBPRC_SUPP_COL_SOPT = "-lsspc";
	
	/** debug instructions terminal options */
	public static final String INST_LOAD_COL_FOPT = "--log-col-load-inst";
	public static final String INST_LOAD_COL_SOPT = "-llic";
	public static final String INST_CONF_COL_FOPT = "--log-col-conf-inst";
	public static final String INST_CONF_COL_SOPT = "-lcic";
	public static final String INST_SUPP_COL_FOPT = "--log-col-supp-inst";
	public static final String INST_SUPP_COL_SOPT = "-lsic";
	
	/** debug communications terminal options */
	public static final String COMM_COL_FOPT = "--log-col-com";
	public static final String COMM_COL_SOPT = "-lcc";
	
	
	/** le opzioni in lista delle riga di comando */
	private static List<String> options;

	/** no istance */
	private LogColorsArgumentsManager() {
		
	}

	/**
	 * In base alle opzioni ed ai relativi argomenti 
	 * forniti dalla linea di comando, configura le 
	 * abilitazioni della classe LogColorsArgumentsManager
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
	 * Indirizza il valore booleano specificato nel canale di Debug associato
	 * alla key (dove la key è la opzione per l'attivazione/disattivazione del canale). 
	 * @param key La opzione
	 * @param argument Un booleano
	 */
	private static void addressing(String key, boolean argument) {
		
		LogColorsActivationManager instance = LogColorsActivationManager.getInstance();
		
		//main activation
		if(key.equals(COL_FOPT) || key.equals(COL_SOPT)) {
			instance.setMainLogColStat(argument);
		}
		
		//processes
		else if(key.equals(LOAD_PRC_COL_FOPT) || key.equals(LOAD_PRC_COL_SOPT)) {
			instance.setLoadProcColStat(argument);
		}
		else if(key.equals(CONF_PRC_COL_FOPT) || key.equals(CONF_PRC_COL_SOPT)) {
			instance.setConfProcColStat(argument);
		}
		else if(key.equals(SUPP_PRC_COL_FOPT) || key.equals(SUPP_PRC_COL_SOPT)) {
			instance.setSuppProcColStat(argument);
		}
		
		//sub-processes
		else if(key.equals(SUBPRC_LOAD_COL_FOPT) || key.equals(SUBPRC_LOAD_COL_SOPT)) {
			instance.setLoadSUBProcColStat(argument);
		}
		else if(key.equals(SUBPRC_CONF_COL_FOPT) || key.equals(SUBPRC_CONF_COL_SOPT)) {
			instance.setConfSUBProcColStat(argument);
		}
		else if(key.equals(SUBPRC_SUPP_COL_FOPT) || key.equals(SUBPRC_SUPP_COL_SOPT)) {
			instance.setSuppSUBProcColStat(argument);
		}
		
		//instructions
		else if(key.equals(INST_LOAD_COL_FOPT) || key.equals(INST_LOAD_COL_SOPT)) {
			instance.setLoadInstColStat(argument);
		}
		else if(key.equals(INST_CONF_COL_FOPT) || key.equals(INST_CONF_COL_SOPT)) {
			instance.setConfInstColStat(argument);
		}
		else if(key.equals(INST_SUPP_COL_FOPT) || key.equals(INST_SUPP_COL_SOPT)) {
			instance.setSuppSInstColStat(argument);
		}
		
		//communications
		else if(key.equals(COMM_COL_FOPT) || key.equals(COMM_COL_FOPT)) {
			instance.setSuppSInstColStat(argument);
		}			
	}
	
	/**
	 * Inizializza la lista contenente tutte le opzioni 
	 * per la linea di comando.
	 */
	private static void init() {
				
		options = new ArrayList<>();
		
		//main log
		options.add(COL_FOPT);     options.add(COL_SOPT);
		
		//processes
		options.add(LOAD_PRC_COL_FOPT); options.add(LOAD_PRC_COL_SOPT);
		options.add(CONF_PRC_COL_FOPT); options.add(CONF_PRC_COL_SOPT);
		options.add(SUPP_PRC_COL_FOPT); options.add(SUPP_PRC_COL_SOPT);
		
		//sub-processes
		options.add(SUBPRC_LOAD_COL_FOPT); options.add(SUBPRC_LOAD_COL_SOPT);
		options.add(SUBPRC_CONF_COL_FOPT); options.add(SUBPRC_CONF_COL_SOPT);
		options.add(SUBPRC_SUPP_COL_FOPT); options.add(SUBPRC_SUPP_COL_SOPT);
		
		//instructions
		options.add(INST_LOAD_COL_FOPT); options.add(INST_LOAD_COL_SOPT);
		options.add(INST_CONF_COL_FOPT); options.add(INST_CONF_COL_SOPT);
		options.add(INST_SUPP_COL_FOPT); options.add(INST_SUPP_COL_SOPT);
		
		//communications
		options.add(COMM_COL_FOPT); options.add(COMM_COL_SOPT);

	}

}
