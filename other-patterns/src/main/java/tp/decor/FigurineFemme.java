package tp.decor;

import java.awt.Graphics;

//classe pour générer/dessiner une figurine Femme(en tant que partie d'un décor à générer)
public class FigurineFemme extends AbstractFigurine {
	
	//version basique : tete en rond au dessus d'un corps 
	//en triangle pour femme , xBase et yBase = coin en haut à gauche
	
	@Override
    public void dessinerResteDuCorps(Graphics g, int xBase, int yBase,boolean filled){
    	int height = Figurine.HEIGHT/2;
	    int[] xPoints = { xBase+Figurine.WIDTH/2 , xBase , xBase+Figurine.WIDTH };
		int[] yPoints = { yBase+height , yBase+2*height , yBase+2*height};
		if(filled)
		  g.fillPolygon(xPoints, yPoints, 3);
		else
		  g.drawPolygon(xPoints, yPoints, 3);
	}


}
