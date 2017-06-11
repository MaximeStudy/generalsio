
public class ZDialogInfo {
    private String nom_a, nom_b,incre_t, incre_plaine;

    public ZDialogInfo(){}
    public ZDialogInfo(String nom_a, String nom_b, String incre_t, String incre_plaine){
        this.nom_a = nom_a;
        this.nom_b = nom_b;
        this.incre_t = incre_t;
        this.incre_plaine = incre_plaine;
    }

    public String toString() {
        String str;
        if(this.nom_a != null && this.nom_b != null && this.incre_t != null && this.incre_plaine != null){
            str = "Paramètres: \n";
            str += "Nom Rouge : " + this.nom_a + "\n";
            str += "Nom Bleu : " + this.nom_b + "\n";
            str += "Incrementation Tour : " + this.incre_t + "\n";
            str += "Incrementation Plaine : " + this.incre_plaine + "\n";
        }
        else{
            str = "Aucune information !";
        }
        return str;
    }
}
