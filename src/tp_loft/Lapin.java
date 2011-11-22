// CLASSE OK

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

class Lapin extends Non_Erratique {
	public Lapin(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
	}
	
	public void action() {
		
		Case currentCase=loft.grille[this.positionX][this.positionY];
		//on regarde d'abord si un autre Neuneu est là. Si oui, on copule
		if (this.estMature == 0){
			if (currentCase.neuneuSurCase.size()>1){
				int i=0;
				while (currentCase.neuneuSurCase.get(i).nom == this.nom){
					i=i+1;
				}
				Neuneu partenaire=currentCase.neuneuSurCase.get(i);
				this.copuler(partenaire);
			}
		}
		
		//sinon, on cherche s'il y a de la bouffe
		if ((currentCase.bouffe != null)&&(this.listeNourriture.contains(currentCase.bouffe))){
			this.manger(currentCase.bouffe);
		}
		
		//s'il n'y a rien, on ne fait rien
	}
	
	
	
public int[] determineCaseCible(Loft loft) {

		// la solution proposée ici n'est pas optimale.
		ArrayList<Neuneu> listeNeuneu = null;

		for (int i=0;i<loft.largeurLoftX;i++){
			
			for (int j=0;j<loft.longueurLoftY;j++){
				
		Case currentCase=loft.grille[i][j];
		
			if (currentCase.neuneuSurCase.size() != 0) {
				for (Neuneu currentNeuneu : currentCase.neuneuSurCase) {
					listeNeuneu.add(currentNeuneu);
				}
			}
		}
		}

		// on a maintenant la liste de tous les neuneux du plateau. On va
		// maintenant calculer les distances au neuneu de départ et choisir la
		// plus petite
		ArrayList<Integer> distances=null;
		int currentmin = 0;
		for (Neuneu neuneu : listeNeuneu) {
			int currentDistance = (int) Math.sqrt((this.positionX - neuneu.positionX) * 2
							+ (this.positionY - neuneu.positionY) * 2);
			currentmin = Math.max(currentmin, currentDistance);
			distances.add(currentDistance);
		}
		int indexmin = distances.indexOf(currentmin);
		Neuneu neuneuCible = listeNeuneu.get(indexmin);

		int[] liste=new int[2];
		liste[0]=neuneuCible.getPositionX();
		liste[1]=neuneuCible.getPositionY();
		return liste;

	}
	
	
}