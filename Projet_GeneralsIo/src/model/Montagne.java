package model;

import java.awt.Color;

public class Montagne extends Element {
    /**
     * @attribute
     */
    
    public Montagne(int x,int y) {
        super(x,y);
    }
    public Boolean getFranchissable() {
        return false;
    }
    public String getNomElement() {
    	return "montagne";
    }
    
    public Color getCouleur() {
        return Color.WHITE;
    }
    
    public int getSoldats() { 
    	return (Integer) 0;
    }
	@Override
	public Boolean getEstFranchissable() {
		return false;
	}

}
