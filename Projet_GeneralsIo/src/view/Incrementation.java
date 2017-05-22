package view;

import controler.G_Element;

public class Incrementation implements Runnable {
	@Override
	public void run() {
		while(true)
		{
			try {
				// attente 1 seconde
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			G_Element.incrementerPlaine();
			
		}
	}
}
