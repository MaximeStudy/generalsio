package view;

import java.lang.Math;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import javax.swing.*;

 
public class FenetreJeu extends JFrame
{
	private int COLONNE=18,LIGNE=18;
	
	private JLabel[][] JL_cases; // tableau de JLabels
	private JPanel JP_Grille = new JPanel(); 	// panel du bas ( grille )
	private GridLayout GL_Matrice = new GridLayout(COLONNE,LIGNE); 	
	
	private String dossierIcone = "icone/";
	
	private int nbrAlea;
	private int xAlea,yAlea;
	private String tour="tour.png";			
	private String chateau="chateau.png";
	private String montagne="montagne.png";
	
	private int NBRMONTAGNE=65;
	private int NBRTOUR=22;
	
	private boolean tabCoord[][];

	Font font = new Font("Calibri",Font.CENTER_BASELINE,21);	//police �crite sur les cases
	
	//initialise la surface de jeu
	public FenetreJeu()
	{
		JL_cases = new JLabel[COLONNE][LIGNE];	 // cr�ation du tableau de JLabel
		this.getContentPane().setLayout(null);   // cr�� bandeau vide
		this.setSize(new Dimension(1000, 800)); //Taille fenetre entiere
		this.setTitle("Generalsio");			 //Titre

		JP_Grille.setBounds(new Rectangle(150, 10, 700, 700));	// ajuste le JPannel dans la JFrame
		JP_Grille.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));	//cr�� une bordure autour du pannel
		JP_Grille.setLayout(GL_Matrice);
		this.add(JP_Grille);	

		for (int ligne = 0; ligne < COLONNE; ligne++)
		{
			for (int colonne = 0; colonne < LIGNE; colonne++)
			{
				JL_cases[colonne][ligne] = new JLabel(); // creation du JLabel
				JP_Grille.add(JL_cases[colonne][ligne]); // ajouter au Panel
				JL_cases[colonne][ligne].setOpaque(true);
				JL_cases[colonne][ligne].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));	// encadre chaque case
			}	
		}
		InitCarte();
		
	}
	
	private void InitCarte()
	{
		
		tabCoord = new boolean[18][18];	//tableau pour tester les cases occup�es
		
		for (int i=0; i<18; i++)
		{
			for (int j=0; j<18; j++)
			{
				tabCoord[i][j]=false;
			}
		}
		
		xAlea=(int) (Math.random()*(COLONNE));  //Math.random()*( max - mini + 1 ) ) + mini;
		yAlea=(int) (Math.random()*((LIGNE-2)/2));  //Math.random()*( max - mini + 1 ) ) + mini;
		tabCoord[xAlea][yAlea]=true;
		setIcon(chateau, JL_cases[xAlea][yAlea]);  // on pop la premi�re base dans la moiti� sup�rieur de la carte
		setCouleur(Color.BLUE, JL_cases[xAlea][yAlea]);
		setTexte("1",JL_cases[xAlea][yAlea]);
		
		xAlea=(int) (Math.random()*(COLONNE));  //Math.random()*( max - mini + 1 ) ) + mini;		
		yAlea=(int) (Math.random()*((LIGNE-1)-((LIGNE+2)/2))+((LIGNE+2)/2));  //Math.random()*( max - mini + 1 ) ) + mini;
		tabCoord[xAlea][yAlea]=true;
		setIcon(chateau, JL_cases[xAlea][yAlea]);  // on pop la deuxi�me base dans la moiti� inf�rieur de la carte
		setCouleur(Color.RED, JL_cases[xAlea][yAlea]);
		setTexte("1",JL_cases[xAlea][yAlea]);

		for (int i=0; i< NBRTOUR; i++)
		{
			xAlea=(int) (Math.random()*(COLONNE));  //Math.random()*( max - mini + 1 ) ) + mini;
			yAlea=(int) (Math.random()*(LIGNE));  //Math.random()*( max - mini + 1 ) ) + mini;}
			if (tabCoord[xAlea][yAlea] == false)
			{
				setImgTour(JL_cases[xAlea][yAlea]);
				tabCoord[xAlea][yAlea]=true;		
			}
			else
			{
				i--;
			}
		}
		
		for (int i=0; i< NBRMONTAGNE; i++)
		{
			xAlea=(int) (Math.random()*(COLONNE));  //Math.random()*( max - mini + 1 ) ) + mini;
			yAlea=(int) (Math.random()*(LIGNE));  //Math.random()*( max - mini + 1 ) ) + mini;
			if (tabCoord[xAlea][yAlea] == false)
			{
				setImgMontagne(JL_cases[xAlea][yAlea]);
				tabCoord[xAlea][yAlea]=true;
			}
			else
			{
				i--;
			}
		}		
	}
	
	private void setImgMontagne(JLabel position)
	{
		Color color1= new Color(110,110,110);
		setIcon(montagne,position);
		setCouleur(color1,position);
	}

	private void setImgTour(JLabel position)
	{
		Color color1= new Color(180,180,180);
		setIcon(tour,position);
		setCouleur(color1,position);
		nbrAlea=(int) (Math.random()*(16)+40);
		setTexte(Integer.toString(nbrAlea),position);
	}
	
	private void setIcon(String element, JLabel position)
	{
	String image= dossierIcone + element;
	position.setIcon(new ImageIcon(image));
	position.setLayout(new FlowLayout(FlowLayout.CENTER));
	}


	private void setCouleur(Color couleur, JLabel position)
	{
	position.setBackground(couleur);		//carr� rouge
	}
	
	private void setTexte(String texte, JLabel position)
	{
        JLabel text = new JLabel(texte);
        text.setFont(font);
        text.setForeground(new Color(255,255,255));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setVerticalAlignment(JLabel.CENTER);
        position.add(text);
	}

	// main pour pouvoir executer l'interface graphique
	public static void main(String[] args)
	{
		FenetreJeu j = new FenetreJeu();
		j.setVisible(true);							//rend la fenetre visible
		j.setLocation(10, 15);						//centre la fenetre
		j.setDefaultCloseOperation(EXIT_ON_CLOSE); // arrete l'execution a la fermeture

	}
}