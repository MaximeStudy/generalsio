package model.thread;

import controler.G_Element;

public class IncrementationPlaine implements Runnable {
	@Override
	public void run() {
		while(true)
		{
			try {
				// attente 1 seconde
				Thread.sleep(10000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			G_Element.incrementerPlaine();
		}
	}
}
