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
    

    public static Joueur initialiserJoueur(Element e) {
    	listeJoueur.add(new Joueur());
    	return null;
    }
    
    public static void creationJoueur()
    {
    	
    }
    

    public static void tuerJoueur(Integer id) {
    }

    public static void ajouterElementJoueur(Joueur j, Element e) {
    }

    public static void realiserProchaineAction() {
    }
    
    /* Change la postion du personnage */
    public static void deplacerPers(Element e) {
    	//TODO
    }
    
    public void setListeJoueur(List<Joueur> listeJoueur) {
        this.listeJoueur = listeJoueur;
    }

    public List<Joueur> getListeJoueur() {
        return listeJoueur;
    }
    
    public Joueur getJoueur(Color col) {
        int i;
        for(i=0;i<listeJoueur.size();i++) {
            if (listeJoueur.get(i).getColor()==col)
                break;
        }
        return listeJoueur.get(i);
    }
}
