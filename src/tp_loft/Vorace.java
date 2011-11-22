/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;


/**
 * 
 * @author tagazok
 */
public class Vorace extends Neuneu {

	public Vorace(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature,
		// listeBouffe : Lire fichier conf
	}

	public Vorace() {
		super();
	}

	public Vorace(int x, int y) {
		super(x, y);
	}

	public int[] determineCaseCible(Loft loft) {

		// se dirige vers la cible qui est dans Neuneu. Cible = Nourriture

		Case currentCaseCible = new Case(0, 0);
		int currentMin = (int) this.calculDistance(this.getPosX(),
				this.getPosY(), currentCaseCible.getPosX(),
				currentCaseCible.getPosY());
		int currentDistance = 0;

		for (int i = 0; i < Loft.largeurLoftX; i++) {
			for (int j = 0; j < Loft.longueurLoftY; j++) {

				Case currentCase = loft.grille[i][j];
				if (currentCase.aNourriture()) {

					currentDistance = (int) this.calculDistance(this.getPosX(),
							this.getPosY(), currentCase.getPosX(),
							currentCase.getPosY());

					if (currentDistance < currentMin) {
						currentMin = currentDistance;
						currentCaseCible = currentCase;
					}
				}
			}
		}

		int[] coord = new int[2];
		coord[0] = currentCaseCible.getPosX();
		coord[1] = currentCaseCible.getPosY();
		this.cible = currentCaseCible.getNourriture();
		return coord;

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
