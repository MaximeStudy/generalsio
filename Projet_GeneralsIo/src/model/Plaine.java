package model;

import java.awt.Color;

public class Plaine extends Element{
	  /**
     * @attribute
     */
    protected int nombreSoldats;

    /**
     * @attribute
     */
    private static String c_Type;

    /**
     * @attribute
     */
    int vitesseCreaSoldat;

    /**
     * @attribute
     */
    private Color couleur = Color.white;
    
    private static Joueur j=null;
    
    public Joueur getJ() {
		return j;
		
	}

	public void setJ(Joueur j) {
		this.j = j;
		this.couleur=j.getColor();
	}
	
    public Plaine(int x,int y)  {
        super(x,y);
    }
    public void setNombreSoldats(Integer nombreSoldats) {
        this.nombreSoldats = nombreSoldats;
    }

    public Integer getNombreSoldats() {
        return nombreSoldats;
    }

    public static void setC_Type(String c_Type) {
        Plaine.c_Type = c_Type;
    }

    public static String getC_Type() {
        return c_Type;
    }

    public void setVitesseCreaSoldat(Integer vitesseCreaSoldat) {
        this.vitesseCreaSoldat = vitesseCreaSoldat;
    }

    public Integer getVitesseCreaSoldat() {
        return vitesseCreaSoldat;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public Color getCouleur() {
        return couleur;
    }
    
    public int prendreSoldats(){
        int nb=this.getNombreSoldats();
        this.setNombreSoldats(1);
        return nb;
    }

    public void incrementerSoldat() {
        this.nombreSoldats++;
    }
    
    public String  getNomElement() {
    	return "plaine";
    }
    
    public int getSoldats() { 
    	return nombreSoldats;
    }
    public Boolean getEstFranchissable() {
    	return true;
    }

	@Override
	public void setSoldats(int s) {
		this.nombreSoldats=s;
	}

    
}


