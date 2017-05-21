package view;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import controler.G_Element;
import model.Element;

public class ChronoDeplacement implements Runnable {

	@Override
	public void run() {
		while(true)
		{
			try {
				// attente 1 seconde
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    Font f=new Font("Calibri",Font.CENTER_BASELINE,21);
			/* Parcours tous les elements et les affiche dans la bonne couleur*/
			for(int i=0;i<G_Element.getTousLesElements().size();i++)
			{
				Element e=G_Element.getTousLesElements().get(i);
				FenetreJeu.setCouleur(e.getCouleur(), FenetreJeu.getJL_cases()[e.getX()][e.getY()]);
				//FenetreJeu.setTexte("coucou", FenetreJeu.getJL_cases()[e.getX()][e.getY()]);
					
				FenetreJeu.getJL_cases()[e.getX()][e.getY()].setText(Integer.toString(e.getSoldats()));
				
			}
		}
	}

}
