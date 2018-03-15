import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Joueur {
	
	//Attributs
	private String nom;
	private Color couleur;
	private int nbCases;
	private double pourcentage;
	private int nbTroupes;
	private Capitale capitale;
	
	
	//Constructeur
	public Joueur(String n, Color c){
		nom = n;
		couleur = c;
		nbCases = 1;
		nbTroupes = 5;
	}
	
	//METHODES 
	
	//getteurs
	public String getNom(){
		return nom;
	}
	
	public double getPourcentage(){
		return pourcentage;
	}
	
	public int getNbCasePossede(){
		return nbCases;
	}
	
	public Color getCouleur(){
		return couleur;
	}
	
	public int getNbTroupes(){
		return nbTroupes;
	}
	
	public Capitale getCapitale(){
		return capitale;
	}
	
	//setteurs 
	public void setNbTroupes(int i){
		nbTroupes = i;
	}
	
	//Description
	public String toString(){
		String message = "Joueur de nom "+nom+", possedant "
		+nbTroupes+" troupes et de couleur "+couleur.toString()+".";
		return message;
	}
	
	//Méthodes pour le jeu
	
	public int lancerDe(){
		int de = (int)(6*Math.random()+1);
		return de;
	}	

}
