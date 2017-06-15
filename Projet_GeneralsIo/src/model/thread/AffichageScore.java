package model.thread;

import javax.swing.JLabel;

import controler.G_Element;

public class AffichageScore implements Runnable {
	private JLabel ScoreB;
	private JLabel ScoreR;
	public AffichageScore(JLabel bleu, JLabel rouge) {
		ScoreB=bleu;
		ScoreR=rouge;
	}
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
			
			G_Element.affichageScore(ScoreB,ScoreR);
		}
	}
}
