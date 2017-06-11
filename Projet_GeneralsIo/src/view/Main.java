package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.Double;
import javax.swing.JFrame;
import view.form.FenetreJeu;

public class Main {
	static public double incrementationP;
	static public double incrementationC;
	static {
		incrementationP = 1;
		incrementationC = 1;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String line;
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
	    int i = 0;
	    while (!"fin".equals(line = reader.readLine())) {
	        System.err.println(line);
	        if (i == 1) {
	        	incrementationP =  Double.parseDouble(line);
	        } else if (i == 0) {
	        	incrementationC =  Double.parseDouble(line);
	        }
	        i++;
	    }
		FenetreJeu j = new FenetreJeu();
		j.setVisible(true);							//rend la fenetre visible
		j.setLocation(10, 15);						//centre la fenetre
		
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // arrete l'execution a la fermeture
	}
}
