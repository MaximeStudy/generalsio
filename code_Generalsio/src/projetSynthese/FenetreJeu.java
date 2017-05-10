package projetSynthese;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.JFrame;

  //classe Fenetre jeu servant a representer la GUI du jeu d'echec, contient la planche de jeu, les boutons debuter et reset,
 // et le champ texte informant le joueur sur le tour. Contient egalement deux jPanel contenant les pieces manges.
 
  //author Francois Allard
 
public class FenetreJeu extends JFrame
{

	
	int LIGNE=20,COLONNE=20;
			

	private JLabel[][] tab; // tableau de JLabels

	private JPanel panelControle = new JPanel(); // panel du haut
	private JPanel panelGrille = new JPanel(); // panel du bas ( grille )
	GridLayout gridLayout1 = new GridLayout();

	private JTextField champTexte = new JTextField();
	private JPanel panelblanc = new JPanel();
	private JPanel panelnoir = new JPanel();
	
	
	 //Constructeur, appelle mthode JBInit
	
	public FenetreJeu()
	{
		try 
		{
			jbInit();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
	
	 //initialise la surface de jeu. Cree tout les  elements et initialise leur position leur couleur.. etc
	
	private void jbInit() throws Exception 
	{

		tab = new JLabel[LIGNE][COLONNE]; // cration du tableau de JLabel
		
		this.getContentPane().setLayout(null);						//Enl�ve barre
		this.setSize(new Dimension(1200, 1000));					//Taille fen�tre enti�re
		this.setTitle("Generalsio");
		panelControle.setLayout(null);
		panelGrille.setBounds(new Rectangle(200, 50, 850, 850));
		panelGrille.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		panelGrille.setLayout(gridLayout1);
		gridLayout1.setColumns(COLONNE);
		gridLayout1.setRows(LIGNE);
		this.getContentPane().add(panelnoir, null);
		this.getContentPane().add(panelblanc, null);
		this.getContentPane().add(panelGrille, null);
		panelControle.add(champTexte, null);
		this.getContentPane().add(panelControle, null);
		champTexte.setBounds(new Rectangle(160, 10, 215, 25));

		int x=0;
		//J'attribue la couleur aux JLabels
		for (int ligne = 0; ligne < LIGNE; ligne++)
		{
			if (x == 0)
			x++;
			else
			x=0;
			
			for (int colonne = 0; colonne < COLONNE; colonne++)
			{
				tab[colonne][ligne] = new JLabel(); // creaation du JLabel
				tab[colonne][ligne].setOpaque(true);
				panelGrille.add(tab[colonne][ligne]); // ajouter au Panel
				tab[colonne][ligne].setOpaque(true);
				
				
				//tab[colonne][ligne].setHorizontalAlignment(SwingConstants.CENTER);
				
					if (x == 0)
					{
					tab[colonne][ligne].setBackground(new Color(255, 255, 255));
					x++;
					}
					else
					{
						tab[colonne][ligne].setBackground(new Color(250, 250, 250));
						x=0;
					}
				}
					

		
			
		}
		tab[10][10].setBackground(new Color(150,0,0));
		tab[10][9].setBackground(new Color(0,0,150));
		

	}


	// main pour pouvoir executer l'interface graphique
	public static void main(String[] args)
	{
		FenetreJeu j = new FenetreJeu();
		j.setVisible(true);
		j.setLocation(100, 130);
		j.setDefaultCloseOperation(EXIT_ON_CLOSE); // ferme le processus associ

	}
}
