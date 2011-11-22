/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;

/**
 *
 * @author tagazok
 */
public class Erratique extends Neuneu {

    public Erratique(Loft loft) {
        super(loft);
        // Energie = EnergieMax
        // EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
    }
    
    public Erratique(){
    	super();
    }
    
    public Erratique(int x,int y){
    	super(x,y);
    }

    public void action() {
    	
    	
    	Case position=loft.grille[this.getPosX()][this.getPosY()];
    	
    	if (!position.aNeuneu()){
        // S'il est tout seul : il bouffe
    		if (position.aNourriture()){
    			this.manger(position.getNourriture());
    		}
    	}
    	else{
    		
    		
        // S'il est pas tout seul, il baise puis il bouffe
    }
    	
    }

    public int[] determineCaseCible(Loft loft) {
        return new int[1];
    }
}
