package model;

import java.util.concurrent.ThreadLocalRandom;

public class Chateau extends Plaine {
    /**
     * @attribute
     */
    public Chateau(int x,int y) {
        super(x,y);
        super.setCouleur(CouleurChateau);
        /* Les soldats de departs du chateau est genere aleatoirement */
        this.setSoldats(ThreadLocalRandom.current().nextInt(40, 50 + 1));
    }
    public String getNomElement() {
    	return "chateau";
    }
}
