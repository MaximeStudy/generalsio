package view.form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class EcranPrincipal extends JPanel 
{

    private JLabel lblTitre=new JLabel("Generals.io");
    private JButton jbJouer = new JButton("Jouer");
    private JButton jbQuitter = new JButton("Quitter");
    
    private JPanel jpMenu = this;
    private JPanel jpTitre=new JPanel();
    private JPanel jpMilieu=new JPanel();
    
    public EcranPrincipal(FenetreJeu fenetreJeu, JLayeredPane JL_Pane, JTextField jtfSaisi) 
    {
    	
    jpMilieu.setPreferredSize(new Dimension(200, 200));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(10, 0, 0, 0);
    gbc.anchor = GridBagConstraints.NORTHWEST;
    
    /* Ajout des boutons dans le panelMilieu*/
    jpMilieu.setLayout(new GridBagLayout());
    
    jpMilieu.add(jbJouer, gbc);
    gbc.gridy++;
    jpMilieu.add(jbQuitter, gbc);
    
    Dimension d=new Dimension(125, 25);
    jbJouer.setPreferredSize(d);
    jbQuitter.setPreferredSize(d);
    

    /* Ajout du titre dans le panel de titre */
    lblTitre.setFont(new Font("Arial",Font.BOLD,35));
    jpTitre.add(lblTitre);
    
    /* ajout dans le panel principale */
    jpMenu.setLayout(new BorderLayout()); 
    
    jpMenu.add(jpTitre,BorderLayout.NORTH);
    jpMenu.add(jpMilieu,BorderLayout.CENTER);
    
    
    //même chose pour Jouer
    jbJouer.addActionListener(new ActionListener() 
    {
        public void actionPerformed(ActionEvent e) 
        {
        	fenetreJeu.setContentPane(JL_Pane);
        	JL_Pane.revalidate();
        	JL_Pane.repaint();
            jtfSaisi.requestFocusInWindow();
            fenetreJeu.InitCarte();
        }
    });
    
    //on quitte quand on clique sur quitter
    jbQuitter.addActionListener(new ActionListener() 
    {
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0);
        }
    });
    
    }
}
