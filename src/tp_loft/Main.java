/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
//import java.util.Timer;
import java.util.List;
import java.util.Properties;

import java.util.TimerTask;

/**
 * 
 * @author tagazok
 */

public final class Main {

	// protected String pathFichierConf;

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		// Appel getConf() et initialisation()

		getConf("./src/config.properties");
		final Loft loft = initialisation();
		final Fenetre window = new Fenetre(Loft.largeurLoftX, Loft.longueurLoftY,
				loft);
		window.createWindow();

		// Appel tour() 

		final Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				System.out.println("Nouveau tour");
				window.drawLoft();
				loft.tour();
				System.out.println("nombre de Neuneu restant: "+loft.getnbNeuneuTotal());
				if (loft.getnbNeuneuTotal()<2){
					timer.cancel();
				}
			}	
			
		},0, 1000);	
		
		
	}



	public static void getConf(String path) throws FileNotFoundException,
			IOException {

		// Va chercher les propriétés dans le fichier de conf
		// Mets les valeurs static dans les classes correspondantes

		Properties props = new Properties();
		props.load(new FileInputStream(path));

		// config du loft
		Loft.largeurLoftX = Integer.parseInt(props.getProperty("loft.largeur"));
		Loft.longueurLoftY = Integer.parseInt(props
				.getProperty("loft.longueur"));
		Loft.periodeTour = Integer.parseInt(props
				.getProperty("loft.periodeTour"));

		// config de Neuneu
		Neuneu.depenseMarcher = Integer.parseInt(props
				.getProperty("Neuneu.depenseMarcher"));
		Neuneu.depenseSexe = Integer.parseInt(props
				.getProperty("Neuneu.depenseSexe"));
		Neuneu.energieMax = Integer.parseInt(props
				.getProperty("Neuneu.energieMax"));

		// config de bouffeDispo dans loft
		List<String> type = Arrays.asList(props.getProperty("Nourriture.liste")
				.split(","));
		List<String> valeurEnergetique = Arrays.asList(props.getProperty(
				"Nourriture.valeurEnergetique").split(","));

		Loft.bouffeDispo = new ArrayList<Nourriture>();

		for (int i = 0; i < type.size(); i++) {
			String s = type.get(i);
			int v = Integer.parseInt(valeurEnergetique.get(i));
			Nourriture currentBouffe = new Nourriture(s, v);
			Loft.bouffeDispo.add(currentBouffe);
		}

	}

	public static Loft initialisation() {

		// Instantie un nouveau loft
		Loft loft = new Loft();

		// Place la bouffe et les neuneu de départ. Critère :
		// partie entière du 1/10 du nombre de cases
		// ajout de bouffe et de Neuneu al�atoirement
		// on commence par mettre 25 de chaque, on ajustera surement
		int nb = (Loft.largeurLoftX * Loft.longueurLoftY) / 10;

		for (int i = 0; i < nb; i++) {
			loft.ajoutBouffe();
			loft.ajoutNeuneu();
			loft.setnbNeuneuTotal(loft.getnbNeuneuTotal() + 1);
		}

		return loft;
	}


}
