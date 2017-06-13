package view.form;

import javax.swing.border.EtchedBorder;

import controler.G_Carte;
import controler.G_Element;
import controler.G_Joueur;
import model.thread.IncrementationChateau;
import model.thread.IncrementationPlaine;
import view.VerifGagnant;
import view.thread.updateCase;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

 
public class FenetreJeu extends JFrame implements KeyListener
{
	//for keylistener
	private static final long serialVersionUID = 1L;

	private int COLONNE=18,LIGNE=18;
	
	private static JLabel[][] JL_cases; // tableau de JLabels
	
	private JLabel TextePaneau = new JLabel();
	private JLabel ScoreBleu = new JLabel();
	private JLabel ScoreRouge = new JLabel();

	private JPanel JP_Grille = new JPanel(); 	// panel du bas ( grille )
	private GridLayout GL_Matrice = new GridLayout(COLONNE,LIGNE); 	
	
	private String dossierIcone = "Icone/";
	
	private GestionnaireEvenement gest = new GestionnaireEvenement();
	
	static Font font = new Font("Calibri",Font.CENTER_BASELINE,18);	//police ecrite sur les cases
	
	//initialise la surface de jeu
	public FenetreJeu()	{
		JL_cases = new JLabel[COLONNE][LIGNE];	 // cr�ation du tableau de JLabel
		this.getContentPane().setLayout(null);   // cr�� bandeau vide
		this.setSize(new Dimension(1200, 800)); //Taille fenetre entiere
		this.setTitle("Generalsio");			 //Titre

		JP_Grille.setBounds(new Rectangle(150, 10, 700, 700));	// ajuste le JPannel dans la JFrame
		JP_Grille.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));	//cr�� une bordure autour du pannel
		JP_Grille.setLayout(GL_Matrice);
		this.add(JP_Grille);
		
		TextePaneau.setBounds(new Rectangle(900, 50, 250, 20));
		TextePaneau.setText("Nombre de soldats par équipe");
		TextePaneau.setFont(new Font("Roboto", Font.BOLD, 18));
		
		ScoreBleu.setBounds(new Rectangle(930, 80, 100, 100));
		ScoreBleu.setText("1");
		ScoreBleu.setFont(new Font("Roboto", Font.BOLD, 30));
		ScoreBleu.setForeground(Color.BLUE);
		
		ScoreRouge.setBounds(new Rectangle(1050, 80, 100, 100));
		ScoreRouge.setText("1");
		ScoreRouge.setFont(new Font("Roboto", Font.BOLD, 30));
		ScoreRouge.setForeground(Color.RED);
		
		this.add(TextePaneau);
		this.add(ScoreBleu);
		this.add(ScoreRouge);
		
		this.requestFocus(true);

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
			for(int i=0;i<G_Joueur.getNbJoueur();i++)
			{
                 encadrer(JL_cases[G_Joueur.getListeJoueur().get(i).getEstSur().getX()][G_Joueur.getListeJoueur().get(i).getEstSur().getY()],G_Joueur.getListeJoueur().get(i).getEncadrementr(),4);
			}
			
			
			/* Lancement du Thread */
			updateCase c=new updateCase();
			Thread threadCase =  new Thread(c) ;
			
			IncrementationPlaine i=new IncrementationPlaine();
			Thread threadIncPlaine =  new Thread(i) ;
			
			IncrementationChateau ch=new IncrementationChateau();
			Thread threadIncChateau =  new Thread(ch) ;
			
			VerifGagnant verif=new VerifGagnant();
			
			AffichageScore a = new AffichageScore(ScoreBleu,ScoreRouge);
			Thread threadAffichage = new Thread(a);
			
			threadCase.start();
			threadIncPlaine.start();
			threadIncChateau.start();
			threadAffichage.start();

	}

	
	private void setIcon(String element, JLabel position)
		{
		String image= dossierIcone + element+".png";
		position.setIcon(new ImageIcon(image));
		position.setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	
	public static void setCouleur(Color couleur, JLabel position)
	{
		position.setBackground(couleur);		
	}
	
	public static void setTexte(String texte, JLabel position)
	{		
			position.setFont(font);
	        position.setForeground(new Color(255,255,255));
	        position.setHorizontalAlignment(JLabel.CENTER);
	        position.setVerticalAlignment(JLabel.CENTER);
	}
	
	public static JLabel[][] getJL_cases() {
		return JL_cases;
	}

	public static void setJL_cases(JLabel[][] jL_cases) {
		JL_cases = jL_cases;
	}
	
	
	private class GestionnaireEvenement extends MouseAdapter
	{
		private int ligneClic;
		private int colonneClic;	
		
		public void mouseClicked(MouseEvent eve)
		{
			if (eve.getSource() instanceof JLabel) // donc on a clique sur un Label
			{
				for (int ligne = 0; ligne < COLONNE; ligne++)
				{
					
					for (int colonne = 0; colonne < LIGNE; colonne++)
					{
						if (eve.getSource() == JL_cases[colonne][ligne])
						{
							JL_cases[colonneClic][ligneClic].setBorder(BorderFactory.createLineBorder(Color.black, 2));	// encadre case
							colonneClic= colonne;
							ligneClic = ligne;
							JL_cases[colonneClic][ligneClic].setBorder(BorderFactory.createLineBorder(Color.white, 2));	// encadre case
						}
					}
				}
			}
		}
	
	}
	
	public void encadrer(JLabel jl, Color c, int largeur)
	{			
		jl.setBorder(BorderFactory.createLineBorder(c, largeur));	// encadre case
	}

	 @Override
	 public void keyTyped(KeyEvent e) {
     	
     }

	 @Override
     public void keyPressed(KeyEvent e) {
         
     }
	 
	 @Override
     public void keyReleased(KeyEvent e) {
         //Le curseur a change, il faut mettre la decoration de la case par defaut (noir)
		 encadrer(JL_cases[G_Joueur.getJoueur(Color.BLUE).getEstSur().getX()][G_Joueur.getJoueur(Color.BLUE).getEstSur().getY()],Color.BLACK,2);
		 int keyCode = e.getKeyCode();
         switch( keyCode ) { 
             case KeyEvent.VK_UP:
                 System.out.println("Up 1");
                 G_Carte.deplacerHaut(G_Joueur.getJoueur(Color.BLUE));
                 break;
             case KeyEvent.VK_DOWN:
                 // handle down 
                 System.out.println("Down 1");
                 G_Carte.deplacerBas(G_Joueur.getJoueur(Color.BLUE));

                 break;
             case KeyEvent.VK_LEFT:
                 // handle left
                 System.out.println("Left 1");
                 G_Carte.deplacerGauche(G_Joueur.getJoueur(Color.BLUE));


                 break;
             case KeyEvent.VK_RIGHT :
                 // handle right
                 System.out.println("Right 1");
                 G_Carte.deplacerDroite(G_Joueur.getJoueur(Color.BLUE));
                 
                 break;
          }
         
		 encadrer(JL_cases[G_Joueur.getJoueur(Color.BLUE).getEstSur().getX()][G_Joueur.getJoueur(Color.BLUE).getEstSur().getY()],Color.CYAN,5);
		 
		 encadrer(JL_cases[G_Joueur.getJoueur(Color.RED).getEstSur().getX()][G_Joueur.getJoueur(Color.RED).getEstSur().getY()],Color.BLACK,2);
         switch( keyCode ) { 
         case KeyEvent.VK_Z:
             System.out.println("Up 2");
             G_Carte.deplacerHaut(G_Joueur.getJoueur(Color.RED));

             break;
         case KeyEvent.VK_S:
             // handle down 
             System.out.println("Down 2");
             G_Carte.deplacerBas(G_Joueur.getJoueur(Color.RED));

             break;
         case KeyEvent.VK_Q:
             // handle left
             System.out.println("Left 2");
             G_Carte.deplacerGauche(G_Joueur.getJoueur(Color.RED));

             break;
         case KeyEvent.VK_D :
             // handle right
             System.out.println("Right 2");
             G_Carte.deplacerDroite(G_Joueur.getJoueur(Color.RED));
             break;
      }
         encadrer(JL_cases[G_Joueur.getJoueur(Color.RED).getEstSur().getX()][G_Joueur.getJoueur(Color.RED).getEstSur().getY()],Color.ORANGE,5);

     }
	
	public JLabel getScoreBleu() {
			return ScoreBleu;
		}

		public void setScoreBleu(JLabel scoreBleu) {
			ScoreBleu = scoreBleu;
		}

		public JLabel getScoreRouge() {
			return ScoreRouge;
		}

		public void setScoreRouge(JLabel scoreRouge) {
			ScoreRouge = scoreRouge;
		}
}

