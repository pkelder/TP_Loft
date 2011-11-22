/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;

/**
 * 
 * @author tagazok
 */
public class Cannibale extends Neuneuphile {

	public Cannibale(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature,
		// listeBouffe : Lire fichier conf
	}

	public Cannibale() {
		super();
	}

	public Cannibale(int x, int y) {
		super(x, y);
	}

	public void action() {
		// Si tout seul : bouffe
		Case currentCase = loft.grille[this.getPosX()][this.getPosY()];
		if (!currentCase.fullNeuneu()) {
			if (currentCase.aNourriture())
				this.manger(currentCase.getNourriture());
		}

		// S'il est avec un Neuneu : bouffe le Neuneu

		else {
			if (currentCase.getNeuneus().get(0) != this) {
				this.manger(currentCase.getNeuneus().get(0));
			} else {
				this.manger(currentCase.getNeuneus().get(1));
			}

		}
	}
}
