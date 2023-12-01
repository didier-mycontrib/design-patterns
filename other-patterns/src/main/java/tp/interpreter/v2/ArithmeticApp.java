package tp.interpreter.v2;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tp.interpreter.v2.node.AbstractExpressionNode;
import tp.interpreter.v2.parser.ExpressionParser;

public class ArithmeticApp  extends JFrame{
	
	DrawingPanel panel = new DrawingPanel();
	
	private ExpressionContext expressionContext = new ExpressionContext();
	
	public ArithmeticApp() {
		this.setTitle("ArithmeticApp");
		this.setBounds(50,50,600,640);
		panel.setBackground(Color.LIGHT_GRAY);
		this.getContentPane().add(panel);
		this.setVisible(true);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		ArithmeticApp app = new ArithmeticApp();
		app.testCalculViaArbre();
		String aExpr = "x^2-3*x+4";
    	double coeff=10.0; //zoom
        app.genererGraphiqueSvg(aExpr,-30,+30,coeff);
	}
	
	public void testCalculViaArbre() {
		AbstractExpressionNode noeudRacineExpressionArithmetique; 
		//String aExpr="-2";
		//String aExpr="x";
		//String aExpr="1+x";
        //String aExpr = "2+3*x";
		//String aExpr = "(x^2)/3";
        //String aExpr = "4*x^2-3*(x-2)";
        String aExpr = "((x^2+1)*(x-2))-3*(x-1)";
        
        //1. analyse de l'expression arithmetique et construction de l'arbre:
        noeudRacineExpressionArithmetique = ExpressionParser.INSTANCE.parse(aExpr, expressionContext);
        
        //2. affichage de l'arbre construit (just for debug/verify):
        noeudRacineExpressionArithmetique.dumpAST("");
        
        //2. évaluation de l'arbre (effectuer calculs):
        expressionContext.setVarValue("x", 2.0);
        Double y = noeudRacineExpressionArithmetique.eval(this.expressionContext);
        System.out.println("pour x=" + 2 + " y=" + aExpr + "=" + y);
        expressionContext.setVarValue("x", 3.0);
        y = noeudRacineExpressionArithmetique.eval(this.expressionContext);
        System.out.println("pour x=" + 3 + " y=" + aExpr + "=" + y);
        //et avec plein de (x,y) on calcule les points d'une courbe à tracer
    }
	
	 public void genererGraphiqueSvg(String aExpr,double xMin,double xMax,double coeff) {
	    	int nbPoints=100;
	        
	        //1. analyse de l'expression arithmetique et construction de l'arbre:
	    	AbstractExpressionNode noeudRacineExpressionArithmetique = ExpressionParser.INSTANCE.parse(aExpr, expressionContext);
	        
	       	        
	        //3. evaluations de l'arbre (effectuer calculs) pour coords points de la courbe
	        int tabX[]=new int[nbPoints];
	        int tabY[]=new int[nbPoints];
	        double delta = (xMax-xMin)/nbPoints;
	        for(int i=0; i<nbPoints; i++) {
	        	double x=xMin+i*delta;
	        	this.expressionContext.setVarValue("x", x); 
	        	double y= noeudRacineExpressionArithmetique.eval(this.expressionContext);
	        	tabX[i]=(int)(x*coeff); tabY[i]=(int)(y*coeff);
	        }
	        
	        //4. generation du fichier svg (a afficher avec un navigateur internet)
	        try {
				PrintStream ps=new PrintStream(new FileOutputStream("graphique.svg"));
				ps.println("<svg xmlns='http://www.w3.org/2000/svg' width='600' height='600' >");
				ps.printf("<line x1='%d' y1='%d' x2='%d' y2='%d' style='stroke:black;'/>",0,300,600,300);
				ps.printf("<line x1='%d' y1='%d' x2='%d' y2='%d' style='stroke:black;'/>",300,0,300,600);
				int x1=300+tabX[0];
				int y1=300-tabY[0];
				for(int i=1;i<nbPoints;i++) {
					int x2=300+tabX[i];
					int y2=300-tabY[i];
				    ps.printf("<line x1='%d' y1='%d' x2='%d' y2='%d' style='stroke:blue;'/>",x1,y1,x2,y2);
				    //pour prochaine interation:
				    x1=x2; y1=y2;
				}
				ps.println("</svg>");
				ps.close();
				System.out.println("fichier graphique.svg ok pour firefox ou chrome");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	        
	    }

}
