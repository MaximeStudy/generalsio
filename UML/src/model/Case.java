package model;

public class Case extends Element {
    /**
     * @attribute
     */
    private Integer nombreSoldats;

    /**
     * @attribute
     */
    private static String c_Type;

    /**
     * @attribute
     */
    Integer vitesseCreaSoldat;

    /**
     * @attribute
     */
    private Integer couleur;

    public Case(int x,int y)  {
        super(x,y);
    }
    public void setNombreSoldats(Integer nombreSoldats) {
        this.nombreSoldats = nombreSoldats;
    }

    public Integer getNombreSoldats() {
        return nombreSoldats;
    }

    public static void setC_Type(String c_Type) {
        Case.c_Type = c_Type;
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

    public void setCouleur(Integer couleur) {
        this.couleur = couleur;
    }

    public Integer getCouleur() {
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
}