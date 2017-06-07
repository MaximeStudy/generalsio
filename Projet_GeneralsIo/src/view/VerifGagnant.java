package view;

import java.awt.Color;

import javax.swing.JOptionPane;
import controler.G_Joueur;

public class VerifGagnant 
{
			private static Color colorJ1;
			private static Color colorJ2;
			
			public VerifGagnant()
			{
				colorJ1=Color.BLUE;
				colorJ2=Color.RED;
			}
			
			public static void TestGagnant(Color colorAttaque,Color colorDefense)
			{	
				if(colorAttaque == colorDefense)
				{
					if (colorAttaque == colorJ1)
					{
					JOptionPane.showMessageDialog(null, "Bleu gagne");
					System.exit(0);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Rouge gagne");
						System.exit(0);
					}
				}
				
			}
}
