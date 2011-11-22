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
        // EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
    }
    
    public Vorace(){
    	super();
    }
    
    public Vorace(int x,int y){
    	super(x,y);
    }

    public int[] determineCaseCible(Loft loft) {
        // se dirige vers la cible qui est dans Neuneu. Cible = Nourriture
        return new int[1];
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
                                Vorace newVorace = new Vorace(this.getPosX(), this.getPosY());
                                currentCase.ajouterNeuneu(newVorace);
                                loft.ajoutListeNeuneu(newVorace);
                            }

                        }
                    }
                    
                    if (currentCase.aNourriture()){
    			this.manger(currentCase.getNourriture());
                        loft.supprimerBouffe(currentCase.getNourriture());
                    }

		}
    }
}
