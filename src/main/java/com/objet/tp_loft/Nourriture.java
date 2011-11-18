/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.tp_loft;

class Nourriture extends Element {
	protected String type;
	protected int valeurEnergetique;
	
	
	public Nourriture(String type, int valeurEnergetique) {
		this.type=type;
		this.valeurEnergetique=valeurEnergetique;
		
	}
	
	public int consommation(int nourritureDemandee) {
		// Renvoie la quantit� de nourriture maxi possible
		int nourriturePossible=this.valeurEnergetique;
		if (nourriturePossible>nourritureDemandee)
			return nourritureDemandee;
		else
			return nourriturePossible;
		
	}
}
