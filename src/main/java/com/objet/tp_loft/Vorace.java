/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.tp_loft;

//CLASSE OK


import java.util.*;

class Vorace extends Non_Erratique {

	public Vorace(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature,
		// listeBouffe : Lire fichier conf
	}

	public Vorace(int EM, int DM, int DS, int VE, int eM,
			ArrayList<Nourriture> lB, Loft loft) {
		super(eM, eM, eM, eM, eM, lB, loft);
	}

	public void action() {
		
		Case currentCase=loft.grille[this.positionX][this.positionY];
		
		//on regarde d'abord s'il y a de la bouffe
		if ((currentCase.bouffe != null)&&(this.listeNourriture.contains(currentCase.bouffe))){
			this.manger(currentCase.bouffe);
		}
		
		//sinon, on cherche si un autre Neuneu est là. Si oui, on copule
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
		
		//s'il n'y a rien, on ne fait rien
	}

	
	
	public int[] determineCaseCible(Loft loft) {

		// la solution proposée ici n'est pas optimale.
		
		ArrayList<Case> listeCase = null;
		ArrayList<Integer> distances;
		int currentmin = 0;
		
		for (int i=0;i<loft.largeurLoftX;i++){
			
			for (int j=0;j<loft.longueurLoftY;j++){
				
		Case currentCase=loft.grille[i][j];
		
			if (currentCase.bouffe != null) {
				
					listeCase.add(currentCase);
					//on ajouter la distance au Neuneu à la ArrayListe distance
					
					int currentDistance = (int) Math.sqrt((this.positionX - i) * 2
									+ (this.positionY - j) * 2);
					currentmin = Math.max(currentmin, currentDistance);
					distances.add(currentDistance);
				}
			}
		}
		

		// on a  la liste de toutes les cases contenant de la bouffe sur le plateau, ainsi que leur distance au Neuneu
		// On choisit la plus petite
		
		int indexmin = distances.indexOf(currentmin);
		Case caseCible = listeCase.get(indexmin);

		int[] cible=new int[2];
		cible[0]=caseCible.CaseX;
		cible[1]=caseCible.CaseY;
		return cible;
		
	}


}
