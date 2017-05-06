package model;

import java.util.Collection;
import java.util.List;

public class Plateau {
    /**
     * @associates <{uml.Element}>
     */
    public static List<Element> listElement;
    public static int nbJoueur=2;


    public static void setListElement(List<Element> listElement) {
        Plateau.listElement = listElement;
    }

    public static List<Element> getListElement() {
        return listElement;
    }

    public static void creerJoueur() {
        
    }

    public static void positionerJoueur() {
    }

    public static void InitaliserCarte() {
    }

    public static Plateau getPlateau() {
        return new Plateau();
    }
}
