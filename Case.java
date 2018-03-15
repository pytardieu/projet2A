import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Case {
	
	//Attributs
	private int x;
	private int y;
	private int occupe;
	private Joueur appartenance;
	
	
	//Constructeur
	public Case(int x, int y){
		this.x=x;
		this.y=y;
		occupe = 0;
		appartenance = null;
	}
	
	//METHODES 
	
	//getteurs
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getNbTroupes(){
		return occupe;
	}
	
	public Joueur getAppartenance(){
		return appartenance;
	}
	
	//Description
	public String toString(){
		String message = " Case de position ("+x+";"+y+") et de Joueur "+
		appartenance.getNom() +". "+this.getNbTroupes()+" se trouvent sur la case";
		return message ;
	}
	 
	//setteurs 
	public void changerAppartenance(Joueur j2){
		 this.appartenance=j2 ; 
	}
	 
	public void setNbTroupes(int i) {
		 occupe = i ;
	}
	
	//perdre une troupe pendant le combat
	public void perdreTroupe() {
		  occupe = occupe -1 ;
	}
	 
	 
	 
	 //méthode combattre d'après le Risk (avec un dé pris en compte pour comparer)
	 
	 public boolean combattre(Case c2) {
		 boolean resultAttaque = false ; 									//combat de point de vue d'attaquant
		 
		 while (this.getNbTroupes()>0 && c2.getNbTroupes()>0) {				//tant qu'il y a de troupes
			
		
			LinkedList<Integer> collectionDesAtt;							//création des collections de dés
			collectionDesAtt = new LinkedList<Integer>();					
			LinkedList<Integer> collectionDesDef;
			collectionDesDef = new LinkedList<Integer>();
			
			
			for (int i=0 ; i<this.getNbTroupes() ; i++) {					//lancer les dés
				collectionDesAtt.add(this.getAppartenance().lancerDe()) ;
				collectionDesDef.add(c2.getAppartenance().lancerDe()) ;
				if (i==3) {
					break;													//au maximum trois dés
				}
			}
			
			int deAtt1=0 ;													//dé max attaquant
			int deDef1=0 ;													//dé max défendeur
			
			for (int i : collectionDesAtt) {								//récuperation du dé le plus grand - attaque
				int lePlusGrand=0 ;
				for (int j : collectionDesAtt) {
					if (i>=j) {
						lePlusGrand=i;
					} else {
						lePlusGrand=j;
					}
				}
				
				if (lePlusGrand==i) {
					deAtt1=i ;
					collectionDesAtt.remove(i) ;
					break;
				}
			}
			
			for (int i : collectionDesDef) {								//récuperation du dé le plus grand - défence
				int lePlusGrand=0 ;
				for (int j : collectionDesDef) {
					if (i>=j) {
						lePlusGrand=i;
					} else {
						lePlusGrand=j;
					}
				}
				
				if (lePlusGrand==i) {
					deDef1=i ;
					collectionDesDef.remove(i) ;
					break;
				}
			}			
						
			if (deAtt1>deDef1) {											//comparaison des 2 dés
				c2.perdreTroupe() ;
			} else {
				this.perdreTroupe() ;
			}
		}
		if (c2.getNbTroupes()==0) {											//si l'attaquer a gagné
			resultAttaque = true ;
			
			c2.changerAppartenance(appartenance) ;
			
			/*
			for (Troupe trp : p.getCollectionTroupes()) {					// pour changer gagnant
				if (trp.getCase()==this) {
					trp.setGagnant(true) ;
					trp.setCase(c2) ;
				}
			} */

		}
		
		return resultAttaque;
	}
						
}
		
		
		
		
