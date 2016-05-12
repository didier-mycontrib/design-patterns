package tp.dessin.fig;

public class Rectangle extends Figure{
	
	private static final long serialVersionUID = 1L;
	private int x1,y1,l,h; //+get/set
	
	public Rectangle() {
		super();
	}


	public int getX1() {
		return x1;
	}


	public void setX1(int x1) {
		this.x1 = x1;
	}


	public int getY1() {
		return y1;
	}


	public void setY1(int y1) {
		this.y1 = y1;
	}


	public int getL() {
		return l;
	}


	public void setL(int l) {
		this.l = l;
	}


	public int getH() {
		return h;
	}


	public void setH(int h) {
		this.h = h;
	}

	@Override
	public void performVisit(AbstractFigVisitor figVisitor) {
		figVisitor.doActionForRectangle(this);
	}
	
}
