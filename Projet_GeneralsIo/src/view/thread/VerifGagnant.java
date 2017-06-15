package view.thread;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import controler.G_Joueur;
import view.form.*;

public class VerifGagnant implements Runnable {
	@Override
	public void run() {
		int keyCode = KeyEvent.VK_P; // the A key

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

			if(G_Joueur.getListeJoueur().get(0).getBase().getCouleur()==G_Joueur.getListeJoueur().get(1).getColor()) {
				JOptionPane.showMessageDialog(null, G_Joueur.getListeJoueur().get(1).getNom()+" gagne");
				try {
					Robot r = new Robot();
					r.keyRelease(keyCode);
				}			
			     catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if (G_Joueur.getListeJoueur().get(1).getBase().getCouleur()==G_Joueur.getListeJoueur().get(0).getColor()) {
				JOptionPane.showMessageDialog(null, G_Joueur.getListeJoueur().get(0).getNom()+" gagne");
				try {
					Robot r = new Robot();
					r.keyRelease(keyCode);
				}			
			     catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		}
		
	}
}
