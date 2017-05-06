package model;

import java.util.Collection;
import java.util.List;

public class Joueur {
    /**
     * @attribute
     */
    private Boolean vie;

    /**
     * @attribute
     */
    private Integer id;

    /**
     * @attribute
     */
    private String nom;

    /**
     * @attribute
     */
    private List<Joueur> mesJoueurs;

    List<Element> ListMesCases;
    Element EstSur;


    public void setVie(Boolean vie) {
        this.vie = vie;
    }

    public Boolean getVie() {
        return vie;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setMesJoueurs(List<Joueur> mesJoueurs) {
        this.mesJoueurs = mesJoueurs;
    }

    public List<Joueur> getMesJoueurs() {
        return mesJoueurs;
    }

    public void setListMesCases(List<Element> ListMesCases) {
        this.ListMesCases = ListMesCases;
    }

    public List<Element> getListMesCases() {
        return ListMesCases;
    }

    public void setEstSur(Element EstSur) {
        this.EstSur = EstSur;
    }

    public Element getEstSur() {
        return EstSur;
    }

    public void getJoueur(Integer id) {
    }

    public void PrendreSoldat() {
    }
    
    public Integer sommeCase() {
        return 0;
    }
    
    public void RecupererSoldat(Element e) {
    }
    
    public Integer sommeArmee() {
        return 0;
    }


}
