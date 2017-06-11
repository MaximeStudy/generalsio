package model.thread;

import controler.G_Element;
import view.Main;

public class IncrementationPlaine implements Runnable {
	@Override
	public void run() {
		while(true)
		{
			try {
				double tmp = 1 / Main.incrementationP;
				int val = (int) (1000 * tmp);
				Thread.sleep(val);//10000
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			G_Element.incrementerPlaine();
		}
	}
}
