package tp.decor;

import java.awt.Color;
import java.awt.Graphics;

public interface Figurine {
	public static int WIDTH=20;
	public static int HEIGHT=40;
	public void draw(Graphics g,int xBase,int yBase,Color color);
}
