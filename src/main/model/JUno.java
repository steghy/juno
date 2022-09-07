package main.model;

import java.util.List;

import main.depend.Dependable;
import main.util.Os;

public class JUno implements Dependable {
	
	private List<String> dependencies;
	private String localityDependencies;
	private static JUno instance;
	
	/**
	 * Crea l'unica istanza del gioco JUno impostande i nomi delle
	 * dipendenze e la loro località
	 */
	private JUno() {
		this.dependencies = List.of("bin", "prefer", 
				"saves", "profiles", "config", "themes");
		this.localityDependencies = Os.getCurrentPath();
	}
	
	/**
	 * Ritorna la singola istanze di questa classe
	 * @return L'istanza di questa classe
	 */
	public JUno getInstance() {
		if(instance == null) {
			instance = new JUno();
		} return instance;
	}

	@Override
	public List<String> provideDependencies() {
		return dependencies;
	}

	@Override
	public String provideLocationDependencies() {
		return localityDependencies;
	}
	
	
	

}
