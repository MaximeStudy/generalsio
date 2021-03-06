package controler;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Element;
import model.Joueur;
import model.Plaine;
import view.VerifGagnant;

public class G_Joueur {
    /**
     * @associates <{uml.Joueur}>
     */
    static List<Joueur> listeJoueur= new ArrayList<Joueur>();

    public static void initialiserJoueur() {
    	listeJoueur.add(new Joueur(Color.BLUE,"Joueur bleu",G_Element.getBase(Color.BLUE),Color.CYAN));
    	listeJoueur.add(new Joueur(Color.RED,"Joueur rouge",G_Element.getBase(Color.RED),Color.ORANGE));
    }

    /* Change la postion du personnage */
    public static void deplacerPers(Joueur j, Element e) {
    	synchronized(G_Element.getTousLesElements())  {
    		/* peut seulement traverser la case si ce n'est pas une montagne, si la couleur de la case suivante est de la couleur du joueur et que le nombre sur la case presente est sup a la case suivante (la derniere clause eprmet de ne pas perdre de soldats quand on fonce vers un mur exterieur*/
            if (e.getEstFranchissable() && (e.getSoldats()+1<j.getEstSur().getSoldats() || e.getCouleur()==j.getColor()) && 
            		j.getColor()==j.getEstSur().getCouleur() &&  j.getEstSur() != e) { 
            	//permet de gerer si c'est un ennemi et faire moins
            	if(j.getColor() != e.getCouleur())
            	{
            		e.setSoldats(j.getEstSur().getSoldats()-e.getSoldats()-1);
                	j.getEstSur().setSoldats(1);
                	j.setEstSur(e);
                	Plaine p=(Plaine)e;
                	p.setJ(j);
            	}
            	else
            	{
            		e.setSoldats(e.getSoldats()+j.getEstSur().getSoldats()-1);
                	j.getEstSur().setSoldats(1);
                	j.setEstSur(e);
                	Plaine p=(Plaine)e;
                	p.setJ(j);
            	}
            	
            }
            else if (j.getColor() != j.getEstSur().getCouleur())
            {
            	j.setEstSur(j.getBase());
            }
            //VerifGagnant.TestGagnant(G_Joueur.getListeJoueur().get(1).getColor(), G_Joueur.getListeJoueur().get(0).getBase().getCouleur());
            //VerifGagnant.TestGagnant(G_Joueur.getListeJoueur().get(0).getColor(),G_Joueur.getListeJoueur().get(1).getBase().getCouleur());
    	}
    	
    }
    
    public static List<Joueur> getListeJoueur() {
        return listeJoueur;
    }
    
    public static int getNbJoueur() {
        return listeJoueur.size();
    }

    public static Joueur getJoueur(Color col) {
        int i;
        for(i=0;i<listeJoueur.size();i++) {
            if (listeJoueur.get(i).getColor()==col)
                break;
        }
        return listeJoueur.get(i);
    }
    
    public static Joueur getJoueur(Joueur j) {
        return getJoueur(j.getColor());
    }
    
}
