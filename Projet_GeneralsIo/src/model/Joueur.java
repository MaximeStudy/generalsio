package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Joueur {
    /**
     * @attribute
     */
    private Boolean vie;

    /**
     * @attribute
     */
    private Color col;
    private Color encadrement;

    /**
     * @attribute
     */
    private String nom;

    /**
     * @attribute
     */

    List<Plaine> ListMesCases=new ArrayList<Plaine>();
    Element estSur=null;
    
    public Joueur(Color col, String nom, Element estSur, Color encadrement)    {
    	this.col=col;
    	this.nom=nom;
    	this.estSur=estSur;
    	this.encadrement=encadrement;
    }
    

    public void setVie(Boolean vie) {
        this.vie = vie;
    }

    public Boolean getVie() {
        return vie;
    }

    public void setColor(Color c) {
        this.col = c;
    }

    public Color getColor() {
        return col;
    }
    
    public void setEncadrement(Color c) {
        this.encadrement = c;
    }

    public Color getEncadrementr() {
        return encadrement;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setListMesCases(List<Plaine> ListMesCases) {
        this.ListMesCases = ListMesCases;
    }

    public List<Plaine> getListMesPlaines() {
        return ListMesCases;
    }

    public void setEstSur(Element c) {
        this.estSur = c;
    }

    public Element getEstSur() {
        return estSur;
    }

    public void PrendreSoldatSuivent(Element e) {
        //this.getEstSur().prendreSoldats();
    }
    
    public Integer sommeCase() {
        return 0;
    }
    
    public void RecupererSoldat(Plaine e) {
        
    }
    
    public int sommeArmee() {
        int somme=0;
        for(int i=0;i<this.getListMesPlaines().size();i++) {
            somme+=this.getListMesPlaines().get(i).getNombreSoldats();
        }
        return somme;
    }
}
