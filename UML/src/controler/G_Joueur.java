package controler;

import java.util.Collection;

import java.util.List;

import model.Element;
import model.Joueur;

public class G_Joueur {
    /**
     * @associates <{uml.Joueur}>
     */
    List<Joueur> listeJoueur;

    public static void ajouterAction(Element e) {
    }

    public static void deplacerJoueur(Element e, Joueur j) {
    }
    
    /* renvoie la position du personnage */
    public static Element positionPers(Joueur j) {
    }
    

    public static Joueur initialiserJoueur(Element e) {
    }

    public static void tuerJoueur(Integer id) {
    }

    public static void ajouterElementJoueur(Joueur j, Element e) {
    }

    public static void realiserProchaineAction() {
    }
    
    /* Change la postion du personnage */
    public static void deplacerPers(Element e) {
        Personnage.getMonPersonnage().setEstSur(e);
    }
}
