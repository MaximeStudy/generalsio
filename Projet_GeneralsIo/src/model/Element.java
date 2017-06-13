package model;

import java.awt.Color;

public abstract class Element {
    /**
     * @attribute
     */
    private Integer y;
    private Integer x;
    private Boolean visible=false;
    private Joueur j=null;
    

	public Element(Integer x, Integer y) {
        this.x=x;
        this.y=y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getY() {
        return y;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getX() {
        return x;
    }

    public abstract Boolean getEstFranchissable();
    
    public abstract String getNomElement();
    
    public abstract Color getCouleur() ;
    
    public abstract int getSoldats() ;
    public abstract void setSoldats(int s) ;
    
}
