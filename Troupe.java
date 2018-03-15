import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Troupe {
	
	//Attributs
	private Case c = null;
	private Joueur j = null;
	private boolean gagnant;
	private Joueur appartenance;
	
	
	//Constructeur
	public Troupe(Case c, Joueur j){
		this.c=c;
		this.j=j;
		gagnant = false;

	}
	
	//METHODES 
	
	//getteurs
	public Case getCase(){
		return c;
	}
	
	public Joueur getJoueur(){
		return j;
	}
	
	public boolean getgagnant(){
		return gagnant;
	}
	
	//Description
	public String toString(){
		String message = "Troupe sur la case "+c.toString()+", appartenant a Joueur "+ j.getNom() + "" ;
		return message;
	}
	
	//setteurs
	public void setCase(Case c2) {
		c=c2 ;
	}
	
	public void setGagnant(boolean b) {
		gagnant = b ;
	}
	
	//méthode déplacer - déplace une troupe sur une case choisie
	public void deplacer(Case c2){
		if (c2.getAppartenance()==j) { 						//si la case appartient à joueur
			c=c2;
		} else {
			if (c2.getAppartenance()==null) { 				//si la case est neutre
				c=c2;
				c2.changerAppartenance(j) ;
			} else {										//la case appartient donc à l'ennemi
				if (c2.getNbTroupes()>0) {  				//s'il y a de troupes adversaires
					if (!gagnant) {							//si la troupe n'a pas encore battu un ennemi
						int nbTroupesSurC2= c2.getNbTroupes() ;
						c2.setNbTroupes(nbTroupesSurC2+2);	//ajout des troupes par défaut si c'est le perçage
					}
					c.combattre(c2) ;
				} else {
					if (gagnant) { 							//si la troupe a déjà battu un ennemi
						c=c2;
						c2.changerAppartenance(j) ;
					} else {								//si la troupe n'a pas encore battu un ennemi
						c2.setNbTroupes(2); 				//ajout des troupes par défaut si c'est le perçage
						c.combattre(c2) ;
					}
				}
			}
		}
	}
	
}





