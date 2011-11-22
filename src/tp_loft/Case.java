//CLASSE OK


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

class Case {

	/*** Attributes ***/

	protected int caseX;
	protected int caseY;
	protected ArrayList<Neuneu> neuneuSurCase;
	protected Nourriture bouffe;

	/*** Contructors ***/

	public Case(int x, int y) {
		this.caseX = x;
		this.caseY = y;
	}

	public Case() {

	}

	/*** Methods ***/

	public void ajoutNeuneu(Neuneu neuneu) {
		this.neuneuSurCase.add(neuneu);
		neuneu.positionX = this.caseX;
		neuneu.positionY = this.caseY;
	}

	public void ajoutBouffe(Nourriture bouffe) {
		if (this.bouffe != null) {
			// on teste si le type de nourriture est le même
			if (this.bouffe.type == bouffe.type) {
				// on rajoute de la nourriture
				this.bouffe.valeurEnergetique = this.bouffe.valeurEnergetique
						+ bouffe.valeurEnergetique;
			}
		} else {
			// s'il n'y a pas de bouffe sur la case, on en met
			this.bouffe = bouffe;
		}

	}

	public void supprimerNeuneu(Neuneu neuneu) {
		this.neuneuSurCase.remove(neuneu);
	}

	public void supprimerBouffe(Nourriture bouffe) {
		if (this.bouffe.type == bouffe.type) {
			this.bouffe = null;
		}

	}

	// public boolean estLibre() {}

	public boolean aUnNeuneu() {
		return this.neuneuSurCase.size() != 0;
	}

	public boolean contientBouffe() {
		return bouffe != null;
	}

	public void action() {
		for (Neuneu currentNeuneu : neuneuSurCase) {
			// Appelle les action de la liste de Neuneu. Gère les conflits
			currentNeuneu.action();
		}
	}

	/**** Getters ****/

	public int getCaseX() {
		return this.caseX;
	}

	public int getCaseY() {
		return this.caseY;
	}

}