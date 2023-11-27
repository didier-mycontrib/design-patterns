package tp.decor;

import java.awt.Color;
import java.awt.Graphics;

//classe pour générer/dessiner une figurine Femme(en tant que partie d'un décor à générer)
public abstract class AbstractFigurine implements Figurine {
	
    MyMemento myMemento = new MyMemento(); 
	
	public void dessinerTete(Graphics g, int xBase, int yBase,boolean filled){
		int height = Figurine.HEIGHT/2;
		if(filled)
		   g.fillOval(xBase, yBase, Figurine.WIDTH, height);
		else 
		   g.drawOval(xBase, yBase, Figurine.WIDTH, height);
	}
	
    public abstract void dessinerResteDuCorps(Graphics g, int xBase, int yBase,boolean filled);
	
	@Override
	public void draw(Graphics g, int xBase, int yBase, Color color,boolean filled) {
		g.setColor(color);
		dessinerTete(g,xBase,yBase,filled);
		dessinerResteDuCorps(g,xBase,yBase,filled);
	}

	@Override
	public void drawNext(Graphics g, int xBase, int yBase) {
		//récupérer valeurs du mémento
		//System.out.println("myMemento="+myMemento + "for this="+this);
	    boolean lastFilled =myMemento.isLastFilled();
	    int lastColorIndex = myMemento.getLastColorIndex();
	    //générer de nouvelles valeurs en partant de celles du mémento
	    boolean filled = !lastFilled;
	    int colorIndex = lastColorIndex + 1;
	    //dessiner la figurine:
	    g.setColor(MyColorUtil.colorFromIndex(colorIndex));
		dessinerTete(g,xBase,yBase,filled);
		dessinerResteDuCorps(g,xBase,yBase,filled);
	    //mettre à jour le mémento pour le prochain usage:
		myMemento=new MyMemento(colorIndex, filled);
	}
	
	

}
