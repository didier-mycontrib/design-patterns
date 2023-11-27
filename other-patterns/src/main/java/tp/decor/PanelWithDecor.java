package tp.decor;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelWithDecor extends JPanel {
	
	public PanelWithDecor(){
		
	}
	
	
	public void genererDecor(Graphics g) {
		int nbCol=16;
		int nbRow=3;
		int spaceDelta=3;
		int colorIndex=0;
		FigurineInPoolFactory figurineInPoolFactory = FigurineInPoolFactory.getInstance();
		boolean filled=true;
		for(int i=0;i<nbRow;i++) {
			int yPos= 10 + i*(Figurine.HEIGHT+spaceDelta);
			
			for(int j=0;j<nbCol;j++) {
				Figurine decorPart = figurineInPoolFactory.getFigurineObject(j);
				int xPos= 10 + j*(Figurine.WIDTH+spaceDelta);
				colorIndex++;
				decorPart.draw(g, xPos, yPos, MyColorUtil.colorFromIndex(colorIndex),filled);
				filled=!filled;//for next loop
			}
		}
	}
	
	public void genererDecorAvecMemento(Graphics g) {
		int deltaYavecMemento=4*Figurine.HEIGHT;
		int nbCol=16;
		int nbRow=3;
		int spaceDelta=3;
		FigurineInPoolFactory figurineInPoolFactory = FigurineInPoolFactory.getInstance();
		for(int i=0;i<nbRow;i++) {
			Figurine decorPart = figurineInPoolFactory.getFigurineObject(i);
			int yPos= 10 + i*(Figurine.HEIGHT+spaceDelta)+ deltaYavecMemento;
			for(int j=0;j<nbCol;j++) {
				int xPos= 10 + j*(Figurine.WIDTH+spaceDelta);
				decorPart.drawNext(g, xPos, yPos);
			}
		}
	}
	
	public void paint(Graphics g) {
		genererDecor(g);
		genererDecorAvecMemento(g);
	}

}
