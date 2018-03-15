import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
public class Plateau extends JPanel  {
	/*public static final Icon CASE_CONTOUR    = new ImageIcon();
    public static final Icon CASE_PLAINE = new ImageIcon();
    public static final Icon CASE_EAU   = new ImageIcon();
    public static final Icon CASE_FORET     = new ImageIcon();*/
	private double h;
	private double l;
	private int nbCases;
    public static final int CASE_CONTOUR    = 0;
    public static final int CASE_PLAINE = 1;
    public static final int CASE_EAU    = 2;
    public static final int CASE_FORET    = 3;
    private final int[][] PLATEAU = {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,2,2,0,0,0,0,1,0,0,0,0,0,0,0},
        {0,0,0,0,1,0,0,1,0,0,0,1,1,0,0},
        {0,0,0,1,0,1,0,0,0,0,1,1,0,0,0},
        {0,0,0,1,0,0,0,0,0,0,0,1,1,0,0},
        {0,2,0,1,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	};
	public Plateau(){
		
	 nbCases=PLATEAU.length*PLATEAU[0].length;
	 h = this.getHeight()/(double)nbCases;        
	l = getWidth()/(double)nbCases; 
	h=4;
	l=4;
	}
	 protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int l=0;
		/*g.setColor(Color.ORANGE);
		g.fillRect(100,100,100,100);*/
		//Parcours du tableau pour reconnaitre le type d'objet dns la case afin de le dessiner
		System.out.println("nb cases"+nbCases+"bite"+h+getHeight());
		for(int i=0;i<PLATEAU.length;i++){
			for(int j=0;j<PLATEAU[i].length;j++){
				/*g.setColor(Color.BLUE);
				System.out.println("y");
				g.fillRect((int)(j*l),(int)(i*h),(int)l,(int)h);*/
				//try{
				System.out.println(j);
				l=l+1;
					System.out.println("y");
					//g.drawRect((int)(j*l),(int)(i*h),(int)l,(int)h);
				if(PLATEAU[i][j]==1){
					//Image plaine = ImageIO.read(new File("imageRISKPlaine.png"));
					//g.drawImage(plaine,(i+800)/12,(j+450)/10,800/12,800/12,null);
					//g.fillRect((i+800)/12,(j+450)/10,800/12,800/12);
					System.out.println("f");
				}else if(PLATEAU[i][j]==0){
					g.setColor(Color.ORANGE);
					g.fillRect(100,100,100,100);
					System.out.println("b");
					//Image contour = ImageIO.read(new File("imageRISKPlaine.png"));
					//g.drawImage(contour,(int)(j*l),(int)(i*h),(int)l,(int)h,null);
					g.setColor(Color.YELLOW);
					g.fillRect((int)(i*l),(int)(j*h),(int)l,(int)h);
				
				}else if(PLATEAU[i][j]==2){
					System.out.println("m");
					//Image eau = ImageIO.read(new File("imageRISKPlaine.png"));
					//g.drawImage(eau,(i+800)/12,(j+450)/10,800/12,800/12,null);
					//g.drawRect((i+800)/12,(j+450)/10,800/12,800/12);
				}else if(PLATEAU[i][j]==3){
					System.out.println("l");
					//Image foret = ImageIO.read(new File("imageRISKPlaine.png"));
					//g.drawImage(foret,(i+800)/12,(j+450)/10,800/12,800/12,null);
					//g.drawRect((i+800)/12,(j+450)/10,800/12,800/12);
				}
				/*} catch (IOException e) {
				e.printStackTrace();
				}*/
				
			}
		}
		System.out.println(l);
		

	}
	
}

