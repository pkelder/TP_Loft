/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.tp_loft;

import java.util.*;



class Case {
	protected ArrayList<Neuneu> neuneuSurCase;
	protected Nourriture bouffe;
	
	public Case() {}
	
	public void ajouterContenu(Element element) {}
	public void supprimerContenu(Element element) {}
	public boolean estLibre() {
		return true;
	}
	public boolean aUnNeuneu() {
		return false;
	}
	public void action() {
		// Appelle les action de la liste de Neuneu. G�re les conflits
	}
}