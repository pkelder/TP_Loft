/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;

import java.util.ArrayList;

/**
 * 
 * @author tagazok
 */
public class Loft {

	protected Case[][] grille;
	protected static int largeurLoftX;
	protected static int longueurLoftY;
	protected static ArrayList<Nourriture> bouffeDispo;
	protected static int periodeTour; // Timer qui lance chaque tour, en ms
	protected int nbNeuneuTotal;
	protected ArrayList<Neuneu> listeNeuneu;
	protected ArrayList<Nourriture> listeNourriture;

	public Loft() {
		this.grille = new Case[Loft.largeurLoftX][Loft.longueurLoftY];
		this.listeNeuneu = new ArrayList<Neuneu>();
		this.listeNourriture=new ArrayList<Nourriture>();

		for (int i = 0; i < Loft.largeurLoftX; i++) {
			for (int j = 0; j < Loft.longueurLoftY; j++) {
				this.grille[i][j] = new Case(i, j);
			}
		}

	}

	public void tour() {

		// Un balayage de la grille pour marcher()

		
					for (Neuneu neuneu : this.listeNeuneu) {
						neuneu.marcher();
					}
			

		// un autre balayage pour action(),
		for (int i = 0; i < Loft.largeurLoftX; i++) {
			for (int j = 0; j < Loft.longueurLoftY; j++) {
				Case currentCase = this.grille[i][j];
				currentCase.action();
			}
		}

		// un autre pour nettoyer les neuneus à zéro d'énergie et la bouffe à 0 également
		for (int i = 0; i < Loft.largeurLoftX; i++) {
			for (int j = 0; j < Loft.longueurLoftY; j++) {
				Case currentCase = this.grille[i][j];

				if (currentCase.aNeuneu()) {
					for (Neuneu neuneu : currentCase.getNeuneus()) {
						if (neuneu.getEnergie() == 0)
							this.supprimerNeuneu(neuneu);
                                                
					}
				}
                                
                                if (currentCase.aNourriture()) {
                                        if (currentCase.bouffe.getEnergie() == 0){
                                            currentCase.supprimerNourriture();
                                            this.listeNourriture.remove(currentCase.bouffe);
                                        }
                                }

			}
		}

		// Random pour le nombre de bouffe et de neuneu à rajouter

		int nbBouffe = (int) (Math.random() * 5);
		int nbNeuneu = (int) (Math.random() * 2);

		for (int i = 0; i < nbBouffe; i++) {
			this.ajoutBouffe();
		}

		if (nbNeuneu == 1)
			this.ajoutNeuneu();

	}

	public void ajoutBouffe() {
		// random type
		int typeRandom = (int) (Math.random() * Loft.bouffeDispo.size());
		Nourriture Bouffe = Loft.bouffeDispo.get(typeRandom);

		// random position + vérifier case libre
		boolean libre = false;
		int x = 0;
		int y = 0;

		while (!libre) {

			x = (int) (Math.random() * Loft.largeurLoftX);
			y = (int) (Math.random() * Loft.longueurLoftY);

			if (!this.grille[x][y].aNourriture())
				libre = true;

		}

		// ajouter Bouffe dans la case sélectionnée
		this.grille[x][y].ajouterNourriture(Bouffe);
		this.listeNourriture.add(Bouffe);

	}

	public void ajoutNeuneu() {
		// Choix du type de neuneu au hasard + random position
		int n = (int) (Math.random() * 4);

		// random position + vérifier case libre
		boolean libre = false;
		int x = 0;
		int y = 0;

		while (!libre) {

			x = (int) (Math.random() * Loft.largeurLoftX);
			y = (int) (Math.random() * Loft.longueurLoftY);

			if (!this.grille[x][y].aNeuneu())
				libre = true;

		}

		switch (n) {
		case 1:
			n = 0;
			Erratique newErratique = new Erratique(x, y,this);
			newErratique.setPosX(x);
			newErratique.setPosY(y);
			this.grille[x][y].ajouterNeuneu(newErratique);
			this.listeNeuneu.add(newErratique);
			break;

		case 2:
			n = 1;
			Vorace newVorace = new Vorace(x, y,this);
			this.grille[x][y].ajouterNeuneu(newVorace);
			this.listeNeuneu.add(newVorace);
			break;

		case 3:
			n = 2;
			Lapin newLapin = new Lapin(x, y,this);
			this.grille[x][y].ajouterNeuneu(newLapin);
			this.listeNeuneu.add(newLapin);
			break;

		case 4:
			n = 3;
			Cannibale newCannibale = new Cannibale(x, y,this);
			this.grille[x][y].ajouterNeuneu(newCannibale);
			this.listeNeuneu.add(newCannibale);
			break;
		}

	}
	
	public void supprimerBouffe(Nourriture n){
		n.setEnergie(0);
		this.listeNourriture.remove(n);
	}
	
	public void supprimerNeuneu(Neuneu neuneu){
		Case caseN=this.grille[neuneu.getPosX()][neuneu.getPosY()];
		caseN.supprimerNeuneu(neuneu);
		this.listeNeuneu.remove(neuneu);
	}

	public int getnbNeuneuTotal() {
		return this.nbNeuneuTotal;
	}

	public void setnbNeuneuTotal(int i) {
		this.nbNeuneuTotal = i;
	}

	public Case[][] getGrille() {
		return this.grille;
	}

	public ArrayList<Neuneu> getListeNeuneu() {
		return this.listeNeuneu;
	}
        
        public void ajoutListeNeuneu(Neuneu neuneu){
                this.listeNeuneu.add(neuneu);
        }
	
	public ArrayList<Nourriture> getListeNourriture() {
		return this.listeNourriture;
	}
        
        
}
