package projetSynthese;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

 
public class FenetreJeu extends JFrame
{

	
	int LIGNE=20,COLONNE=20;
			
	private JLabel[][] tabNombre; // tableau de JLabels
//	private JLabel[][] tabDecor; // tableau de JLabels


	private JPanel panelNombreGrille = new JPanel(); // panel du bas ( grille )
	GridLayout gridNombreLayout = new GridLayout(20,20);
	
//	private JPanel panelDecorGrille = new JPanel(); // panel du bas ( grille )
//	GridLayout gridDecorLayout = new GridLayout(20,20);
	
	 //Constructeur, appelle mthode JBInit	
	public FenetreJeu()
	{
			jbInit();
	}
	 //initialise la surface de jeu. Cree tout les  elements et initialise leur position leur couleur.. etc
	
	private void jbInit()
	{

		
		tabNombre = new JLabel[LIGNE][COLONNE]; // cration du tableau de JLabel
	//	tabDecor = new JLabel[LIGNE][COLONNE]; // cration du tableau de JLabel
		

		this.getContentPane().setLayout(null);						//Enleve barre

		this.setSize(new Dimension(1200, 1000));					//Taille fenetre entiere
		this.setTitle("Generalsio");								//Titre

		panelNombreGrille.setBounds(new Rectangle(200, 50, 850, 850));	// ajuste le JPannel dans la JFrame
		panelNombreGrille.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));	//créé une bordure autour du pannel
		panelNombreGrille.setLayout(gridNombreLayout);
		

	//	panelDecorGrille.setBounds(new Rectangle(200, 50, 850, 850));
	//	panelDecorGrille.setLayout(gridDecorLayout);
		
		//this.add(panelDecorGrille);
		this.add(panelNombreGrille);

		

		for (int ligne = 0; ligne < LIGNE; ligne++)
		{
			for (int colonne = 0; colonne < COLONNE; colonne++)
			{
				tabNombre[colonne][ligne] = new JLabel(); // creaation du JLabel
				panelNombreGrille.add(tabNombre[colonne][ligne]); // ajouter au Panel
				tabNombre[colonne][ligne].setOpaque(true);
				tabNombre[colonne][ligne].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));	// encadre chaque case
				}	
		}
		
		
		/*
		for (int ligne = 0; ligne < LIGNE; ligne++)
		{
			for (int colonne = 0; colonne < COLONNE; colonne++)
			{
				tabDecor[colonne][ligne] = new JLabel(); // creaation du JLabel
				panelDecorGrille.add(tabDecor[colonne][ligne]); // ajouter au Panel
				tabDecor[colonne][ligne].setOpaque(true);
				tabDecor[colonne][ligne].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));	// encadre chaque case
				}	
		}*/
		
		Font font = new Font("Arial",Font.CENTER_BASELINE,20);
		String dossierIcone = "Icone/";
		


		/*tabNombre[0][0].setText("1");
		tabNombre[0][0].setFont(font);
		tabNombre[0][0].setForeground(new Color(255,255,255));
		tabNombre[0][0].setHorizontalAlignment(JLabel.CENTER);
		tabNombre[0][0].setVerticalAlignment(JLabel.CENTER);
		*/
		
	     
		tabNombre[0][0].setBackground(new Color(200,0,0));		//carré rouge
		tabNombre[0][1].setBackground(new Color(200,0,0));		//carré rouge
		tabNombre[0][2].setBackground(new Color(200,0,0));		//carré rouge
		
		tabNombre[19][19].setBackground(new Color(0,0,200));		//carré bleu
		tabNombre[19][18].setBackground(new Color(0,0,200));		//carré bleu
		tabNombre[19][17].setBackground(new Color(0,0,200));		//carré bleu
		
		tabNombre[0][0].setIcon(new ImageIcon(dossierIcone + "DN.gif"));
		
		tabNombre[19][19].setIcon(new ImageIcon(dossierIcone + "DN.gif"));
		
		tabNombre[3][3].setIcon(new ImageIcon(dossierIcone + "TN.gif"));
		tabNombre[5][5].setIcon(new ImageIcon(dossierIcone + "TN.gif"));
		
		tabNombre[7][9].setIcon(new ImageIcon(dossierIcone + "TN.gif"));
		tabNombre[1][15].setIcon(new ImageIcon(dossierIcone + "TN.gif"));
		
		tabNombre[15][1].setIcon(new ImageIcon(dossierIcone + "TN.gif"));
		
		
		tabNombre[17][2].setIcon(new ImageIcon(dossierIcone + "mur.gif"));
		tabNombre[15][2].setIcon(new ImageIcon(dossierIcone + "mur.gif"));
		tabNombre[13][2].setIcon(new ImageIcon(dossierIcone + "mur.gif"));
		tabNombre[5][9].setIcon(new ImageIcon(dossierIcone + "mur.gif"));
		tabNombre[8][0].setIcon(new ImageIcon(dossierIcone + "mur.gif"));
		tabNombre[3][18].setIcon(new ImageIcon(dossierIcone + "mur.gif"));
	
		
		tabNombre[0][2].setText("1");
		tabNombre[0][2].setFont(font);
		tabNombre[0][2].setForeground(new Color(255,255,255));
		tabNombre[0][2].setHorizontalAlignment(JLabel.CENTER);
		tabNombre[0][2].setVerticalAlignment(JLabel.CENTER);
		
		tabNombre[0][1].setText("1");
		tabNombre[0][1].setFont(font);
		tabNombre[0][1].setForeground(new Color(255,255,255));
		tabNombre[0][1].setHorizontalAlignment(JLabel.CENTER);
		tabNombre[0][1].setVerticalAlignment(JLabel.CENTER);
		
		
		/*tab[0][0].setText("1");
		tab[0][0].setFont(font);
		tab[0][0].setForeground(new Color(255,255,255));
		tab[0][0].setHorizontalAlignment(JLabel.CENTER);
		tab[0][0].setVerticalAlignment(JLabel.CENTER);*/
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
