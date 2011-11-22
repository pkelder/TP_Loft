/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;

/**
 *
 * @author tagazok
 */
public class Cannibale extends Neuneuphile {

    public Cannibale(Loft loft) {
        super(loft);
        // Energie = EnergieMax
        // EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
    }
    
    public Cannibale(){
    	super();
    }
    
    public Cannibale(int x,int y){
    	super(x,y);
    }

    @Override
    public void action() {
        // Si tout seul : bouffe
        // S'il est avec un Neuneu : bouffe le Neuneu
        
        Case position=loft.grille[this.getPosX()][this.getPosY()];
    	
    	if (!position.aNeuneu()){
        // S'il est tout seul : il bouffe
    		if (position.aNourriture()){
    			this.manger(position.getNourriture());
                        loft.supprimerBouffe(position.getNourriture());
    		}
    	}
    	else{
    	// S'il est pas tout seul, il bouffe le neuneu
            
            for (Neuneu neuneu : position.getNeuneus()){
                if (this != neuneu){
                    
                    this.manger(neuneu);
                    loft.supprimerNeuneu(neuneu);
                   
                }
            }
            
            
        }
        
    }
}
