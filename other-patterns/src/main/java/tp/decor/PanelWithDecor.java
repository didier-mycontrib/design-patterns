package tp.decor;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelWithDecor extends JPanel {
	
	public PanelWithDecor(){
		
	}
	
	private Color colorFromIndex(int index) {
		int indexModulo8 = index%8;
		switch(indexModulo8){
			case 0 : return Color.BLUE;
			case 1 : return Color.RED;
			case 2 : return Color.GREEN;
			case 3 : return Color.YELLOW;
			case 4 : return Color.MAGENTA;
			case 5 : return Color.GRAY;
			case 6 : return Color.ORANGE;
			case 7:
			default: return Color.BLACK;
		}
	}
	
	public void genererDecor(Graphics g) {
		int nbCol=10;
		int nbRow=3;
		int spaceDelta=3;
		FigurineInPoolFactory figurineInPoolFactory = FigurineInPoolFactory.getInstance();
		
		for(int i=0;i<nbCol;i++) {
			Figurine decorPart = figurineInPoolFactory.getFigurineObject(i);
			int xPos= 10 + i*(Figurine.WIDTH+spaceDelta);
			for(int j=0;j<nbRow;j++) {
				int yPos= 10 + j*(Figurine.HEIGHT+spaceDelta);
				decorPart.draw(g, xPos, yPos, colorFromIndex(i+j));
			}
		}
	}
	
	public void paint(Graphics g) {
		genererDecor(g);
	}

}
