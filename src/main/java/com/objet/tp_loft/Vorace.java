/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.tp_loft;

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
		
		int[] liste=this.determineCaseCible(loft);
		//lancer l'action marcher
		
		this.marcher(liste[0], liste[1]);
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
		ArrayList<Integer> distances;
		int currentmin = 0;
		for (Neuneu neuneu : listeNeuneu) {
			int currentDistance = (int) Math
					.sqrt((this.positionX - neuneu.positionX) * 2
							+ (this.positionY - neuneu.positionY) * 2);
			currentmin = Math.max(currentmin, currentDistance);
			distances.add(currentDistance);
		}
		int indexmin = distances.indexOf(currentmin);
		Neuneu neuneuCible = listeNeuneu.get(indexmin);

		int[] liste;
		liste[0]=neuneuCible.getPositionX();
		liste[1]=neuneuCible.getPositionY();
		return liste;

	}

}
