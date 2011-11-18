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
	
	/*
	public boolean estLibre() {
		
	}
	*/
	
	public boolean aUnNeuneu(){
		return this.neuneuSurCase.size()!=0;
	}
	
	public boolean contientBouffe(){
		return bouffe!=null;
	}
	
	public void action() {
		for (Neuneu currentNeuneu : neuneuSurCase){
			currentNeuneu.action()
		}
		// Appelle les action de la liste de Neuneu. Gère les conflits
	}
}