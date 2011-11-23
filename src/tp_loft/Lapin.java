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

	public Lapin(int x, int y,Loft loft) {
		super(x, y,loft);
	}

    @Override
	public void action() {
		// S'il est tout seul : il bouffe
		Case currentCase = loft.grille[this.getPosX()][this.getPosY()];
		if (!currentCase.fullNeuneu()) {
			if (currentCase.aNourriture())
				this.manger(currentCase.getNourriture());
		}

		// S'il est pas tout seul, il baise puis il bouffe
		else {
			// S'il est pas tout seul, il baise puis il bouffe
                    for (Neuneu neuneu : currentCase.getNeuneus()){
                        if (this != neuneu){
                            //On vérifie que les deux neuneus sont de sexe différent
                            boolean bebe = this.copuler(neuneu);

                            if (bebe){
                                //On créée un nouveau neuneu du même type que son parent actif
                                //On le rajoute dans la case et dans le loft
                                Lapin newLapin = new Lapin(this.getPosX(), this.getPosY(),loft);
                                currentCase.ajouterNeuneu(newLapin);
                                loft.ajoutListeNeuneu(newLapin);
                            }

                        }
                    }
                    
                    if (currentCase.aNourriture()){
    			this.manger(currentCase.getNourriture());
    			currentCase.getNourriture().setEnergie(0);
                       
                    }

		}

	}
	
	
}
