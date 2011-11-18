/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.tp_loft;

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
    
    }
    
	public int[] determineCaseCible() {
        int[] toto = null;
        return toto;
    }
    
	public void marcher() {
		// Appelle determineCaserCible(), puis marcher(X, Y) avec la position déterminée
	}
}
