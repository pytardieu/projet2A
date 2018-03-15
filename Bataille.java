import javax.swing.*;
import java.awt.*;

public class Bataille extends JFrame {
	private JButton start ;
	private JButton de1 , de2 , de3;         //déclaration des boutons du panneau de controle
	private JLabel titre, joueurA , joueurB , attaque;  // déclaration des éléments du panneau de combat
	
	
	
	
	public Bataille(Joueur attaquant, Joueur defenseur) {

		super("fenêtre de Bataille");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 500);
		
		
		JPanel panneauContol = new JPanel(new GridLayout(1,4));   //création et ajout des boutons du panneau de control
			de1 =new JButton("dé1");
			de2 =new JButton("dé2");
			de3 =new JButton("dé3");
			start =new JButton("Lancer les dés");
	
			panneauContol.add(de1);
			panneauContol.add(de2);
			panneauContol.add(de3);
			panneauContol.add(start);
		
		JPanel panneauCombat = new JPanel(new GridLayout(1,3));  //création et ajout des éléments du panneau de combat
			JPanel p1 = new JPanel(new FlowLayout());
				titre = new JLabel("Bataille !");
				p1.add(titre);
				
			JPanel p2 = new JPanel(new FlowLayout());
				joueurA = new JLabel(attaquant.getNom());
				joueurB = new JLabel(defenseur.getNom());
				attaque = new JLabel("attaque");
				
				p2.add(joueurA);
				p2.add(attaque);
				p2.add(joueurB);
				
			JPanel p3= new JPanel();
			
		panneauCombat.add(p1);
		panneauCombat.add(p2);
		panneauCombat.add(p3);
		
		
		JPanel cadrePrincipal = new JPanel(new BorderLayout());
		cadrePrincipal.add(panneauCombat, BorderLayout.CENTER);
		cadrePrincipal.add(panneauControl, BorderLayout.WEST);
		
	
	setContentPane(cadrePrincipal);
	setVisible(true);
	}
	
		
	
}

