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
    
    public Erratique(int x,int y,Loft loft){
    	super(x,y,loft);
    }

    @Override
    public void action() {
    	
    	
    	Case position=loft.grille[this.getPosX()][this.getPosY()];
    	
    	if (!position.aNeuneu()){
        // S'il est tout seul : il bouffe
    		if (position.aNourriture()){
    			this.manger(position.getNourriture());
                        loft.supprimerBouffe(position.getNourriture());
    		}
    	}
    	else{
    	// S'il est pas tout seul, il baise puis il bouffe
            
            for (Neuneu neuneu : position.getNeuneus()){
                if (this != neuneu){
                    //On vérifie que les deux neuneus sont de sexe différent
                    boolean bebe = this.copuler(neuneu);
                    
                    if (bebe){
                        //On créée un nouveau neuneu du même type que son parent actif
                        //On le rajoute dans la case et dans le loft
                        Erratique newErratique = new Erratique(this.getPosX(), this.getPosY(),loft);
			position.ajouterNeuneu(newErratique);
                        loft.ajoutListeNeuneu(newErratique);
                    }
                   
                }
            }
            
            if (position.aNourriture()){
    			this.manger(position.getNourriture());
                        loft.supprimerBouffe(position.getNourriture());
            }
        }
    	
    }

    @Override
    public int[] determineCaseCible(Loft loft) {
        
        int coord[] = new int[2];
        //Choix d'une case au hasard
        coord[1] = (int) (Math.random() * Loft.largeurLoftX);
        coord[2] = (int) (Math.random() * Loft.longueurLoftY);
        
        return coord;
    }
}
