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
import java.util.List;
import java.util.Properties;
import java.util.TimerTask;

/**
 * 
 * @author tagazok
 */
<<<<<<< HEAD

public class Main {

	protected String pathFichierConf;

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		// Appel getConf() et initialisation()
		getConf("./src/config.properties");
		final Loft loft = initialisation();
		
		// Appel tour() qu and le timer le dit, et tant tour() renvoie true
		
		// Partie Timer � revoir pour la suite
		/*
		 * Timer timer=new Timer(); while(loft.getnbNeuneuTotal()>1){
		 * 
		 * timer.schedule(new TimerTask() { public void run() { loft.tour(); }
		 * }, (long)1000);
		 * 
		 * }
		 */

		int i = 0;
		while ((i < 25) && (loft.getnbNeuneuTotal() > 1)) {
			loft.tour();
			i++;

		}

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
		// partie entière du 1/4 du nombre de cases
		// ajout de bouffe et de Neuneu al�atoirement
		// on commence par mettre 25 de chaque, on ajustera surement
		int nb = (Loft.largeurLoftX * Loft.longueurLoftY) / 4;

		for (int i = 0; i < nb; i++) {
			loft.ajoutBouffe();
			loft.ajoutNeuneu();
		}

		return loft;
	}
=======
public class Main {

    protected String pathFichierConf;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Appel getConf() et initialisation()
        getConf("./src/config.properties");
        initialisation();
        // Appel tour() qu	and le timer le dit, et tant tour() renvoie true
        //	getConf("loft.largeur","Loft.largeurloftX");
    }

    public static void getConf(String path) throws FileNotFoundException, IOException {

        // Va chercher les propriétés dans le fichier de conf
        // Mets les valeurs static dans les classes correspondantes

        Properties props = new Properties();
        props.load(new FileInputStream(path));

        //config du loft
        Loft.largeurLoftX = Integer.parseInt(props.getProperty("loft.largeur"));
        Loft.longueurLoftY = Integer.parseInt(props.getProperty("loft.longueur"));
        Loft.periodeTour = Integer.parseInt(props.getProperty("loft.periodeTour"));

        //config de Neuneu
        Neuneu.depenseMarcher = Integer.parseInt(props.getProperty("Neuneu.depenseMarcher"));
        Neuneu.depenseSexe = Integer.parseInt(props.getProperty("Neuneu.depenseSexe"));
        Neuneu.energieMax = Integer.parseInt(props.getProperty("Neuneu.energieMax"));

        //config de bouffeDispo dans loft
        List<String> type = Arrays.asList(props.getProperty("Nourriture.liste").split(","));
        List<String> valeurEnergetique = Arrays.asList(props.getProperty("Nourriture.valeurEnergetique").split(","));

        Loft.bouffeDispo = new ArrayList<Nourriture>();

        for (int i = 0; i < type.size(); i++) {
            String s = type.get(i);
            int v = Integer.parseInt(valeurEnergetique.get(i));
            Nourriture currentBouffe = new Nourriture(s, v);
            System.out.println("s:" + s + " v: " + v);
            Loft.bouffeDispo.add(currentBouffe);
        }


    }

    public static void initialisation() {


        // Instantie "new Case()" dans chaque case de "grille"
        for (int i = 0; i < Loft.largeurLoftX; i++) {
            for (int j = 0; j < Loft.longueurLoftY; j++) {
                Case currentCase = new Case();
            }
        }

        // Place la bouffe et les neuneu de départ. Critère :
        //		partie entière du 1/4 du nombre de cases
    }
>>>>>>> ebec8654c7c1b1dd4649e05b68fc2bc040df36e5
}
