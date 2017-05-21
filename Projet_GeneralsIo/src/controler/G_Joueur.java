package controler;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import model.Element;
import model.Joueur;

public class G_Joueur {
    /**
     * @associates <{uml.Joueur}>
     */
    static List<Joueur> listeJoueur= new ArrayList<Joueur>();

    public static void ajouterAction(Element e) {
    }

    public static void deplacerJoueur(Element e, Joueur j) {
    }
    
    /* renvoie la position du personnage */
    public static Element positionPers(Joueur j) {
    	//TODO
    	return null;
    }
    

    public static void initialiserJoueur() {
    	listeJoueur.add(new Joueur(Color.BLUE,"Joueur bleu",G_Element.getBase(Color.BLUE),Color.CYAN));
    	listeJoueur.add(new Joueur(Color.RED,"Joueur rouge",G_Element.getBase(Color.RED),Color.ORANGE));
    }

    public static void tuerJoueur(Integer id) {
    }

    public static void ajouterElementJoueur(Joueur j, Element e) {
    }

    public static void realiserProchaineAction() {
    }
    
    /* Change la postion du personnage */
    public static void deplacerPers(Joueur j, Element e) {
        if (e.getEstFranchissable()) { 
        	j.setEstSur(e);
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
