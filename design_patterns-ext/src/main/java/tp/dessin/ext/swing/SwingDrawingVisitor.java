package tp.dessin.ext.swing;

import java.awt.Graphics;

import tp.dessin.fig.AbstractFigVisitor;
import tp.dessin.fig.Cercle;
import tp.dessin.fig.Ligne;
import tp.dessin.fig.Rectangle;

public class SwingDrawingVisitor implements AbstractFigVisitor {
	
	private Graphics g;
	
	public SwingDrawingVisitor() {
		super();
	}

	public SwingDrawingVisitor(Graphics g) {
		super();
		this.g = g;
	}

	public void setGraphics(Graphics g) {
		this.g = g;
	}

	@Override
	public void doActionForCercle(Cercle c) {
		int x1=c.getXc()-c.getRayon();
		int y1=c.getYc()-c.getRayon();
		int width=2*c.getRayon();
		int height=2*c.getRayon();
		g.setColor(c.getCouleur());
		g.drawOval(x1, y1, width, height);	
	}

	@Override
	public void doActionForRectangle(Rectangle r) {
		g.setColor(r.getCouleur());
		g.drawRect(r.getX1(), r.getY1(), r.getL(), r.getH());	
	}

	@Override
	public void doActionForLigne(Ligne l) {
		g.setColor(l.getCouleur());
		g.drawLine(l.getX1(),l.getY1(), l.getX2(), l.getY2());		
	}

}
