/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objet.tp_loft;

/**
 *
 * @author tagazok
 */
public class Loft {
    /*   Attributes   */
    protected Case[][] grille;
	protected int largeurLoftX;
	protected int longueurLoftY;
	protected ArrayList<Nourriture> bouffeDispo;
	protected int periodePrimeTime;
	protected int tempsJusquaPrimeTime;
	
    
    /*   Constructors  */
	public Loft() {
		// getConf() : longueur, largeur, listeBouffe, périodePrimeTime
	}
	
	public loft (int largeur,int longueur){
		this.largeurLoftX=largeur;
		this.longueurLoftY=longueur;
		for (int i=0;i<largeur;i++){
			for (int j=0;j<longueur;j++){
		this.grille[i][j]=new Case();
			}
			}
	}
	
    
    /*   Methods   */
	public void tour() {
		// Déplacement + Action + PrimeTime
	}
    
	public void ajoutBouffe(Nourriture bouffe, int posX, int posY) {
		// Choix quantité + type + random position
		// Vérifier case libre
		//test si bouffe
		Case currentCase=this.grille[posX][posY];
		if (currentCase.bouffe != null)
				{
					//on teste si le type de nourriture est le m�me
					if (bouffe.type=currentCase.bouffe.type){
						//on rajoute de la nourriture
						currentCase.bouffe.valeurEnergetique=currentCase.bouffe.valeurEnergetique+bouffe.valeurEnergetique;
					}
				}
		//s'il n'y a pas de bouffe sur la case, on en met
		currentCase.bouffe=bouffe;
	}
    
	
	public void ajoutNeuneu(Neuneu neuneu, int posX, int posY) {
		Case currentCase=this.grille[posX][posY];
		currentCase.neuneuSurCase.add(neuneu);
		neuneu.positionX=posX;
		neuneu.positionY=posY;
    }
    
	public void primeTime() {
		// Teste s'il y a primetime
		// Ajoute nourriture + neuneus
	}
}
