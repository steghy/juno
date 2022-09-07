package main.log.file;

/**
 * Classe per la scrittura di file di registro del programma
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Classe per la scrittura di testo all'interno di file
 * che rappresentano file di registro per il programma
 * @author steghy
 *
 */
public class LogWriter {
	
	/** L'abilitatore */
	private LogWriterActivationManager activator;
	
	/** configuratore */
	private LogWriterConfigurator configurator;
	
	/** lo scrittore */
	private PrintWriter writer;
	
	/** l'unica istanza di questa classe */
	private static LogWriter instance;
	
	/**
	 * Costruisce il log writer
	 * @throws IOException 
	 */
	private LogWriter() {
		init();
	}
	
	/**
	 * Restituisce l'unica istanza di questa classe
	 * @return L'oggetto LogWriter di questa classe
	 * @throws IOException 
	 */
	public static LogWriter getInstance() {
		if(instance == null) {
			instance = new LogWriter();
		}
		return instance;
	}
	
	/**
	 * Scrive le informazioni specificate all'interno
	 * di un file la cui località è fornita dal 
	 * LogWriterConfigurator
	 * @param string L'informazione da scrivere
	 * @throws FileNotFoundException 
	 */
	public void write(String string) {
		
		if(instance.activator.getStatus()) {
			
			if(writer == null) {
				try {
					writer = new PrintWriter(configurator.getPath());
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			
			writer.println(string);			
			writer.flush();
		}
	}

	private void init() {
		activator = LogWriterActivationManager.getInstance();
		configurator = LogWriterConfigurator.getInstance();
	}
}
