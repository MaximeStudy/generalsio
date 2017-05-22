package model;

import java.awt.Color;

public class Base extends Chateau {
    /**
     * @attribute
     */

    public Base(int x,int y, Color c) {
        super(x,y);
        this.setCouleur(c);
        this.setSoldats(1);
    }
    public String getNomElement() {
    	return "base";
    }

}
