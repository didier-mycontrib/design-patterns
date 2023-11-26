package tp.decor;

import java.awt.Color;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class DecorMainWindowApp  extends JFrame{
	
	PanelWithDecor panel = new PanelWithDecor();

	public DecorMainWindowApp() throws HeadlessException {
			this.setTitle("decor-app");
			this.setBounds(50,50,600,400);
			panel.setBackground(Color.LIGHT_GRAY);
			this.getContentPane().add(panel);
			this.setVisible(true);
		    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		DecorMainWindowApp app=new DecorMainWindowApp();
		try {
			Thread.sleep(20);//20ms de pause
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
