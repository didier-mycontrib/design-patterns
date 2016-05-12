package tp.dessin.fig;

public class Cercle extends Figure{
	
	private static final long serialVersionUID = 1L;
	private int xc,yc,rayon; //+get/set
	
	public Cercle() {
		super();
	}


	
	public int getXc() {
		return xc;
	}


	public void setXc(int xc) {
		this.xc = xc;
	}


	public int getYc() {
		return yc;
	}


	public void setYc(int yc) {
		this.yc = yc;
	}


	public int getRayon() {
		return rayon;
	}


	public void setRayon(int rayon) {
		this.rayon = rayon;
	}

   
	@Override
	public void performVisit(AbstractFigVisitor figVisitor) {
		figVisitor.doActionForCercle(this);		
	}
	
}
