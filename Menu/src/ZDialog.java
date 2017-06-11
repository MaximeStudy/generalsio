
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

public class ZDialog extends JDialog {
    private ZDialogInfo zInfo = new ZDialogInfo();
    private boolean sendData;
    private JLabel login_rouge_Label, login_bleu_Label, incre_plaineLabel, incre_plaine2Label, incre_tLabel, incre_t2Label;
    private JTextField nom_r, nom_b, incre_t, incre_plaine;
    public static int nb_ouverture;

    public ZDialog(JFrame parent, String title, boolean modal){
        super(parent, title, modal);
        nb_ouverture++;
        this.setSize(550, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.initComponent();
    }

    public ZDialogInfo showZDialog(){
        this.sendData = false;
        this.setVisible(true);
        return this.zInfo;
    }

    public String get_nom_r() {
        return (this.nom_r.getText());
    }
    public String get_nom_b() {
        return this.nom_b.getText();
    }

    public String getIncre_t(){
        System.out.println(Double.parseDouble(incre_t.getText()));
        if ( Double.parseDouble(incre_t.getText()) < 1) {
            return ("1");
        }
        return (incre_t.getText().equals("")) ? "1" : incre_t.getText();
    }
    public String getIncre_plaine() {
        if ( Double.parseDouble(incre_plaine.getText()) > 0.5) {
            return ("0.1");
        }
        return (incre_plaine.getText().equals("")) ? "0.1" : incre_plaine.getText();
    }

    static {
        nb_ouverture = 0;
    }

    private void initComponent() {
        //Le nom
        JPanel panNom_r = new JPanel();
        panNom_r.setBackground(Color.white);
        panNom_r.setPreferredSize(new Dimension(220, 60));
        nom_r = new JTextField("User_a");
        nom_r.setPreferredSize(new Dimension(100, 25));
        panNom_r.setBorder(BorderFactory.createTitledBorder("Nom joueur rouge"));
        login_rouge_Label = new JLabel("Saisir un nom :");
        panNom_r.add(login_rouge_Label);
        panNom_r.add(nom_r);

        //nom_b
        JPanel panNom_b = new JPanel();
        panNom_b.setBackground(Color.white);
        panNom_b.setPreferredSize(new Dimension(220, 60));
        nom_b = new JTextField("User_b");
        nom_b.setPreferredSize(new Dimension(100, 25));
        panNom_b.setBorder(BorderFactory.createTitledBorder("Nom joueur bleu"));
        login_bleu_Label = new JLabel("Saisir un nom :");
        panNom_b.add(login_bleu_Label);
        panNom_b.add(nom_b);

        //La incre base
        JPanel panIncre_t = new JPanel();
        panIncre_t.setBackground(Color.white);
        panIncre_t.setPreferredSize(new Dimension(220, 70));
        panIncre_t.setBorder(BorderFactory.createTitledBorder("Incrementation Base"));
        incre_tLabel = new JLabel("Vitesse (supérieur à 1) : ");
        incre_t2Label = new JLabel(" slt/s");
        incre_t = new JTextField("1");
        incre_t.setPreferredSize(new Dimension(90, 30));
        panIncre_t.add(incre_tLabel);
        panIncre_t.add(incre_t);
        panIncre_t.add(incre_t2Label);

        //La incre Plaine
        JPanel panIncre_plaine = new JPanel();
        panIncre_plaine.setBackground(Color.white);
        panIncre_plaine.setPreferredSize(new Dimension(220, 70));
        panIncre_plaine.setBorder(BorderFactory.createTitledBorder("Incrementation Plaine"));
        incre_plaineLabel = new JLabel("Vitesse (inférieur à 0.5) : ");
        incre_plaine2Label = new JLabel(" slt/s");
        incre_plaine = new JTextField("0.1");
        incre_plaine.setPreferredSize(new Dimension(90, 30));
        panIncre_plaine.add(incre_plaineLabel);
        panIncre_plaine.add(incre_plaine);
        panIncre_plaine.add(incre_plaine2Label);

        JPanel content = new JPanel();
        content.setBackground(Color.white);
        content.add(panNom_r);
        content.add(panNom_b);
        content.add(panIncre_t);
        content.add(panIncre_plaine);

        JPanel control = new JPanel();
        JButton okBouton = new JButton("OK");

        okBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                zInfo = new ZDialogInfo(nom_r.getText(), nom_b.getText(), getIncre_t()  ,getIncre_plaine());
                setVisible(false);
            }
        });

        JButton cancelBouton = new JButton("Annuler");
        cancelBouton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
            }
        });

        control.add(okBouton);
        control.add(cancelBouton);

        this.getContentPane().add(content, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);
    }}
