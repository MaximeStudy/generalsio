package controler;

import model.Joueur;

public class G_Carte {
	    
    public static void initialiserCarte()   {
    	G_Element.remplirPlateau();
    	G_Joueur.initialiserJoueur();
    }
    
    /* Deplacement du perso vers la gauche */
    public static void deplacerGauche(Joueur j) {
    		G_Joueur.deplacerPers(j,G_Element.getElementGauche(G_Joueur.getJoueur(j).getEstSur()));
    }
    
    /* Deplacement du perso vers la droite */
    public static void deplacerDroite(Joueur j) {
    		G_Joueur.deplacerPers(j,G_Element.getElementDroite(G_Joueur.getJoueur(j).getEstSur()));
    }

    /* Deplacement du perso en bas (bloqué si c'est une montagne */
    public static void deplacerBas(Joueur j) {
    		G_Joueur.deplacerPers(j,G_Element.getElementBas(G_Joueur.getJoueur(j).getEstSur()));
    }

    /* Deplacement du perso en haut */
    public static void deplacerHaut(Joueur j) {
    		G_Joueur.deplacerPers(j,G_Element.getElementHaut(G_Joueur.getJoueur(j).getEstSur()));
    }
    
}

