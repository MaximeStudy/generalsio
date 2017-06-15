package view.form;

import javax.swing.border.EtchedBorder;

import controler.G_Carte;
import controler.G_Element;
import controler.G_Joueur;
import model.thread.IncrementationChateau;
import model.thread.IncrementationPlaine;
import view.thread.ChronoDeplacement;
import view.thread.VerifGagnant;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

 
public class FenetreJeu extends JFrame
{
	
    private JTextField jtfSaisi = new JTextField();
    private JPanel jpMessageSaisi = new JPanel();
    
	//for keylistener
	private static final long serialVersionUID = 1L;

	private static int COLONNE=18;
	private static int LIGNE=18;
	
	private static JLabel[][] JL_cases; // tableau de JLabels
	
	private JLabel TextePaneau = new JLabel();
	private JLabel ScoreBleu = new JLabel();
	private JLabel ScoreRouge = new JLabel();
	
	private static JPanel JP_Grille = new JPanel(); 	// panel du bas ( grille )
	private GridLayout GL_Matrice = new GridLayout(COLONNE,LIGNE); 	
	
	private static String dossierIcone = "Icone/";
	private static Thread threadCase,threadIncPlaine,threadIncChateau,threadVerif;
	
	static Font font = new Font("Calibri",Font.CENTER_BASELINE,18);	//police ecrite sur les cases
	
	private Dimension TaillePlateau = new Dimension(700,700);
	private JLayeredPane JL_Pane;//c'est le contener qui reçoit les images
	
	
	private JButton boutonDebuter = new JButton();
	private JTextField champTexte = new JTextField();
	private JButton boutonReset = new JButton();
	private JPanel panelControle = new JPanel(); // panel du haut
	private static boolean ThreadTourne=false;
	private static int OUI=0;
	private static int NON=1;
	
	private JOptionPane confirmation = new JOptionPane();
	private static int OUI_NON=NON;
	//initialise la surface de jeu
	public FenetreJeu()	{
		
		//grace a ca, on peut rendre focusable le plateau
		JL_Pane=new JLayeredPane();
		
		JL_cases = new JLabel[COLONNE][LIGNE];	 // création du tableau de JLabel
		this.getContentPane().setLayout(null);   // création bandeau vide
		this.setSize(new Dimension(1100, 780)); //Taille fenetre entiere
		this.setTitle("Generalsio");			 //Titre
		
		
		boutonReset.setBounds(new Rectangle(15, 220, 75, 70));
		boutonDebuter.setBounds(new Rectangle(15, 350, 75, 70));
		boutonDebuter.setText("DEBUT");
		boutonReset.setText("RESET");
	
		panelControle.setBounds(new Rectangle(30, 20, 100, 700));
		panelControle.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		panelControle.setLayout(null);
		panelControle.add(boutonReset, null);
		panelControle.add(boutonDebuter, null);


		
		
		JP_Grille.setBounds(new Rectangle(150, 20, 700, 700));	// ajuste le JPannel dans la JFrame
		JP_Grille.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));	//crï¿½ï¿½ une bordure autour du pannel
		JP_Grille.setSize(TaillePlateau);
		JP_Grille.setLayout(GL_Matrice);
		JL_Pane.add(JP_Grille);
		this.add(JL_Pane);
		
		TextePaneau.setBounds(new Rectangle(870, 50, 250, 20));
		TextePaneau.setText("Nombre de soldats par équipe");
		TextePaneau.setFont(new Font("Roboto", Font.BOLD, 18));
		
		ScoreBleu.setBounds(new Rectangle(900, 80, 100, 100));
		ScoreBleu.setText("1");
		ScoreBleu.setFont(new Font("Roboto", Font.BOLD, 30));
		ScoreBleu.setForeground(Color.BLUE);
		
		ScoreRouge.setBounds(new Rectangle(1020, 80, 100, 100));
		ScoreRouge.setText("1");
		ScoreRouge.setFont(new Font("Roboto", Font.BOLD, 30));
		ScoreRouge.setForeground(Color.RED);
		
		this.add(TextePaneau);
		this.add(ScoreBleu);
		this.add(ScoreRouge);

		for (int ligne = 0; ligne < COLONNE; ligne++)
		{
			for (int colonne = 0; colonne < LIGNE; colonne++)
			{
				JL_cases[colonne][ligne] = new JLabel(); // creation du JLabel
				JP_Grille.add(JL_cases[colonne][ligne]); // ajouter au Panel
			}	
		}
		
		
        jpMessageSaisi.setLayout(new BoxLayout(jpMessageSaisi, BoxLayout.PAGE_AXIS));
        //Message et Saisi
        jpMessageSaisi.add(jtfSaisi);
        JL_Pane.add(jpMessageSaisi);
		
        JL_Pane.add(panelControle, null);

        //Les ecouteurs
		GestionnaireEvenement gest = new GestionnaireEvenement();
		boutonDebuter.addMouseListener(gest);
		boutonReset.addMouseListener(gest);
        jtfSaisi.addKeyListener(new TAdapter());
        
        //On démarre avec EcranPrincipal
		setContentPane(new EcranPrincipal(this, JL_Pane, jtfSaisi));
	}
	
	public static void InitCarte()	{
			G_Carte.initialiserCarte();
			JP_Grille.removeAll();
			for (int ligne = 0; ligne < COLONNE; ligne++)
			{
				for (int colonne = 0; colonne < LIGNE; colonne++)
				{
					JL_cases[colonne][ligne] = new JLabel(); // creation du JLabel
					JP_Grille.add(JL_cases[colonne][ligne]); // ajouter au Panel
				}	
			}
			for(int i=0;i<18;i++) {
				for(int j=0;j<18;j++) {
					//affiche les elements sur la carte
					JL_cases[i][j].setOpaque(true);
					JL_cases[i][j].setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 2));	// encadre chaque case
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
			ChronoDeplacement c=new ChronoDeplacement(ScoreBleu,ScoreRouge);
			threadCase =  new Thread(c) ;
			
			IncrementationPlaine i=new IncrementationPlaine();
			threadIncPlaine =  new Thread(i) ;
			
			IncrementationChateau ch=new IncrementationChateau();
			threadIncChateau =  new Thread(ch) ;
			
			VerifGagnant verif=new VerifGagnant();
			threadVerif =  new Thread(verif) ;
			

	}

	private static void demarreThreads()
	{
		threadCase.start();
		threadIncPlaine.start();
		threadIncChateau.start();
		threadVerif.start();
	}
	
	private static void setIcon(String element, JLabel position)
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
	

	
	public static void encadrer(JLabel jl, Color c, int largeur)
	{			
		jl.setBorder(BorderFactory.createLineBorder(c, largeur));	// encadre case
	}


	 public static void nettoyerPropre() 
	 {
		 /* On kill les threads */
		threadCase.stop();
		threadIncPlaine.stop();
		threadIncChateau.stop();
		threadVerif.stop();
	 }
	 
	 
	 public static void keyReleased(KeyEvent e) 
	 {
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
             case KeyEvent.VK_R :
            	 OUI_NON=JOptionPane.showConfirmDialog(null, "Le Reset est irréversible. Êtes-vous sûr de vouloir continuer?",
                         "Veuillez confirmer votre choix",
                         JOptionPane.YES_NO_OPTION);
					if(OUI_NON==OUI)
					{
						if(ThreadTourne == true) //Test pour arreter les Threads seulement si ils tournent
						{
			                 nettoyerPropre();
			                 ThreadTourne=false;
						}
						
					 System.out.println("Restart");
	                 InitCarte();
					}
                 break;
                 
             case KeyEvent.VK_ENTER :
                 // handle right
					if(ThreadTourne == false)
					{
						System.out.println("Démarre");
						demarreThreads();
		                ThreadTourne=true;
					}
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
	 
	 
	    private class TAdapter extends KeyAdapter 
	    {
	        //pour le keypress
	        @Override
	        public void keyReleased(KeyEvent e) 
	        {
	        	
	        	FenetreJeu.keyReleased(e);
	        }
	    }

	    public JTextField getJtfSaisi() 
	    {
	        return jtfSaisi;
	    }
	    
	    public JLayeredPane getJL_Pane() 
	    {
	        return JL_Pane;
	    }
		private class GestionnaireEvenement extends MouseAdapter 
		{
			public void mouseClicked(MouseEvent eve) 
			{
				// si on clique sur le bouton débuter
				if (eve.getSource() == boutonReset) 
				{
					OUI_NON=JOptionPane.showConfirmDialog(null, "Le Reset est irréversible. Êtes-vous sûr de vouloir continuer?",
                            "Veuillez confirmer votre choix",
                            JOptionPane.YES_NO_OPTION);
					if(OUI_NON==OUI)
					{
					    ///l'utilisateur a dit oui
						if(ThreadTourne == true)
						{
			                 nettoyerPropre();
			                 ThreadTourne=false;
						}
						System.out.println("Restart");
		                InitCarte();
		                jtfSaisi.requestFocusInWindow();
					}
					else
					{
						jtfSaisi.requestFocusInWindow();
						// l'utilisateur a dit non
					}
					
	            
				}
				if (eve.getSource() == boutonDebuter) 
				{
					if(ThreadTourne == false)
					{
						System.out.println("Démarre");
						demarreThreads();
		                jtfSaisi.requestFocusInWindow();
		                ThreadTourne=true;
					}
					else
					{
						jtfSaisi.requestFocusInWindow();
					}
				}

			}
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

