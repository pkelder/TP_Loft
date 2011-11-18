/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.tp_loft;

import java.util.*;


abstract class Neuneu extends Element {
	public static int HOMME = 1;
	public static int FEMME = 0;
	
	protected String nom;
	protected int sexe;
	protected int energie;
	protected int depenseMarcher;
	protected int depenseSexe;
	protected int valeurEnergetique;
	protected int estMature;							// D�cr�mente � chaque tour. Peut copuler � 0.
	protected int energieMax;
	protected Element cible;
	protected ArrayList<Nourriture> listeNourriture;
	protected Loft loft;
	
	protected Neuneu(Loft loft) {
		// Appelle setNom()
		// Sexe al�atoire 
	}
	
	public void setNom() {}
	public void marcher(int caseCibleX, int caseCibleY) {}
	public void manger(Nourriture bouffe) {}
	public void copuler(Neuneu partenaire) {}
	public abstract void action();
	public abstract int[] determineCaseCible();
}
