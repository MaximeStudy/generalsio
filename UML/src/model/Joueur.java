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

    List<Case> ListMesCases;
    Case EstSur;


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

    public void setListMesCases(List<Case> ListMesCases) {
        this.ListMesCases = ListMesCases;
    }

    public List<Case> getListMesCases() {
        return ListMesCases;
    }

    public void setEstSur(Element Case) {
        this.EstSur = EstSur;
    }

    public Case getEstSur() {
        return EstSur;
    }

    public Joueur getJoueur(Integer id) {
        int i;
        for(i=0;i<this.mesJoueurs.size();i++) {
            if (mesJoueurs.get(i).getId()==id)
                break;
        }
        return mesJoueurs.get(i);
    }

    public void PrendreSoldatSuivent(Element e) {
        //this.getEstSur().prendreSoldats();
    }
    
    public Integer sommeCase() {
        return 0;
    }
    
    public void RecupererSoldat(Case e) {
        
    }
    
    public int sommeArmee() {
        int somme=0;
        for(int i=0;i<this.getListMesCases().size();i++) {
            somme+=this.getListMesCases().get(i).getNombreSoldats();
        }
        return somme;
    }
}
