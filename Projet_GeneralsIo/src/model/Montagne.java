package model;

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
    
}
