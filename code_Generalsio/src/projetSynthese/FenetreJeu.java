package projetSynthese;

import javax.swing.border.EtchedBorder;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

 
public class FenetreJeu extends JFrame
{
	private int LIGNE=18,COLONNE=18;
	
	private JLabel[][] JL_cases; // tableau de JLabels
	private JPanel JP_Grille = new JPanel(); 	// panel du bas ( grille )
	private GridLayout GL_Matrice = new GridLayout(LIGNE,COLONNE); 	
	
	private String dossierIcone = "Icone/";
	
	private String tour="tour.png";			
	private String chateau="chateau.png";
	private String montagne="montagne.png";
	
	Font font = new Font("Calibri",Font.CENTER_BASELINE,21);	//police écrite sur les cases
	
	//initialise la surface de jeu
	public FenetreJeu()
	{
		JL_cases = new JLabel[LIGNE][COLONNE];	 // création du tableau de JLabel
		this.getContentPane().setLayout(null);   // créé bandeau vide
		this.setSize(new Dimension(1000, 800)); //Taille fenetre entiere
		this.setTitle("Generalsio");			 //Titre

		JP_Grille.setBounds(new Rectangle(150, 10, 700, 700));	// ajuste le JPannel dans la JFrame
		JP_Grille.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));	//créé une bordure autour du pannel
		JP_Grille.setLayout(GL_Matrice);
		this.add(JP_Grille);	

		for (int ligne = 0; ligne < LIGNE; ligne++)
		{
			for (int colonne = 0; colonne < COLONNE; colonne++)
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
		setIcon(chateau, JL_cases[1][3]);
		setIcon(chateau, JL_cases[13][15]);
		setCouleur(Color.BLUE, JL_cases[1][3]);
		setCouleur(Color.RED, JL_cases[13][15]);
		setTexte("1",JL_cases[1][3]);
		setTexte("1",JL_cases[13][15]);
		
		 setImgTour(JL_cases[0][1]);
		 setImgTour(JL_cases[0][15]);
		 setImgTour(JL_cases[3][9]);
		 setImgTour(JL_cases[0][11]);
		 setImgTour(JL_cases[10][0]);
		 setImgTour(JL_cases[3][3]);
		 setImgTour(JL_cases[6][2]);
		 setImgTour(JL_cases[3][1]);
		 setImgTour(JL_cases[1][17]);
		 setImgTour(JL_cases[2][14]);
		 setImgTour(JL_cases[4][5]);
		 setImgTour(JL_cases[5][13]);
		 setImgTour(JL_cases[7][14]);
		 setImgTour(JL_cases[8][11]);
		 setImgTour(JL_cases[10][17]);
		 setImgTour(JL_cases[11][5]);
		 setImgTour(JL_cases[12][8]);
		 setImgTour(JL_cases[13][10]);
		 setImgTour(JL_cases[16][3]);
		 setImgTour(JL_cases[17][17]);
		 setImgTour(JL_cases[15][14]);
	
		setImgMontagne(JL_cases[0][0]);
		setImgMontagne(JL_cases[0][4]);
		setImgMontagne(JL_cases[0][6]);
		setImgMontagne(JL_cases[0][7]);
		setImgMontagne(JL_cases[0][8]);
		setImgMontagne(JL_cases[0][12]);
		setImgMontagne(JL_cases[1][5]);
		setImgMontagne(JL_cases[1][11]);
		setImgMontagne(JL_cases[1][14]);
		setImgMontagne(JL_cases[1][15]);
		setImgMontagne(JL_cases[2][1]);
		setImgMontagne(JL_cases[2][4]);
		setImgMontagne(JL_cases[2][7]);
		setImgMontagne(JL_cases[2][9]);
		setImgMontagne(JL_cases[2][17]);
		setImgMontagne(JL_cases[3][7]);
		setImgMontagne(JL_cases[3][10]);
		setImgMontagne(JL_cases[3][12]);
		setImgMontagne(JL_cases[3][14]);
		setImgMontagne(JL_cases[3][15]);
		setImgMontagne(JL_cases[4][8]);
		setImgMontagne(JL_cases[4][12]);
		setImgMontagne(JL_cases[4][13]);
		setImgMontagne(JL_cases[5][1]);
		setImgMontagne(JL_cases[5][12]);
		setImgMontagne(JL_cases[6][7]);
		setImgMontagne(JL_cases[6][8]);
		setImgMontagne(JL_cases[6][15]);
		setImgMontagne(JL_cases[7][2]);
		setImgMontagne(JL_cases[7][3]);
		setImgMontagne(JL_cases[8][1]);
		setImgMontagne(JL_cases[8][2]);
		setImgMontagne(JL_cases[8][3]);
		setImgMontagne(JL_cases[8][4]);
		setImgMontagne(JL_cases[8][5]);
		setImgMontagne(JL_cases[8][6]);
		setImgMontagne(JL_cases[8][14]);
		setImgMontagne(JL_cases[8][15]);
		setImgMontagne(JL_cases[8][16]);
		setImgMontagne(JL_cases[9][0]);
		setImgMontagne(JL_cases[9][9]);
		setImgMontagne(JL_cases[9][10]);
		setImgMontagne(JL_cases[9][14]);
		setImgMontagne(JL_cases[11][1]);
		setImgMontagne(JL_cases[12][3]);
		setImgMontagne(JL_cases[12][4]);
		setImgMontagne(JL_cases[12][5]);
		setImgMontagne(JL_cases[12][12]);
		setImgMontagne(JL_cases[12][13]);
		setImgMontagne(JL_cases[12][14]);
		setImgMontagne(JL_cases[13][0]);
		setImgMontagne(JL_cases[13][6]);
		setImgMontagne(JL_cases[13][7]);
		setImgMontagne(JL_cases[14][6]);
		setImgMontagne(JL_cases[15][3]);
		setImgMontagne(JL_cases[15][12]);
		setImgMontagne(JL_cases[16][12]);
		setImgMontagne(JL_cases[17][0]);
		setImgMontagne(JL_cases[17][5]);
		setImgMontagne(JL_cases[17][6]);
		setImgMontagne(JL_cases[17][7]);
		setImgMontagne(JL_cases[17][12]);
		setImgMontagne(JL_cases[14][17]);
		setImgMontagne(JL_cases[15][17]);
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
		setTexte("40",position);
	}
	
	private void setIcon(String element, JLabel position)
	{
	String image= dossierIcone + element;
	position.setIcon(new ImageIcon(image));
	position.setLayout(new FlowLayout(FlowLayout.CENTER));
	}


	private void setCouleur(Color couleur, JLabel position)
	{
	position.setBackground(couleur);		//carré rouge
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
