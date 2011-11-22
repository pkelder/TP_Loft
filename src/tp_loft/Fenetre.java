/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_loft;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author tagazok
 */
public class Fenetre extends JFrame {
    /* Attributes */

    /**
	 * 
	 */
	//je ne sais pas à quoi ça sert...
	private static final long serialVersionUID = 1L;
	
	private int largeurLoft;
    private int longueurLoft;
    private Loft loft;
    private JLabel[][] jLabelArray;

    public Fenetre(int largeur, int longueur, Loft loft) {
        this.largeurLoft = largeur;
        this.longueurLoft = longueur;
        this.loft = loft;
        this.jLabelArray = new JLabel[this.largeurLoft][this.longueurLoft];
    }

    public void createWindow() {
        // Titre de la fen√™tre
        this.setTitle("Loft Story by 3K, Siau, Loulou");
        // Taille de la fen√™tre en pixels
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // La fen√™tre contient une grille
        this.setLayout(new GridLayout(this.largeurLoft, this.longueurLoft));

        // Intanciation des JLabel et on les met dans la grille de la fen√™tre
        for (int i = 0; i < this.largeurLoft; i++) {
            for (int j = 0; j < this.longueurLoft; j++) {
                this.jLabelArray[i][j] = new JLabel();
                this.getContentPane().add(this.jLabelArray[i][j]);
            }
        }

        this.setVisible(true);
    }

    public void drawLoft() {
        Iterator<Neuneu> iterator;
        Neuneu currNeuneu;
        String label = new String();

        for (int i = 0; i < this.largeurLoft; i++) {
            for (int j = 0; j < this.longueurLoft; j++) {
            		
            	ArrayList<Neuneu> currentList=this.loft.getGrille()[i][j].getNeuneus();
            	if (currentList.isEmpty()){System.out.println("empty");}
            	else{System.out.println("not empty"+currentList.size());
            	
            	iterator = currentList.iterator();

                // On teste le type des Neuneu sur la case pour d√©terminer la lettre correspondante
                label = "";
                while (iterator.hasNext()) {
                    currNeuneu = iterator.next();
         
                    if (currNeuneu.getClass().equals(Erratique.class)) {
                        label += "I";
                    } else if (currNeuneu.getClass().equals(Lapin.class)) {
                        label += "L";
                    } else if (currNeuneu.getClass().equals(Vorace.class)) {
                        label += "V";
                    } else if (currNeuneu.getClass().equals(Cannibale.class)) {
                        label += "C";
                    }
                }
            	
                
                //on teste si de la bouffe est présente sur la case
                Nourriture currentNourriture=this.loft.getGrille()[i][j].getNourriture();
                if (currentNourriture==null){System.out.println("pas de bouffe");}
                else{
                	label +="B";
                }
                
          
                // On affiche le label sur la case
                //à ajouter: affichage des lignes, on ne différencie pas bien chaque case
                this.jLabelArray[i][j].setText(label);
                this.jLabelArray[i][j].repaint();
                
            	}
            	}
            	}
        
    }
}
