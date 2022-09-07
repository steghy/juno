package main.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

public class GraphicCardTest {
	public static void main(String... args) throws IOException {
		
		//i test iniziano qui
		out.println("-----INIZIO TEST CONNETTORE FILE DELLE CARTE-----"); 

		//le mappe
		GraphicPapers cards = GraphicPapers.getInstance();
				
		List<String> paths = new ArrayList<>();
		
		//cattura posizioni
		for(int i = 0; i < GraphicPapers.CARD_TYPES; i++) {
			paths.add(cards.getRedMap().get(i).getAbsolutePath());
			paths.add(cards.getGreenMap().get(i).getAbsolutePath());
			paths.add(cards.getBlueMap().get(i).getAbsolutePath());
			paths.add(cards.getYellowMap().get(i).getAbsolutePath());
		}
		paths.add(cards.getJollyMap().get(13).getAbsolutePath());
		paths.add(cards.getJollyMap().get(14).getAbsolutePath());
		
		//stampa a video delle posizioni
		out.println();
		out.println("-----PERCORSI DEI FILE DELLE CARTE-----"); 
		paths.stream().forEach(System.out::println);
		
		//controllo numero file disco
		out.println();
		out.println("-----NUMERO DEI FILE DELLE CARTE-----"); 
		out.println("atteso: " + 54);
		out.println("trovate: " + paths.stream().count());
	
		
		//verifica riconoscimento su disco
		out.println();
		out.println("-----VERIFICA RICONOSCIMENTO SU DISCO-----");
		long result = paths.stream()
		.map(file -> new File(file))
		.map(file -> file.isFile())
		.filter(bool -> bool.equals(true))
		.count();
		out.println("file riconosciuti: " + result);
	}

}
