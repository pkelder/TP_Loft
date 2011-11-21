import java.util.*;

/**
 * @opt all
 */
class Main {
	protected String pathFichierConf;
	
	public static void main(String[] args) {
		// Appel getConf() et initialisation()
		// Appel tour() qu	and le timer le dit, et tant tour() renvoie true
	}
	public static void getConf(String category, String param) {
		// Va chercher les propriétés dans le fichier de conf
		// Mets les valeurs static dans les classes correspondantes
	}
	public static void initialisation() {
		// Instantie "new Case()" dans chaque case de "grille"
		// Place la bouffe et les neuneu de départ. Critère :
		//		partie entière du 1/4 du nombre de cases
	}
	
}

/**
 * @opt all
 * @has "" - "" Case
 * @has "" - "" Nourriture
 */
class Loft {
	protected Case[][] grille;
	protected static int largeurLoftX;
	protected static int longueurLoftY;
	protected ArrayList<Nourriture> bouffeDispo;
	protected static int periodeTour;  // Timer qui lance chaque tour
	protected int nbNeuneuTotal;
	
	public Loft() {
		// getConf() : longueur, largeur, listeBouffe, périodePrimeTime
	}
	
	public boolean tour() {
		// Un balayage de la grille pour marcher(), un autre pour action(), 
		// un autre pour nettoyer les trucs à zéro d'énergie
		// Random pour le nombre de bouffe et de neuneu à rajouter, et random de leur position
		// Retourne true si nbNeuneuTotal>1 ou false si nbNeuneuTotal<=1
	}
	public void ajoutBouffe() {
		// Choix quantité + type + random position
		// Vérifier case libre
		// utiliser ajoutElement()
	}
	public void ajoutElement(Element element, int posX, int posY) {}
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
	
	public void ajouterNeuneu(Neuneu neuneu) {}
	public void supprimerNeuneu(Neuneu neuneu) {}
	public void ajouterNourriture(Nourriture nourriture) {}
	public void supprimerNourriture(Nourriture nourriture) {}
	public boolean aNourriture() {}
	public boolean aNeuneu() {}
	public void action() {
		// Appelle les action de la liste de Neuneu.
		// S'il y a deux Neuneu : aléatoire pour déterminer lequel fait l'action
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
	
	public int consommation() {
		// Renvoie la quantité de nourriture maxi possible
		// puis met l'énergie à zéro
	}
	
	public int getEnergie() {}
	public void setEnergie() {}
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
	
	protected int sexe;
	protected int energie;
	protected static int depenseMarcher;
	protected static int depenseSexe;
	protected int estMature;							// Décrémente à chaque tour. Peut copuler à 0.
	protected static int energieMax;
	protected int posX;
	protected int posY;
	protected Element cible;
	protected ArrayList<Nourriture> listeNourriture;
	protected Loft loft;
	
	protected Neuneu(Loft loft) {
		// Appelle setNom()
		// Sexe aléatoire 
	}
	
	public void marcher() {
		// Décrémente estMature
		// Appelle DeterminerCible() pour avoir les coordonnées
		// Déplace le Neuneu vers les coordonnées, mais vérifie qu'il ne marche pas sur une case avec 2 Neuneu
		//		Si la case est pas dispo, prend une des deux cases à coté
		// Déplacement : S'enlever de la Case actuelle (celle des coordonnées en attribut du Neuneu)
		//				Se mettre dans la Case correspondant aux nouvelles coordonnées
		//				Mettre à jour les nouvelles coordonnées en attribut du Neuneu
	}
	public void manger(Element element) {
		// EnergieElementMangé=0
		// Test si Neuneu est mangé : énergieMangeur=max
		// Test si Nourriture : énergieMangeur<=max
	}
	public boolean copuler(Neuneu partenaire) {
		// Diminue l'énergie des partenaires.
		// true si sexe différent, flase si même sexe
	}
	public abstract void action();
	public abstract int[] determineCaseCible();
	public int getEnergie() {}
	public void setNom() {}
	public void setEnergie() {}
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
	
	public void action() {
		// S'il est tout seul : il bouffe
		// S'il est pas tout seul, il baise puis il bouffe
	}
	public int[] determineCaseCible() {}
}

/**
 * @opt all
 */
abstract class Neuneuphile extends Neuneu {
	
	public Neuneuphile(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
	}
	
	public int[] determineCaseCible() {
		// Détermine case cible pour Lapin et Cannibale
		// Démarche : si il y a de la nourriture au plus près, va vers la nourriture,
		// si il y a un Neuneu au plus près, va vers le Neuneu.
	}
}

/**
 * @opt all
 */
class Lapin extends Neuneuphile {
	public Lapin(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
	}
	
	public void action() {
		// S'il est tout seul : il bouffe
		// S'il est pas tout seul, il baise puis il bouffe
	}
}

/**
 * @opt all
 */
class Vorace extends Neuneu {
	public Vorace(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
	}
	
	public int[] determineCaseCible() {
		// se dirige vers la cible qui est dans Neuneu. Cible = Nourriture
	}
	public void action() {
		// S'il est tout seul : il bouffe
		// S'il est pas tout seul, il baise puis il bouffe
	}
}

/**
 * @opt all
 */
class Cannibale extends Neuneuphile {
	public Cannibale(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
	}
	
	public void action() {
		// Si tout seul : bouffe
		// S'il est avec un Neuneu : bouffe le Neuneu
	}
	
}
