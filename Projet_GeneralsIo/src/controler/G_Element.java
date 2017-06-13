package controler;

import java.awt.Color;
import java.util.ArrayList;

import java.util.List;

import model.Montagne;
import model.Plaine;
import model.Base;
import model.Chateau;
import model.Element;

public class G_Element {

    /**
     * @associates <{uml.Element}>
     */
    private static List<Element> mesElements = new ArrayList<Element>();
    
    public static List<Element> getTousLesElements() {
        return mesElements;
    }
    
    private static int nombreMontagne=65;
	private static int nombreChateau=22;
	private static Color colJ1=Color.BLUE;
	private static Color colJ2=Color.RED;
	
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
    public static void remplirPlateau() {
    	G_Element.getTousLesElements().clear();
    	/* Rempli le plateau avec des plaines */
    	for(int i=0;i<18;i++)
		{
			for(int j=0;j<18;j++)
			{
				G_Element.ajouterPlaine(i, j);
			}
		}
				
    	/* Cree les deux bases */
		int xAlea=(int) (Math.random()*(18));  //Math.random()*( max - mini + 1 ) ) + mini;
		int yAlea=(int) (Math.random()*((18-2)/2));  //Math.random()*( max - mini + 1 ) ) + mini;
		
		supprimerElement(getElement(xAlea,yAlea));
		G_Element.ajouterBase(xAlea, yAlea,colJ1);
		
		xAlea=(int) (Math.random()*(18));  //Math.random()*( max - mini + 1 ) ) + mini;		
		yAlea=(int) (Math.random()*((18-1)-((18+2)/2))+((18+2)/2));  //Math.random()*( max - mini + 1 ) ) + mini;
		
		supprimerElement(getElement(xAlea,yAlea));
		G_Element.ajouterBase(xAlea, yAlea,colJ2);
		
    	/* Cree les differents chateau */
		for (int i=0; i< nombreChateau; i++)
		{
			xAlea=(int) (Math.random()*(18));  //Math.random()*( max - mini + 1 ) ) + mini;
			yAlea=(int) (Math.random()*(18));  //Math.random()*( max - mini + 1 ) ) + mini;}
			if(G_Element.getElement(xAlea, yAlea).getNomElement().equals("plaine"))
			{
				G_Element.supprimerElement(G_Element.getElement(xAlea, yAlea));
				G_Element.ajouterChateau(xAlea, yAlea);
			}
		}

		/* Cree les differentes montagne */
		for (int i=0; i< nombreMontagne; i++)
		{
			xAlea=(int) (Math.random()*(18));  //Math.random()*( max - mini + 1 ) ) + mini;
			yAlea=(int) (Math.random()*(18));  //Math.random()*( max - mini + 1 ) ) + mini;}
			if(G_Element.getElement(xAlea, yAlea).getNomElement().equals("plaine"))
			{
				G_Element.supprimerElement(G_Element.getElement(xAlea, yAlea));
				G_Element.ajouterMontagne(xAlea,yAlea);
			}
		}
				
		//on genre un chemin vide en L d'une base a l'autre
		if(G_Element.getBase(colJ1).getX()>G_Element.getBase(colJ2).getX())
		{
			for (int i=G_Element.getBase(colJ1).getX()-1; i>= G_Element.getBase(colJ2).getX(); i--)
			{
				Element tmp=G_Element.getElement(i, G_Element.getBase(colJ1).getY());
				if (!tmp.getNomElement().equals("plaine")) {
					G_Element.supprimerElement(G_Element.getElement(i, G_Element.getBase(colJ1).getY()));
					G_Element.ajouterPlaine(i,G_Element.getBase(colJ1).getY());
				}
				
			}
		}
		else
		{
			for (int i=G_Element.getBase(colJ1).getX()+1; i<=G_Element.getBase(colJ2).getX(); i++)
			{
				Element tmp=G_Element.getElement(i, G_Element.getBase(colJ1).getY());
				
				if (!tmp.getNomElement().equals("plaine")) {
					G_Element.supprimerElement(G_Element.getElement(i, G_Element.getBase(colJ1).getY()));
					G_Element.ajouterPlaine(i,G_Element.getBase(colJ1).getY());
				}
			}
		}
		
    
		//chemin vertical du L
		for (int i=G_Element.getBase(colJ1).getY()+1; i<G_Element.getBase(colJ2).getY(); i++)
			{
				Element tmp=G_Element.getElement(G_Element.getBase(colJ2).getX(), i);

				if (!tmp.getNomElement().equals("plaine")) {
					G_Element.supprimerElement(G_Element.getElement(G_Element.getBase(colJ2).getX(),i));
					G_Element.ajouterPlaine(G_Element.getBase(colJ2).getX(),i);
				}
		}

    }
    /* recupere la base d'un couleur */
    public static Element getBase(Color c) {
    	Element e1=null;
    	for(int i=0;i<getTousLesElements().size();i++)
    	{
    		if(getTousLesElements().get(i).getNomElement().equals("base") && getTousLesElements().get(i).getCouleur()==c)
    			e1=getTousLesElements().get(i);
    	}
        return e1;
    }
    
    /* Recupère l'element de en-dessus par rapport à la position e */
    public static Element getElementBas(Element e) {
        Element e1 = getElement(e.getX() , e.getY()+1);
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }
    /* Recupère l'element de en-bas à gauche par rapport à la position e */
    public static Element getElementBasGauche(Element e) {
    	 Element e1 = getElement(e.getX() -1, e.getY() +1);
         if (e1 == null) {
             e1 = e;
         }
         return e1;
    }

    /* Recupère l'element de en-haut à droite par rapport à la position e */
    public static Element getElementHautDroite(Element e) {
    	 Element e1 = getElement(e.getX() +1, e.getY() -1);
         if (e1 == null) {
             e1 = e;
         }
         return e1;
    }

    /* Recupère l'element de haut-dessus par rapport à la position e */
    public static Element getElementHaut(Element e) {
        Element e1 = getElement(e.getX(), e.getY()-1);
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }

    /* Recupère l'element de gauche par rapport à la position e */
    public static Element getElementGauche(Element e) {
        Element e1 = getElement(e.getX()-1, e.getY());
        if (e1 == null) {
            e1 = e;
        }
        return e1;
    }

    /* Recupère l'element de en-bas à droite par rapport à la position e */
    public static Element getElementBasDroite(Element e) {
        Element e1 = getElement(e.getX() + 1, e.getY() + 1);
        if (e1 == null ) {
            e1 = e;
        }
        return e1;
    }
    
    /* Recupère l'element de en-haut à gauche par rapport à la position e */
    public static Element getElementHautGauche(Element e) {
    	 Element e1 = getElement(e.getX() -1, e.getY() -1);
         if (e1 == null ) {
             e1 = e;
         }
         return e1;
    }
    
    /* Recupère l'element de droite par rapport à la position e */
    public static Element getElementDroite(Element e) {
        Element e1 = getElement(e.getX()+1, e.getY());
        if (e1 == null ) { // pour ne pas bouger si la case n'existe pas
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
    
    public static void ajouterBase(int x,int y, Color c)
    {
    	mesElements.add(new Base(x,y,c));
    }
    
    public static void ajouterChateau(int x,int y)
    {
    	mesElements.add(new Chateau(x,y));
    }
    
    public static void ajouterMontagne(int x,int y)
    {
    	mesElements.add(new Montagne(x,y));
    }

    public static void supprimerElement(Element e) {
    	getTousLesElements().remove(e);
    }
    
    public static void incrementerPlaine()
    {
    	synchronized (mesElements)
    	{
    		for(int i=0;i<mesElements.size();i++)
        	{
        		//incrementer seulement les plaines
    			if(mesElements.get(i) instanceof Plaine && mesElements.get(i).getCouleur()!=Color.WHITE && !(mesElements.get(i) instanceof Chateau))
    			{
        			Plaine p=(Plaine) mesElements.get(i);
        			System.out.println(p.getSoldats());

        			p.incrementerSoldat();
    			} 	
        	}
    	}
    }
    
    public static void incrementerChateaux()
    {
    	synchronized (mesElements)
    	{
    		for(int i=0;i<mesElements.size();i++)
        	{
        		//incrementer seulement les chateaux non vide
    			if(mesElements.get(i) instanceof Chateau && mesElements.get(i).getCouleur()!=Color.WHITE)
    			{
        			Plaine p=(Plaine) mesElements.get(i);
        			System.out.println(p.getSoldats());
        			p.incrementerSoldat();
    			} 	
        	}
    	}
    }
   
}
