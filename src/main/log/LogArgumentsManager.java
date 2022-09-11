
package main.log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import main.util.ArgumentsFilter;
import main.util.ArgumentsSorter;

/**
 * 
 * @author steghy
 * @email <steghy.github@proton.me>
 */
public class LogArgumentsManager {
	
	static final String LOG_FOPT = "--log";
	static final String LOG_SOPT = "-l";
	
	//
	static final String LOG_LOAD_PRC_FOPT = "--log-loadprc";
	static final String LOG_LOAD_PRC_SOPT = "-llp";
	
	//
	static final String LOG_CONF_PRC_FOPT = "--log-confprc";
	static final String LOG_CONF_PRC_SOPT = "-lcp";
	
	//
	static final String LOG_SUPP_PRC_FOPT = "--log-supplyprc";
	static final String LOG_SUPP_PRC_SOPT = "-lsp";
	
	//
	static final String LOG_SUBPRC_LOAD_FOPT = "--log-load-subprc";
	static final String LOG_SUBPRC_LOAD_SOPT = "-llsp";
	
	//
	static final String LOG_SUBPRC_CONF_FOPT = "--log-conf-subprc";
	static final String LOG_SUBPRC_CONF_SOPT = "-lcsp"; 
	
	//
	static final String LOG_SUBPRC_SUPP_FOPT = "--log-supp-subprc";
	static final String LOG_SUBPRC_SUPP_SOPT = "-lssp";
	
	//
	static final String LOG_INSTR_LOAD_FOPT = "--log-loadinst";
	static final String LOG_INSTR_LOAD_SOPT = "-lli";
	
	//
	static final String LOG_INSTR_CONF_FOPT = "--log-confinst";
	static final String LOG_INSTR_CONF_SOPT = "-lci";
	
	//
	static final String LOG_INSTR_SUPP_FOPT = "--log-supplyinst";
	static final String LOG_INSTR_SUPP_SOPT = "-lsi";
	
	// Communications service
	static final String LOG_COM_FOPT = "--log-com";
	static final String LOG_COM_SOPT = "-lc";
	
	// All options
	private static List<String> options;

	
	// No instance
	private LogArgumentsManager() {

	}

	
	/**
	 * 
	 * @param args
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
			ArrayList<Object> temp = ((ArrayList<Object>) optional.get());
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
			LogArgumentsManager.addressing(key, argument);
		}
		LogActivationManager.getInstance().update();
	}
	
	
	//
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
	
	
	// Initialiaze options
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
