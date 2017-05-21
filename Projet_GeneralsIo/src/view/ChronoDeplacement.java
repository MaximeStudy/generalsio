package view;

import java.awt.Color;

import controler.G_Element;

public class ChronoDeplacement implements Runnable{

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
			
			/* Parcours tous les elements et les affiche dans la bonne couleur*/
			for(int i=0;i<G_Element.getTousLesElements().size();i++)
			{
				FenetreJeu.setCouleur(G_Element.getTousLesElements().get(i).getCouleur(), FenetreJeu.getJL_cases()[G_Element.getTousLesElements().get(i).getX()][G_Element.getTousLesElements().get(i).getY()]);

				System.out.println(G_Element.getTousLesElements().get(i).getCouleur());
			}
		}
	}

}
