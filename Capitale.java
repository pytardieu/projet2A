import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Capitale extends Case {

	private int x;
	private int y;
	private int occupe;
	private Joueur appartenance;
	
	
	//Constructeur
	public Capitale(int x, int y, Joueur app){
		super(x,y);
		appartenance = app;
		occupe = 0;
		
	}
}
