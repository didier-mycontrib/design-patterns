package tp.decor;

import java.awt.Graphics;

//classe pour générer/dessiner une figurine Homme(en tant que partie d'un décor à générer)
public class FigurineHomme extends AbstractFigurine {
	
	//version basique : tete en rond au dessus de corps en rectangle pour homme 
	//xBase et yBase = coin en haut à gauche
	
	@Override
    public void dessinerResteDuCorps(Graphics g, int xBase, int yBase,boolean filled){
    	int height = Figurine.HEIGHT/2;
    	if(filled)
		   g.fillRect(xBase, yBase+height, Figurine.WIDTH, height);
    	else
    	   g.drawRect(xBase, yBase+height, Figurine.WIDTH, height);
	}
	

}
