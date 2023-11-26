package tp.decor;

import java.awt.Color;
import java.awt.Graphics;

//classe pour générer/dessiner une figurine Femme(en tant que partie d'un décor à générer)
public abstract class AbstractFigurine implements Figurine {
	

	
	public void dessinerTete(Graphics g, int xBase, int yBase){
		int height = Figurine.HEIGHT/2;
		g.fillOval(xBase, yBase, Figurine.WIDTH, height);
	}
	
    public abstract void dessinerCorps(Graphics g, int xBase, int yBase);
	
	@Override
	public void draw(Graphics g, int xBase, int yBase, Color color) {
		g.setColor(color);
		dessinerTete(g,xBase,yBase);
		dessinerCorps(g,xBase,yBase);
	}

}
