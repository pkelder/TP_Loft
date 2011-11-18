/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.tp_loft;

class Cannibale extends Vorace {
	public Cannibale(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature, listeBouffe : Lire fichier conf
	}
	
	public void action() {
    
    }
    
	public int[] determineCaseCible() {
        int[] toto = null;
        return toto;
    }
}