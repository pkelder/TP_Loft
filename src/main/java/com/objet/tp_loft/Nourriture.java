//CLASSE OK

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.tp_loft;



class Nourriture extends Element {
	/*** Attributes ***/

	protected String type;
	protected int valeurEnergetique;

	/*** Constructors ***/

	public Nourriture(String type, int valeurEnergetique) {
		this.type = type;
		this.valeurEnergetique = valeurEnergetique;

	}

	/*** Methods ***/

	public int consommation(int nourritureDemandee) {
		// Renvoie la quantitŽ de nourriture maxi possible
		int nourriturePossible = this.valeurEnergetique;
		if (nourriturePossible > nourritureDemandee)
			return nourritureDemandee;
		else
			return nourriturePossible;

	}

	/*** Getters ***/

	public String getType() {
		return this.type;
	}
}
