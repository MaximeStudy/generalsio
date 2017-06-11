package model.thread;

import controler.G_Element;
import view.Main;

public class IncrementationChateau implements Runnable {
	@Override
	public void run() {
		while(true)
		{
			try {
				double tmp = 1 / Main.incrementationC;
				int val = (int) (1000 * tmp);
				Thread.sleep(val);//500
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			G_Element.incrementerChateaux();
		}
	}
}
