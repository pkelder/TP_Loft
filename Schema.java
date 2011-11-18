import java.util.*;

/**
 * @opt all
 */
class Main {
	protected String pathFichierConf;
	
	public static void main(String[] args) {}
	public static Object getConf(String category, String param) {}
}

/**
 * @opt all
 * @has "" - "" Case
 * @has "" - "" Nourriture
 */
class Loft {
	protected Case[][] grille;
	protected int largeurLoftX;
	protected int longueurLoftY;
	protected ArrayList<Nourriture> bouffeDispo;
	protected int periodePrimeTime;
	protected int tempsJusquaPrimeTime;
	
	public Loft() {
		// getConf() : longueur, largeur, listeBouffe, périodePrimeTime
	}
	
	public void tour() {
		// Déplacement + Action + PrimeTime
	}
	public void ajoutBouffe() {
		// Choix quantité + type + random position
		// Vérifier case libre
		// utiliser ajoutElement()
	}
	public void ajoutElement(Element element, int posX, int posY) {}
	public void primeTime() {
		// Teste s'il y a primetime
		// Ajoute nourriture + neuneus
	}
}

/**
 * @opt all
 * @has "" - "" Neuneu
 * @has "" - "" Nourriture
 */
class Case {
	protected ArrayList<Neuneu> neuneuSurCase;
	protected Nourriture bouffe;
	
	public Case() {}
	
	public void ajouterContenu(Element element) {}
	public void supprimerContenu(Element element) {}
	public boolean estLibre() {}
	public boolean aUnNeuneu() {}
	public void action() {
		// Appelle les action de la liste de Neuneu. Gère les conflits
	}
}

/**
 * @opt all
 */
abstract class Element {
	protected String pathLogo;
	
	protected Element() {
		// Lire pathLogo fichier conf
	}
}

/**
 * @opt all
 */
class Nourriture extends Element {
	protected String type;
	protected int valeurEnergetique;
	
	public Nourriture(String type, int valeurEnergetique) {}
	
	public int consommation(int nourritureDemandee) {
		// Renvoie la quantité de nourriture maxi possible
	}
}

/**
 * @opt all
 * @has "" - "" Loft
 * @has "" - "" Nourriture
 * @has "" - "" Element
 */
abstract class Neuneu extends Element {
	public static int HOMME = 1;
	public static int FEMME = 0;
	
	protected String nom;
	protected int sexe;
	protected int energie;
	protected int depenseMarcher;
	protected int depenseSexe;
	protected int valeurEnergetique;
	protected int estMature;							// Décrémente à chaque tour. Peut copuler à 0.
	protected int energieMax;
	protected Element cible;
	protected ArrayList<Nourriture> listeNourriture;
	protected Loft loft;
	
	protected Neuneu(Loft loft) {
		// Appelle setNom()
		// Sexe aléatoire 
	}
	
	public void setNom() {}
	public void marcher(int caseCibleX, int caseCibleY) {}
	public void manger(Nourriture bouffe) {}
	public void copuler(Neuneu partenaire) {}
	public abstract void action() {}
	public abstract int[] determineCaseCible() {}
}

/**
 * @opt all
 */
class Erratique extends Neuneu {
	public Erratique(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
	}
	
	public void action() {}
	public int[] determineCaseCible() {}
	public void marcher() {
		// Appelle determineCaserCible(), puis marcher(X, Y) avec la position déterminée
	}
}

/**
 * @opt all
 */
abstract class Non_Erratique extends Neuneu {
	public int[] determineCaseCible() {}
	
	public Non_Erratique(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
	}
	
	public void marcher() {
		// Appelle determineCaserCible(), puis marcher(X, Y) avec la position déterminée
	}
}

/**
 * @opt all
 */
class Lapin extends Non_Erratique {
	public Lapin(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
	}
	
	public void action() {}
}

/**
 * @opt all
 */
class Vorace extends Non_Erratique {
	public Vorace(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
	}
	
	public void action() {}
}

/**
 * @opt all
 */
class Cannibale extends Vorace {
	public Cannibale(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
	}
	
	public void action() {}
	public int[] determineCaseCible() {}
}
