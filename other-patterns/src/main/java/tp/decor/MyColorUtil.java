package tp.decor;

import java.awt.Color;

public class MyColorUtil {
	
	public static Color colorFromIndex(int index) {
		int indexModulo8 = index%8;
		switch(indexModulo8){
			case 0 : return Color.BLACK;
			case 1 : return Color.RED;
			case 2 : return Color.GREEN;
			case 3 : return Color.BLUE;
			case 4 : return Color.MAGENTA;
			case 5 : return Color.GRAY;
			case 6 : return Color.ORANGE;
			case 7:
			default: return Color.YELLOW;
		}
	}

}
