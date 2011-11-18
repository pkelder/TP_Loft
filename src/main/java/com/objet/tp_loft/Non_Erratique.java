//CLASSE OK



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.tp_loft;

import java.util.ArrayList;

/**
 * 
 * @author tagazok+ Loulou
 */
public abstract class Non_Erratique extends Neuneu {
	
	/*** Constructors ***/
	
	public Non_Erratique(Loft loft) {
		super(loft);
		// Energie = EnergieMax
		// EnergieMax, depenseMrcher, depenseSexe, Valeurenergetique, estMature,
		// listeBouffe : Lire fichier conf
	}

	public Non_Erratique(int EM, int DM, int DS, int VE, int eM, ArrayList<Nourriture> lB,Loft loft) {
		super(eM, eM, eM, eM, eM, lB,loft);

	}

	
	/*** Methods ***/
	
	abstract public int[] determineCaseCible();


}
