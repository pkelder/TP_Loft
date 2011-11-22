//CLASSE OK


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author tagazok
 */
public class Erratique extends Neuneu {
    /*   Contructors   */
    public Erratique(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
	}
	
    
    /*   Methods   */
	public void action() {
		
Case currentCase=loft.grille[this.positionX][this.positionY];

		//on regarde d'abord s'il y a de la bouffe
		if ((currentCase.bouffe != null)&&(this.listeNourriture.contains(currentCase.bouffe))){
			this.manger(currentCase.bouffe);
		}
		
		//sinon, on cherche si un autre Neuneu est lˆ. Si oui, on copule
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
    
	public int[] determineCaseCible() {
		
		//on choisit ici une case au pif
		int longueur=(int)Math.random();
		int largeur=(int)Math.random();
		
		int[] cible=new int[2];
		cible[0]=longueur%loft.largeurLoftX;
		cible[1]=largeur%loft.longueurLoftY;
		return cible;
		
    
    }
    
}
