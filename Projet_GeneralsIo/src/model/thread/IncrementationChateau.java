package model.thread;

import controler.G_Element;

public class IncrementationChateau implements Runnable {
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
			
			G_Element.incrementerChateaux();
		}
	}
}
