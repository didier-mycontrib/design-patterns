package tp.dessin.ext.console;


import tp.dessin.fig.AbstractFigVisitor;
import tp.dessin.fig.Cercle;
import tp.dessin.fig.Ligne;
import tp.dessin.fig.Rectangle;

public class ConsoleVisitor implements AbstractFigVisitor {

	

	public ConsoleVisitor() {
		super();
	}



	@Override
	public void doActionForCercle(Cercle c) {
		System.out.printf("cercle x=%d dy=%d rayon=%d\n",
				c.getXc(), c.getYc(), c.getRayon());
	}

	@Override
	public void doActionForRectangle(Rectangle r) {
		System.out.printf("rectangle x1=%d y1=%d l=%d h=%d\n",
				r.getX1(), r.getY1(), r.getL(), r.getH());

	}

	@Override
	public void doActionForLigne(Ligne l) {
		System.out.printf("ligne x1=%d y1=%d x2=%d y2=%d\n",
				l.getX1(), l.getY1(), l.getX2(), l.getY2());
	}

}
