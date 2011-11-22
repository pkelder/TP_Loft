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

    public void action() {
        // S'il est tout seul : il bouffe
        // S'il est pas tout seul, il baise puis il bouffe
    }
}
