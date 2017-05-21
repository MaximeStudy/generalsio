package view;

import java.lang.Math;
import java.util.ListIterator;

import javax.swing.border.EtchedBorder;

import controler.G_Carte;
import controler.G_Element;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

 
public class FenetreJeu extends JFrame implements KeyListener
{
	private int COLONNE=18,LIGNE=18;
	
	private JLabel[][] JL_cases; // tableau de JLabels
	private JPanel JP_Grille = new JPanel(); 	// panel du bas ( grille )
	private GridLayout GL_Matrice = new GridLayout(COLONNE,LIGNE); 	
	
	private String dossierIcone = "Icone/";
	private int nbJoueur=2;
	private int nbrAlea;
	private int xAlea,yAlea;
	private String base="base";			
	private String chateau="chateau";
	private String montagne="montagne";
	
	private int NBRMONTAGNE=65;
	private int NBRTOUR=22;
	
	private boolean tabCoord[][];
	private int coordBase1[];
	private int coordBase2[];
	
	private int tmp=0;
	
	private GestionnaireEvenement gest = new GestionnaireEvenement();
	
	Font font = new Font("Calibri",Font.CENTER_BASELINE,21);	//police ecrite sur les cases
	
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
		
		//permet de lancer le KeyListener
		addKeyListener(this);
	}
	
	private void InitCarte()	{
				G_Carte.initialiserCarte();
				for(int i=0;i<18;i++) {
					for(int j=0;j<18;j++) {
						//System.out.println("x :"+G_Element.getElement(i, j).getX()+" y :"+G_Element.getElement(i, j).getY()+" nomElem :"+G_Element.getElement(i, j).getNomElement());
						//affiche les elements sur la carte
						setIcon(G_Element.getElement(i, j).getNomElement(), JL_cases[i][j]);
						setCouleur(G_Element.getElement(i, j).getCouleur(), JL_cases[i][j]);
						//on veut pas afficher les soldats de la montagne
						if(!G_Element.getElement(i, j).getNomElement().equals("montagne"))
							setTexte(Integer.toString(G_Element.getElement(i, j).getSoldats()),JL_cases[i][j]);
					}
				}
	}

	
	private void setImgMontagne(JLabel position)
	{
		Color color1= new Color(110,110,110);
		setIcon(montagne,position);
		setCouleur(color1,position);
	}

	private void setImgChateau(JLabel position)
	{
		Color color1= new Color(180,180,180);
		setIcon(chateau,position);
		setCouleur(color1,position);
		nbrAlea=(int) (Math.random()*(16)+40);
		setTexte(Integer.toString(nbrAlea),position);
	}
	
	private void setIcon(String element, JLabel position)
		{
		String image= dossierIcone + element+".png";
		position.setIcon(new ImageIcon(image));
		position.setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	
	private void setCouleur(Color couleur, JLabel position)
	{
		position.setBackground(couleur);		
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
			if (eve.getSource() instanceof JLabel) // donc on a clique sur un Label
			{
				for (int ligne = 0; ligne < COLONNE; ligne++)
				{
					
					for (int colonne = 0; colonne < LIGNE; colonne++)
					{
						if (eve.getSource() == JL_cases[colonne][ligne])
						{
//							System.out.println("Ligne = "+ ligne);
//							System.out.println("Colonne = "+ colonne);
//							System.out.println("Ligne ancienne = "+ ligneClic);
//							System.out.println("Colonne ancienne = "+ colonneClic);

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
	
	public void encadrer(JLabel jl, Color c)
	{			
		jl.setBorder(BorderFactory.createLineBorder(c, 4));	// encadre case
	}

	 @Override
	 public void keyTyped(KeyEvent e) {
     	
     }

	 @Override
     public void keyPressed(KeyEvent e) {
         
     }
	 
	 @Override
     public void keyReleased(KeyEvent e) {
		 //TODO le mettre dans un thread
		 int keyCode = e.getKeyCode();
         switch( keyCode ) { 
             case KeyEvent.VK_UP:
                 System.out.println("Up 1");
                 encadrer(JL_cases[G_Element.getBase(Color.BLUE).getX()][G_Element.getBase(Color.BLUE).getY()],Color.cyan);
                 break;
             case KeyEvent.VK_DOWN:
                 // handle down 
                 System.out.println("Down 1");

                 break;
             case KeyEvent.VK_LEFT:
                 // handle left
                 System.out.println("Left 1");

                 break;
             case KeyEvent.VK_RIGHT :
                 // handle right
                 System.out.println("Right 1");
                 break;
          }
         
         switch( keyCode ) { 
         case KeyEvent.VK_Z:
             System.out.println("Up 2");
             encadrer(JL_cases[G_Element.getBase(Color.RED).getX()][G_Element.getBase(Color.RED).getY()],Color.ORANGE);
             
             break;
         case KeyEvent.VK_S:
             // handle down 
             System.out.println("Down 2");

             break;
         case KeyEvent.VK_Q:
             // handle left
             System.out.println("Left 2");

             break;
         case KeyEvent.VK_D :
             // handle right
             System.out.println("Right 2");

             break;
      }
     }
	
}

