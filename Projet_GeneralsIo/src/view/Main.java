package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FenetreJeu j = new FenetreJeu();
		j.setVisible(true);							//rend la fenetre visible
		j.setLocation(10, 15);						//centre la fenetre
		
		//j.setDefaultCloseOperation(EXIT_ON_CLOSE); // arrete l'execution a la fermeture
	}
}
