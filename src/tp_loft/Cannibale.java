
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;

class Cannibale extends Vorace {
	public Cannibale(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature,
		// listeBouffe : Lire fichier conf
	}

	public Cannibale(int EM, int DM, int DS, int VE, int eM,
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
		ArrayList<Neuneu> listeNeuneu = new ArrayList<Neuneu>();
		ArrayList<Case> listeCase = new ArrayList<Case>();
		ArrayList<Integer> distanceBouffe = new ArrayList<Integer>();
		int currentminBouffe = 0;

		for (int i = 0; i < loft.largeurLoftX; i++) {

			for (int j = 0; j < loft.longueurLoftY; j++) {

				Case currentCase = loft.grille[i][j];

				if (currentCase.bouffe != null) {

					listeCase.add(currentCase);
					// on ajouter la distance au Neuneu à la ArrayListe distance

					int currentDistanceBouffe = (int) Math
							.sqrt((this.positionX - i) * 2
									+ (this.positionY - j) * 2);
					currentminBouffe = Math.max(currentminBouffe,
							currentDistanceBouffe);
					distanceBouffe.add(currentDistanceBouffe);
				}

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

		ArrayList<Integer> distanceNeuneu = new ArrayList<Integer>();
		int currentminNeuneu = 0;
		for (Neuneu neuneu : listeNeuneu) {
			int currentDistance = (int) Math
					.sqrt((this.positionX - neuneu.positionX) * 2
							+ (this.positionY - neuneu.positionY) * 2);
			currentminNeuneu = Math.max(currentminNeuneu, currentDistance);
			distanceNeuneu.add(currentDistance);
		}

		// on a la liste de toutes les cases contenant de la bouffe ou des
		// lapins sur le plateau, ainsi que leur distance au Neuneu
		// On choisit la plus petite
		Case caseCible = new Case();

		if (currentminBouffe <= currentminNeuneu) {

			int indexmin = distanceBouffe.indexOf(currentminBouffe);
			caseCible = listeCase.get(indexmin);
		}

		else {
			int indexmin = listeNeuneu.indexOf(currentminNeuneu);
			caseCible = listeCase.get(indexmin);
		}

		int[] cible=new int[2];
		cible[0]=caseCible.caseX;
		cible[1]=caseCible.caseY;
		return cible;
		
	}
}