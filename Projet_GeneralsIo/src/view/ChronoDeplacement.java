package view;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import controler.G_Element;
import model.Chateau;
import model.Element;

public class ChronoDeplacement implements Runnable {

	@Override
	public void run() {
		Font font = new Font("Calibri",Font.CENTER_BASELINE,18);
		while(true)
		{
			try {
				// attente 1 seconde
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    Font f=new Font("Calibri",Font.CENTER_BASELINE,21);
			/* Parcours tous les elements et les affiche dans la bonne couleur*/
			for(int i=0;i<G_Element.getTousLesElements().size();i++)
			{
				Element e=G_Element.getTousLesElements().get(i);
				FenetreJeu.setCouleur(e.getCouleur(), FenetreJeu.getJL_cases()[e.getX()][e.getY()]);
				if(e instanceof Chateau)
				{
					
					if(FenetreJeu.getJL_cases()[e.getX()][e.getY()].getComponents().length !=0)
					{
						JLabel jl2=(JLabel) FenetreJeu.getJL_cases()[e.getX()][e.getY()].getComponent(0);
						jl2.setText(Integer.toString(e.getSoldats()));
					}
					else {
						JLabel jl2=new JLabel();
						jl2.setFont(font);
						jl2.setForeground(new Color(255,255,255));
						jl2.setHorizontalAlignment(JLabel.CENTER);
						jl2.setVerticalAlignment(JLabel.CENTER);
						jl2.setText(Integer.toString(e.getSoldats()));
						FenetreJeu.getJL_cases()[e.getX()][e.getY()].add(jl2);
					}
					
				}
				else
				{
					FenetreJeu.getJL_cases()[e.getX()][e.getY()].setText(Integer.toString(e.getSoldats()));
				}
				
			}
		}
	}

}
