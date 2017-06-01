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
        return Color.GRAY;
    }
    
    public int getSoldats() { 
    	return (Integer) 0;
    }
	@Override
	//permet de dire si c'est une montagne ou non
	public Boolean getEstFranchissable() {
		return false;
	}
	@Override
	public void setSoldats(int s) {
		// TODO Auto-generated method stub
		
	}

}
