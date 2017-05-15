package projetSynthese;

import java.util.ArrayList;
import java.io.*;
import java.lang.Math;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

 
public class FenetreJeu extends JFrame
{
	private int COLONNE=18,LIGNE=18;
	
	private JLabel[][] JL_cases; // tableau de JLabels
	private JPanel JP_Grille = new JPanel(); 	// panel du bas ( grille )
	private GridLayout GL_Matrice = new GridLayout(COLONNE,LIGNE); 	
	
	private String dossierIcone = "Icone/";
	
	private int nbrAlea;
	private int xAlea,yAlea;
	private String tour="tour.png";			
	private String chateau="chateau.png";
	private String montagne="montagne.png";
	
	private int NBRMONTAGNE=65;
	private int NBRTOUR=22;
	
	private boolean tabCoord[][];
	private int coordBase1[];
	private int coordBase2[];
	
	private int tmp=0;
	
	private GestionnaireEvenement gest = new GestionnaireEvenement();
	
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
				JL_cases[colonne][ligne].setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 2));	// encadre chaque case
				JL_cases[colonne][ligne].addMouseListener(gest); // ajouter l'��couteur aux
			}	
		}
		InitCarte();
	}
	
	private void InitCarte()
	{
		coordBase1= new int[2];
		coordBase2= new int[2];
		
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
		coordBase1[0]=xAlea;
		coordBase1[1]=yAlea;
		setIcon(chateau, JL_cases[xAlea][yAlea]);  // on pop la premi�re base dans la moiti� sup�rieur de la carte
		setCouleur(Color.BLUE, JL_cases[xAlea][yAlea]);
		setTexte("1",JL_cases[xAlea][yAlea]);
		//JL_cases[xAlea][yAlea].setBorder(BorderFactory.createLineBorder(Color.white, 2));	// encadre case
		
		xAlea=(int) (Math.random()*(COLONNE));  //Math.random()*( max - mini + 1 ) ) + mini;		
		yAlea=(int) (Math.random()*((LIGNE-1)-((LIGNE+2)/2))+((LIGNE+2)/2));  //Math.random()*( max - mini + 1 ) ) + mini;
		tabCoord[xAlea][yAlea]=true;
		coordBase2[0]=xAlea;
		coordBase2[1]=yAlea;
		setIcon(chateau, JL_cases[xAlea][yAlea]);  // on pop la deuxi�me base dans la moiti� inf�rieur de la carte
		setCouleur(Color.RED, JL_cases[xAlea][yAlea]);
		setTexte("1",JL_cases[xAlea][yAlea]);
		//JL_cases[xAlea][yAlea].setBorder(BorderFactory.createLineBorder(Color.white, 2));	// encadre case

		//on g�n�re un chemin vide en L d'une base � l'autre
		if (coordBase1[0]>coordBase2[0])	
		{
			for (int i=coordBase1[0]-1; i>= coordBase2[0]; i--)
			{
				tabCoord[i][coordBase1[1]]=true;
				tmp=i;
			}
		}
		else
		{
			for (int i=coordBase1[0]+1; i<= coordBase2[0]; i++)
			{
				tabCoord[i][coordBase1[1]]=true;
				tmp=i;
			}	
		}

		for (int i=coordBase1[1]+1; i< coordBase2[1]; i++)
		{
			tabCoord[tmp][i]=true;
		}
		
		
		
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

	
	private class GestionnaireEvenement extends MouseAdapter
	{
		
		private int CaseSelect[];
		private int ligneClic;
		private int colonneClic;
		
		
		public void mouseClicked(MouseEvent eve)
		{
			CaseSelect = new int[2];
			if (eve.getSource() instanceof JLabel) // donc on a cliqu� sur un Label
			{
				for (int ligne = 0; ligne < COLONNE; ligne++)
				{
					
					for (int colonne = 0; colonne < LIGNE; colonne++)
					{
						if (eve.getSource() == JL_cases[colonne][ligne])
						{
							System.out.println("Ligne = "+ ligne);
							System.out.println("Colonne = "+ colonne);
							System.out.println("Ligne ancienne = "+ ligneClic);
							System.out.println("Colonne ancienne = "+ colonneClic);

								JL_cases[ligneClic][colonneClic].setBorder(BorderFactory.createLineBorder(Color.black, 2));	// encadre case
								
							colonneClic= colonne;
							ligneClic = ligne;
							JL_cases[colonneClic][ligneClic].setBorder(BorderFactory.createLineBorder(Color.white, 2));	// encadre case
							CaseSelect[0]=ligneClic;
							CaseSelect[1]=colonneClic;
						}
					}
				}
			}
		}
	
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

