
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.OutputStreamWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Fenetre extends JFrame {
    private String nom_a = "asdw", nom_b = "fleches";
    private int score[] = {0, 0};
    private int nb_partie = 0;
    private JButton bouton = new JButton();
    private JButton remise_zero = new JButton();
    private JLabel label = new JLabel();

    private void actualiser_param() {
        String str = String.format("Lancer une partie Generals.io << Partie %d >>", nb_partie);
        this.bouton.setText(str);
        str = String.format("Score ==> %s: %d et %s: %d", nom_a, score[0], nom_b, score[1]);
        this.label.setText(str);
    }

    public Fenetre() {
        this.remise_zero.setText("Remise à zéro");
        this.setTitle("General.io");
        this.setSize(400, 110);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new FlowLayout());
        actualiser_param();
        this.getContentPane().add(bouton);
        this.getContentPane().add(remise_zero);
        this.getContentPane().add(label);
        remise_zero.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nb_partie =  ZDialog.nb_ouverture = 0;
                score[0] = 0;
                score[1] = 0;
                actualiser_param();
            }
        }));

        bouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ZDialog zd = new ZDialog(null, "General.io", true);
                System.out.print(ZDialog.nb_ouverture);
                nb_partie = ZDialog.nb_ouverture;
                nom_a = zd.get_nom_r();
                nom_b = zd.get_nom_b();
                actualiser_param();
                ZDialogInfo zInfo = zd.showZDialog();
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, zInfo.toString(), "Data Game", JOptionPane.INFORMATION_MESSAGE);
                Runtime runtime = Runtime.getRuntime();
                try {
                    Process p = runtime.exec("java -jar  exec.jar");
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
                    BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));//ouput processus
                    out.write(zd.getIncre_t() + "\n");
                    out.write(zd.getIncre_plaine() + "\n");
                    out.write("fin" + "\n");
                    out.flush();
                    System.out.println("=====> lancement");
                    setVisible(false);
                    p.waitFor();

                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                    }
                    System.out.println("ok!");

                    in.close();
                    if (p.exitValue() == 1) {
                        score[0]++;
                    } else if (p.exitValue() == 2) {
                        score[1]++;
                    }
                    actualiser_param();
                    setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        this.setVisible(true);
    }
}
