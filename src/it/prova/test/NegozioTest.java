package it.prova.test;

import it.prova.dao.ArticoloDAO;
import it.prova.dao.NegozioDAO;
import it.prova.model.Articolo;
import it.prova.model.Negozio;

public class NegozioTest {

	public static void main(String[] args) {
		NegozioDAO negozioDAOInstance = new NegozioDAO();
		ArticoloDAO articoloDAOInstance = new ArticoloDAO();
		
		System.out.println("Negozi sul db:");
		for (Negozio negozioItel : negozioDAOInstance.list()) {
			System.out.println(negozioItel);
		}
		
		//provo una insert di negozio
		negozioDAOInstance.insert(new Negozio("Negozio1","via dei mille 14"));
		
		System.out.println("cerco un negozio con id 1");
		Negozio negozioConIdCheDicoIo = negozioDAOInstance.selectById(1L);
		System.out.println(negozioConIdCheDicoIo);
		
		//inserisco un articolo
		articoloDAOInstance.insert(new Articolo("articolo1", "matricola1", negozioConIdCheDicoIo));
		
		System.out.println("Articoli presenti sul db:");
		for (Articolo articoloItem : articoloDAOInstance.list()) {
			System.out.println(articoloItem);
		}
		
		System.out.println("cerco articolo con id 1");
		Articolo articoloInstance = articoloDAOInstance.selectById(1L);
		if(articoloInstance != null)
			System.out.println("trovato articolo con id 1: "+articoloInstance);
		
		/*
		 * se io voglio caricare un negozio e contestualmente anche i suoi articoli
		 * dovrò sfruttare il populateArticoli presente dentro negoziodao. Per esempio
		 * Negozio negozioCaricatoDalDb = negozioDAOInstance.selectById...
		 * 
		 * negozioDAOInstance.populateArticoli(negozioCaricatoDalDb);
		 * 
		 * e da qui in poi il negozioCaricatoDalDb.getArticoli() non deve essere più a size=0 (se ha articoli ovviamente)
		 * LAZY FETCHING (poi ve lo spiego)
		 */

	}

}
