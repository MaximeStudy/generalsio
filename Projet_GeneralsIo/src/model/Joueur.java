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

    Element estSur=null;
    Base base=null;
    
	public Base getBase() {
		return base;
	}

	public Joueur(Color col, String nom, Element estSur, Color encadrement)    {
    	this.col=col;
    	this.nom=nom;
    	this.estSur=estSur;
    	this.encadrement=encadrement;
    	this.base=(Base)estSur;
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
        
        return somme;
    }
}
