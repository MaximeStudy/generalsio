package model;

public class Chateau extends Case {
    /**
     * @attribute
     */
    private static String c_Type;
    
    public Chateau(int x,int y) {
        super(x,y);
    }

    public static void setC_Type(String c_Type) {
        Chateau.c_Type = c_Type;
    }

    public static String getC_Type() {
        return c_Type;
    }
}
