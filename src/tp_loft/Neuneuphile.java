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
public abstract class Neuneuphile extends Neuneu {

	public Neuneuphile(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature,
		// listeBouffe : Lire fichier conf
	}

	public Neuneuphile() {
		super();
	}

	public Neuneuphile(int x, int y,Loft loft) {
		super(x, y,loft);
	}

	public int[] determineCaseCible(Loft loft) {
		// Détermine case cible pour Lapin et Cannibale
		// Démarche : si il y a de la nourriture au plus près, va vers la
		// nourriture,
		// si il y a un Neuneu au plus près, va vers le Neuneu.

		ArrayList<Neuneu> listeNeuneu = loft.getListeNeuneu();
		// On choisit le neuneu le plus proche
		
		int Xfinal=this.getPosX();
		int Yfinal=this.getPosY();
		
		int currentmin = (int) this.calculDistance(this.getPosX(),
				this.getPosY(), listeNeuneu.get(0).getPosX(),  listeNeuneu.get(0).getPosY());
		int currentDistance = 0;

		for (Neuneu neuneu : listeNeuneu) {

			currentDistance = (int) this.calculDistance(this.getPosX(),
					this.getPosY(), neuneu.getPosX(), neuneu.getPosY());

			if (currentmin > currentDistance) {
				Xfinal=neuneu.getPosX();
				Yfinal=neuneu.getPosY();
				currentmin = currentDistance;
			}
		}

		// petite modification sur le principe: le Neuneuphile cible de la
		// nourriture uniquement si celle-ci se situe entre le
		// neuneu le plus proche et lui

		
		Case currentNourritureCible=new Case();
		int currentMin=currentmin;

		for (int i = Math.min(this.getPosX(), Xfinal); i < Math.max(
				this.getPosX(), Xfinal); i++) {
			for (int j = Math.min(this.getPosY(), Yfinal); j < Math.max(
					this.getPosY(), Yfinal); j++) {
				Case currentCase=loft.grille[i][j];
				if (currentCase.aNourriture()){
					
					currentDistance = (int) this.calculDistance(this.getPosX(),
							this.getPosY(), currentCase.getPosX(), currentCase.getPosY());
					if (currentDistance<currentMin){
						currentMin=currentDistance;
						currentNourritureCible=currentCase;
					}
				}
			}
		}

		
		if (currentMin<currentmin) {
			int[] coord=new int[2];
			coord[0]=currentNourritureCible.getPosX();coord[1]=currentNourritureCible.getPosY();
			this.cible=currentNourritureCible.getNourriture();
			return coord;
		}
		
		else{
			int[] coord=new int[2];
			coord[0]=Xfinal;coord[1]=Yfinal;
			this.cible=this.loft.grille[Xfinal][Yfinal].getNeuneus().get(0);
			return coord;
		}
		
	}

	
	
	public float calculDistance(int originX, int originY, int cibleX, int cibleY) {
		return (float) Math.sqrt((originY - cibleY) * (originY - cibleY)
				+ (originX - cibleX) * (originX - cibleX));
	}
}
