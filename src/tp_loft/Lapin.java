/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;

/**
 * 
 * @author tagazok
 */
public class Lapin extends Neuneuphile {

	public Lapin(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature,
		// listeBouffe : Lire fichier conf
	}

	public Lapin() {
		super();
	}

	public Lapin(int x, int y) {
		super(x, y);
	}

	public void action() {
		// S'il est tout seul : il bouffe
		Case currentCase = loft.grille[this.getPosX()][this.getPosY()];
		if (!currentCase.fullNeuneu()) {
			if (currentCase.aNourriture())
				this.manger(currentCase.getNourriture());
		}

		// S'il est pas tout seul, il baise puis il bouffe
		else {
			if (currentCase.getNeuneus().get(0) != this) {
				this.copuler(currentCase.getNeuneus().get(0));
			} else {
				this.copuler(currentCase.getNeuneus().get(1));
			}
			if (!currentCase.fullNeuneu()) {
				if (currentCase.aNourriture())
					this.manger(currentCase.getNourriture());
			}

		}

	}
	
	
}
