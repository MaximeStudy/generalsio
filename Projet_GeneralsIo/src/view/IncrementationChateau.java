package view;

import controler.G_Element;

public class IncrementationChateau implements Runnable {
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
			
			G_Element.incrementerChateaux();
		}
	}
}
