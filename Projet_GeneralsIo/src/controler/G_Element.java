package controler;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;

import model.Joueur;
import model.Montagne;
import model.Plaine;
import model.Base;
import model.Chateau;
import model.Element;

public class G_Element {

    /**
     * @associates <{uml.Element}>
     */
    private static List<Element> mesElements;
    
    public static List<Element> getTousLesElements() {
        return mesElements;
    }
    

    /* Renvoie la liste d'elements qui se situe autour du personnage */
    public static List<Element> getElementAutourPerso(Element e) {
        List<Element> li = new ArrayList<Element>();
        Element e1 = getElementHaut(e); //au dessus
        if (e1 != e) {
            li.add(e1);
        }
        Element e2 = getElementBas(e); //en dessous
        if (e2 != e) {
            li.add(e2);
        }
        Element e3 = getElementDroite(e); // a droite
        if (e3 != e) {
            li.add(e3);
        }
        Element e4 = getElementGauche(e); //a gauche
        if (e4 != e) {
            li.add(e4);
        }
        Element e5 = getElementBasDroite(e); //bas a droite
        if (e5 != e) {
            li.add(e5);
        }
        Element e6 = getElementBasGauche(e);
        if (e6 != e) {
            li.add(e6);
        }
        Element e7 = getElementHautDroite(e); //haut droite
        if (e7 != e) {
            li.add(e7);
        }
        Element e8 = getElementHautGauche(e);
        if (e8 != e) {
            li.add(e8);
        }
        return li;
    }
    /* Foncton permettant de remplir le plateau */
    public static Element remplirPlateau() {
    	//TODO
    	/* Rempli le plateau avec des plaines */
    	for(int i=0;i<18;i++)
		{
			for(int j=0;j<18;j++)
			{
				ajouterPlaine(i,j);
			}
		}
    	
		/*Base b1=new Base();
		coordBase1= new int[2];
		coordBase2= new int[2];
		
		tabCoord = new boolean[18][18];	//tableau pour tester les cases occupï¿½es
	
		for (int i=0; i<18; i++)
		{
			for (int j=0; j<18; j++)
			{
				tabCoord[i][j]=false;
			}
		}

		xAlea=(int) (Math.random()*(COLONNE));  //Math.random()*( max - mini + 1 ) ) + mini;
		yAlea=(int) (Math.random()*((LIGNE-2)/2));  //Math.random()*( max - mini + 1 ) ) + mini;
		tabCoord[xAlea][yAlea]=true;
		coordBase1[0]=xAlea;
		coordBase1[1]=yAlea;
		setIcon(chateau, JL_cases[xAlea][yAlea]);  // on pop la premiï¿½re base dans la moitiï¿½ supï¿½rieur de la carte
		setCouleur(Color.BLUE, JL_cases[xAlea][yAlea]);
		setTexte("1",JL_cases[xAlea][yAlea]);
		//JL_cases[xAlea][yAlea].setBorder(BorderFactory.createLineBorder(Color.white, 2));	// encadre case
		
		xAlea=(int) (Math.random()*(COLONNE));  //Math.random()*( max - mini + 1 ) ) + mini;		
		yAlea=(int) (Math.random()*((LIGNE-1)-((LIGNE+2)/2))+((LIGNE+2)/2));  //Math.random()*( max - mini + 1 ) ) + mini;
		tabCoord[xAlea][yAlea]=true;
		coordBase2[0]=xAlea;
		coordBase2[1]=yAlea;
		setIcon(chateau, JL_cases[xAlea][yAlea]);  // on pop la deuxiï¿½me base dans la moitiï¿½ infï¿½rieur de la carte
		setCouleur(Color.RED, JL_cases[xAlea][yAlea]);
		setTexte("1",JL_cases[xAlea][yAlea]);
		//JL_cases[xAlea][yAlea].setBorder(BorderFactory.createLineBorder(Color.white, 2));	// encadre case

		//on genre un chemin vide en L d'une base a l'autre
		if (coordBase1[0]>coordBase2[0])	
		{
			for (int i=coordBase1[0]-1; i>= coordBase2[0]; i--)
			{
				tabCoord[i][coordBase1[1]]=true;
				tmp=i;
			}
		}
		else
		{
			for (int i=coordBase1[0]+1; i<= coordBase2[0]; i++)
			{
				tabCoord[i][coordBase1[1]]=true;
				tmp=i;
			}	
		}

		for (int i=coordBase1[1]+1; i< coordBase2[1]; i++)
		{
			tabCoord[tmp][i]=true;
		}
		
		
		
		for (int i=0; i< NBRTOUR; i++)
		{
			xAlea=(int) (Math.random()*(COLONNE));  //Math.random()*( max - mini + 1 ) ) + mini;
			yAlea=(int) (Math.random()*(LIGNE));  //Math.random()*( max - mini + 1 ) ) + mini;}
			if (tabCoord[xAlea][yAlea] == false)
			{
				setImgTour(JL_cases[xAlea][yAlea]);
				tabCoord[xAlea][yAlea]=true;		
			}
			else
			{
				i--;
			}
		}
		
		for (int i=0; i< NBRMONTAGNE; i++)
		{
			xAlea=(int) (Math.random()*(COLONNE));  //Math.random()*( max - mini + 1 ) ) + mini;
			yAlea=(int) (Math.random()*(LIGNE));  //Math.random()*( max - mini + 1 ) ) + mini;
			if (tabCoord[xAlea][yAlea] == false)
			{
				setImgMontagne(JL_cases[xAlea][yAlea]);
				tabCoord[xAlea][yAlea]=true;
			}
			else
			{
				i--;
			}
		} */
		//lance l'ecoute des joueurs

    	return null;
    }
    
    /* Recupère l'element de en-dessus par rapport à la position e */
    public static Element getElementBas(Element e) {
        Element e1 = getElement(e.getX() + 1, e.getY());
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }
    /* Recupère l'element de en-bas à gauche par rapport à la position e */
    public static Element getElementBasGauche(Element e) {
        Element e1 = getElement(e.getX() + 1, e.getY() - 1);
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }

    /* Recupère l'element de en-haut à droite par rapport à la position e */
    public static Element getElementHautDroite(Element e) {
        Element e1 = getElement(e.getX() - 1, e.getY() + 1);
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }

    /* Recupère l'element de haut-dessus par rapport à la position e */
    public static Element getElementHaut(Element e) {
        Element e1 = getElement(e.getX() - 1, e.getY());
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }

    /* Recupère l'element de gauche par rapport à la position e */
    public static Element getElementGauche(Element e) {
        Element e1 = getElement(e.getX(), e.getY() - 1);
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }

    /* Recupère l'element de en-bas à droite par rapport à la position e */
    public static Element getElementBasDroite(Element e) {
        Element e1 = getElement(e.getX() + 1, e.getY() + 1);
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }
    
    
    /* Recupère l'element de en-haut à gauche par rapport à la position e */
    public static Element getElementHautGauche(Element e) {
        Element e1 = getElement(e.getX() - 1, e.getY() - 1);
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }

    public static Element getDebut(Element e) {
    	return null;
    }
    
    /* Recupère l'element de droite par rapport à la position e */
    public static Element getElementDroite(Element e) {
        Element e1 = getElement(e.getX(), e.getY() + 1);
        if (e1 == null) { // pour ne pas bouger si la case n'existe pas
            e1 = e;
        }
        return e1;
    }
    
    /* Renvoie l'élement à la postion x et y -> null si il existe pas */
    public static Element getElement(Integer x, Integer y) {
        Element res = null;
        for (Element e : getTousLesElements()) {
            if (e.getX() == x && e.getY() == y) {
                res = e;
                break;
            }
        }
        return res;
    }
    
    
    public static void ajouterPlaine(int x,int y)
    {
    	mesElements.add(new Plaine(x,y));
    }
    
    public static void ajouterBase(int x,int y)
    {
    	mesElements.add(new Base(x,y));
    }
    
    public static void ajouterChateau(int x,int y)
    {
    	mesElements.add(new Chateau(x,y));
    }
    
    public static void ajouterMontagne(int x,int y)
    {
    	mesElements.add(new Montagne(x,y));
    }

    
   
}
