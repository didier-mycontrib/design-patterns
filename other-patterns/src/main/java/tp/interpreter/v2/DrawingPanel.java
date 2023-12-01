package tp.interpreter.v2;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tp.interpreter.v2.node.AbstractExpressionNode;
import tp.interpreter.v2.parser.ExpressionParser;

public class DrawingPanel extends JPanel{
	 
	private ExpressionContext expressionContext = new ExpressionContext();
	
	int nbPoints=100;
	int tabX[]=new int[nbPoints];
    int tabY[]=new int[nbPoints];

	private int nbColSize=22;
	private JTextField txtExpression = new JTextField("x^2-3*x+4",nbColSize);
	private JButton btnEval = new JButton("eval expression");
	
	public DrawingPanel() {
		this.add(txtExpression);
		this.add(btnEval);
		btnEval.addActionListener((e)-> {
				double coeff=10.0; //zoom
				genererPoints(txtExpression.getText(),-30,+30,coeff);
				genererGraphique(this.getGraphics());
			}
		);
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		genererGraphique(g);
	}



	public void genererGraphique(Graphics g) {
    	int deltaY=40; //pour afficher un peu plus bas que zone de saisie et bouton
    	
    	//0.effacer ancien dessin
    	g.clearRect(0, deltaY, 600, 600+deltaY);
    	g.clipRect(0, deltaY, 600, 600+deltaY);
    	
		//1. generation des axes
		g.setColor(Color.BLACK);
		g.drawLine(0,300+deltaY,600,300+deltaY);
		g.drawLine(300,0+deltaY,300,600+deltaY);
		
		//1. generation de la courbe
		g.setColor(Color.BLUE);
		int x1=300+tabX[0];
		int y1=300-tabY[0];
		for(int i=1;i<nbPoints;i++) {
			int x2=300+tabX[i];
			int y2=300-tabY[i];
			g.drawLine(x1,y1+deltaY,x2,y2+deltaY);
		    //pour prochaine interation:
		    x1=x2; y1=y2;
		}
		
	}
	public void genererPoints(String aExpr,double xMin,double xMax,double coeff) {

        //1. analyse de l'expression arithmetique et construction de l'arbre:
    	AbstractExpressionNode noeudRacineExpressionArithmetique = ExpressionParser.INSTANCE.parse(aExpr, expressionContext);
        
       	        
        //2. evaluations de l'arbre (effectuer calculs) pour coords points de la courbe
        
        double delta = (xMax-xMin)/nbPoints;
        for(int i=0; i<nbPoints; i++) {
        	double x=xMin+i*delta;
        	this.expressionContext.setVarValue("x", x); 
        	double y= noeudRacineExpressionArithmetique.eval(this.expressionContext);
        	tabX[i]=(int)(x*coeff); tabY[i]=(int)(y*coeff);
        }
    }

}
