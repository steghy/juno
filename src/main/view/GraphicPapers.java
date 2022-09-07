package main.view;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import main.config.Configurable;
import main.config.DataPackage;
import main.config.Exportable;
import main.model.Card;
import main.util.PathGenerator;

/**
 * Classe per l'amministrazione dei percorsi delle immagine delle carte.
 * La classe permette di istanziare un unico oggetto accedibile da getInstance().
 * Le associazioni "Valore carte" -> "Immagine nel disco" sono conserate all'interno 
 * di mappe accedibili mediante i metodi di get.
 * @author steghy
 *
 */
public class GraphicPapers implements Configurable, Exportable{
	
	
	public static final String EXTENSION = ".svg";
	public static final int CARD_TYPES = 13;
	public static final int ALL_CARD_TYPES = 15;
	
	public static final String RED_NAME =    "red";
	public static final String BLUE_NAME =   "blue";
	public static final String GREEN_NAME =  "green";
	public static final String YELLOW_NAME = "yellow";
	public static final String JOLLY_NAME =  "jolly";
	public static final String THEMES_DIR_NAME = "themes";
	
	/** cartelle dei files */
	public static String dirName;
	public static String themePath;
	public static String redPath;
	public static String bluePath;
	public static String greenPath;
	public static String yellowPath;
	public static String jollyPath;

	/** mappe valore-file */
	private Map<Integer, File> r_map;
	private Map<Integer, File> b_map;
	private Map<Integer, File> g_map;
	private Map<Integer, File> y_map;
	private Map<Integer, File> j_map;
	
	
	private static GraphicPapers instance;
	
	private GraphicPapers() throws IOException{
		init();
	}
	
	//restituisce l'unica istanza
	public static GraphicPapers getInstance() throws IOException {
		if(instance == null) {
			instance = new GraphicPapers();
		} return instance;
	}
	
	/** 
	 * Inizializzazione delle mappe
	 * @throws IOException 
	 */
	private void init() throws IOException {
		r_map = new TreeMap<>();
		b_map = new TreeMap<>();
		g_map = new TreeMap<>();
		y_map = new TreeMap<>();
		j_map = new TreeMap<>();
		
		Card[] cards = Card.values();
		for(int i = 0; i < CARD_TYPES; i++) {
			r_map.put(cards[i].getValue(), new File(PathGenerator.generate(redPath, RED_NAME + i + EXTENSION)));
			b_map.put(cards[i].getValue(), new File(PathGenerator.generate(bluePath, BLUE_NAME + i + EXTENSION)));
			g_map.put(cards[i].getValue(), new File(PathGenerator.generate(greenPath, GREEN_NAME + i + EXTENSION)));
			y_map.put(cards[i].getValue(), new File(PathGenerator.generate(yellowPath, YELLOW_NAME + i + EXTENSION)));
		}
		
		//carte jolly
		j_map.put(cards[13].getValue(), new File(PathGenerator.generate(jollyPath, JOLLY_NAME + 13 + EXTENSION)));
		j_map.put(cards[14].getValue(), new File(PathGenerator.generate(jollyPath, JOLLY_NAME + 14 + EXTENSION)));
	}
	
	/**
	 * Ritorna la mappa delle carte rosse
	 * @return Una mappa
	 */
	public Map<Integer, File> getRedMap(){
		return r_map;
	}
	
	/**
	 * Ritorna la mappa delle carte blue
	 * @return Una mappa
	 */
	public Map<Integer, File> getBlueMap(){
		return b_map;
	}
	
	/**
	 * Ritorna la mappa delle carte verdi
	 * @return Una mappa
	 */
	public Map<Integer, File> getGreenMap(){
		return g_map;
	}
	
	/**
	 * Ritorna la mappa delle carte gialle
	 * @return Una mappa
	 */
	public Map<Integer, File> getYellowMap(){
		return y_map;
	}
	
	/**
	 * Ritorna la mappa delle carte gialle
	 * @return
	 */
	public Map<Integer, File> getJollyMap(){
		return j_map;
	}

	@Override
	public void configure(DataPackage data) {
		
	}

	@Override
	public DataPackage provideData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
