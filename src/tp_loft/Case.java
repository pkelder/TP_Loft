/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;

import java.util.ArrayList;

/**
 *
 * @author tagazok
 */
public class Case {

    protected ArrayList<Neuneu> neuneuSurCase;
    protected Nourriture bouffe;
    protected int X;
    protected int Y;

    public Case() {
    }

    public void ajouterNeuneu(Neuneu neuneu) {
        if (this.neuneuSurCase.size()<2){
            this.neuneuSurCase.add(neuneu);
        }
    }

    public void supprimerNeuneu(Neuneu neuneu) {
        this.neuneuSurCase.remove(neuneu);
    }

    public void ajouterNourriture(Nourriture nourriture) {
        if (this.bouffe == null) this.bouffe = nourriture;
    }

    public void supprimerNourriture() {
        this.bouffe = null;
    }

    public boolean aNourriture() {
        return this.bouffe!=null ;
    }

    public boolean aNeuneu() {
        return !this.neuneuSurCase.isEmpty() ;
    }

    public void action() {
        // Appelle les action de la liste de Neuneu.
        // S'il y a deux Neuneu : aléatoire pour déterminer lequel fait l'action
        if (this.aNeuneu()){
            
            if (this.neuneuSurCase.size()==2){
                int random = (int) (Math.random()*2);
                this.neuneuSurCase.get(random).action();
            }else{
                this.neuneuSurCase.get(1).action();
            }
        
        }   
    }
}
