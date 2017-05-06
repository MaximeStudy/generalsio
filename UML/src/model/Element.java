package model;

public class Element {
    /**
     * @attribute
     */
    private Integer y;

    /**
     * @attribute
     */
    private Boolean visible;

    /**
     * @attribute
     */
    private Integer x;

    /**
     * @attribute
     */
    private Boolean estFranchissable;

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

    public void setEstFranchissable(Boolean estFranchissable) {
        this.estFranchissable = estFranchissable;
    }

    public Boolean getEstFranchissable() {
        return estFranchissable;
    }

}
