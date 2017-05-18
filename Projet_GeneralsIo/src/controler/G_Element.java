package controler;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;

import model.Joueur;
import model.Element;

public class G_Element {

    /**
     * @associates <{uml.Element}>
     */
    private static List<Element> mesElements;
    
    public static List<Element> getTousLesElements() {
        return mesElements;
    }
    

    /* Renvoie la liste d'elements qui se situe autour du personnage */
    public static List<Element> getElementAutourPerso(Element e) {
        List<Element> li = new ArrayList<Element>();
        Element e1 = getElementHaut(e); //au dessus
        if (e1 != e) {
            li.add(e1);
        }
        Element e2 = getElementBas(e); //en dessous
        if (e2 != e) {
            li.add(e2);
        }
        Element e3 = getElementDroite(e); // a droite
        if (e3 != e) {
            li.add(e3);
        }
        Element e4 = getElementGauche(e); //a gauche
        if (e4 != e) {
            li.add(e4);
        }
        Element e5 = getElementBasDroite(e); //bas a droite
        if (e5 != e) {
            li.add(e5);
        }
        Element e6 = getElementBasGauche(e);
        if (e6 != e) {
            li.add(e6);
        }
        Element e7 = getElementHautDroite(e); //haut droite
        if (e7 != e) {
            li.add(e7);
        }
        Element e8 = getElementHautGauche(e);
        if (e8 != e) {
            li.add(e8);
        }
        return li;
    }
    /* Foncton permettant de remplir le plateau */
    public static Element remplirPlateau() {
    	//TODO

    	return null;
    }
    
    /* Recup�re l'element de en-dessus par rapport � la position e */
    public static Element getElementBas(Element e) {
        Element e1 = getElement(e.getX() + 1, e.getY());
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }
    /* Recup�re l'element de en-bas � gauche par rapport � la position e */
    public static Element getElementBasGauche(Element e) {
        Element e1 = getElement(e.getX() + 1, e.getY() - 1);
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }

    /* Recup�re l'element de en-haut � droite par rapport � la position e */
    public static Element getElementHautDroite(Element e) {
        Element e1 = getElement(e.getX() - 1, e.getY() + 1);
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }

    /* Recup�re l'element de haut-dessus par rapport � la position e */
    public static Element getElementHaut(Element e) {
        Element e1 = getElement(e.getX() - 1, e.getY());
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }

    /* Recup�re l'element de gauche par rapport � la position e */
    public static Element getElementGauche(Element e) {
        Element e1 = getElement(e.getX(), e.getY() - 1);
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }

    /* Recup�re l'element de en-bas � droite par rapport � la position e */
    public static Element getElementBasDroite(Element e) {
        Element e1 = getElement(e.getX() + 1, e.getY() + 1);
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }
    
    
    /* Recup�re l'element de en-haut � gauche par rapport � la position e */
    public static Element getElementHautGauche(Element e) {
        Element e1 = getElement(e.getX() - 1, e.getY() - 1);
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }

    public static Element getDebut(Element e) {
    	return null;
    }
    
    /* Recup�re l'element de droite par rapport � la position e */
    public static Element getElementDroite(Element e) {
        Element e1 = getElement(e.getX(), e.getY() + 1);
        if (e1 == null) { // pour ne pas bouger si la case n'existe pas
            e1 = e;
        }
        return e1;
    }
    
    /* Renvoie l'�lement � la postion x et y -> null si il existe pas */
    public static Element getElement(Integer x, Integer y) {
        Element res = null;
        for (Element e : getTousLesElements()) {
            if (e.getX() == x && e.getY() == y) {
                res = e;
                break;
            }
        }
        return res;
    }
    
    /* Cr�ation d'un element al�atoire*/
    public static Element elementAlea() {
    	//TODO
    	return null;
    }

   
}
