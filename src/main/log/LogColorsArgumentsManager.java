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
public class LogColorsArgumentsManager {
	
	/* main activation option name */
	static final String COL_FOPT = "--log-col";
	static final String COL_SOPT = "-lc";
	
	/* load process option name */
	static final String LOAD_PRC_COL_FOPT = "--log-col-loadprc";
	static final String LOAD_PRC_COL_SOPT = "-llpc";
	
	/* conf process option name */
	static final String CONF_PRC_COL_FOPT = "--log-col-confprc";
	static final String CONF_PRC_COL_SOPT = "-lcpc";
	
	/* supp process option name */
	static final String SUPP_PRC_COL_FOPT = "--log-col-supplyprc";
	static final String SUPP_PRC_COL_SOPT = "-lspc";
	
	/* */ 
	static final String SUBPRC_LOAD_COL_FOPT = "--log-col-load-subprc";
	static final String SUBPRC_LOAD_COL_SOPT = "-llspc";
	
	//
	static final String SUBPRC_CONF_COL_FOPT = "--log-col-conf-subprc";
	static final String SUBPRC_CONF_COL_SOPT = "-lcspc"; 
	
	//
	static final String SUBPRC_SUPP_COL_FOPT = "--log-col-supp-subprc";
	static final String SUBPRC_SUPP_COL_SOPT = "-lsspc";
	
	//
	static final String INST_LOAD_COL_FOPT = "--log-col-load-inst";
	static final String INST_LOAD_COL_SOPT = "-llic";
	
	//
	static final String INST_CONF_COL_FOPT = "--log-col-conf-inst";
	static final String INST_CONF_COL_SOPT = "-lcic";
	
	//
	static final String INST_SUPP_COL_FOPT = "--log-col-supp-inst";
	static final String INST_SUPP_COL_SOPT = "-lsic";
	
	//
	static final String COMM_COL_FOPT = "--log-col-com";
	static final String COMM_COL_SOPT = "-lcc";
	
	
	// all options
	private static List<String> options;

	
	// Singleton pattern
	private LogColorsArgumentsManager() {}


	/**
	 * 
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void active(String[] args) {
		if(options == null) {
			init();
		}
		Map<String, Optional<Object>> filteredArgs = ArgumentsFilter
				.filter(options, ArgumentsSorter.getArguments(args));
		for(String key: filteredArgs.keySet()) {	
			Optional<Object> optional = filteredArgs.get(key);
				if(optional.isEmpty()) {
					throw new IllegalArgumentException("the argument "
							+ "for the option is missing, option ("+key+")");
				}
				ArrayList<Object> temp = ((ArrayList<Object>) optional.get());
				if(temp.size() > 1) {
					throw new IllegalArgumentException("too many arguments "
							+ "for the option:"+key);
				}
				String strArg = temp.get(0).toString();
				if(strArg.equals("true")) {
				}
				else if(strArg.equals("false")) {
				}
				else {
					throw new IllegalArgumentException("wrong argument: "
								+strArg+" for the option: "+key
								+". It needs to be a boolean.");
				}
				/**
				 * Implementare qui
				 */
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
