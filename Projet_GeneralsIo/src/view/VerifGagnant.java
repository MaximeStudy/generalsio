package view;

import java.awt.Color;

import javax.swing.JOptionPane;

import controler.G_Joueur;

public class VerifGagnant implements Runnable {
	@Override
	public void run() {
		while(true)
		{
			try {
				// attente 1 seconde
				Thread.sleep(500);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Joueur : "+G_Joueur.getListeJoueur().get(0).getColor() +" "+G_Joueur.getListeJoueur().get(0).getColor());
			System.out.println("Joueur : "+G_Joueur.getListeJoueur().get(1).getColor() +" "+G_Joueur.getListeJoueur().get(1).getColor());

			if(G_Joueur.getListeJoueur().get(0).getBase().getCouleur()==G_Joueur.getListeJoueur().get(1).getColor())
			{
				JOptionPane.showMessageDialog(null, G_Joueur.getListeJoueur().get(1).getNom()+" gagne");
				System.exit(0);
			}
			else if (G_Joueur.getListeJoueur().get(1).getBase().getCouleur()==G_Joueur.getListeJoueur().get(0).getColor()) {
				JOptionPane.showMessageDialog(null, G_Joueur.getListeJoueur().get(0).getNom()+" gagne");
				System.exit(0);
			}

		}
	}
}
