package tp.interpreter.v2;

import tp.interpreter.v2.node.AbstractExpressionNode;
import tp.interpreter.v2.parser.ExpressionParser;

public class ArithmeticApp {
	
	private ExpressionContext expressionContext = new ExpressionContext();

	public static void main(String[] args) {
		ArithmeticApp app = new ArithmeticApp();
		app.testCalculViaArbre();

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
        
        //2. affichage de l'arbre construit:
        StringBuilder sb = new StringBuilder();
        //...... Noeud.subTreeAsString(sb,"",noeudRacineExpressionArithmetique);
        System.out.println("arbre=\n" + sb.toString());
        
        //2. évaluation de l'arbre (effectuer calculs):
        expressionContext.setVarValue("x", 2.0);
        Double y = noeudRacineExpressionArithmetique.eval(this.expressionContext);
        System.out.println("pour x=" + 2 + " y=" + aExpr + "=" + y);
        expressionContext.setVarValue("x", 3.0);
        y = noeudRacineExpressionArithmetique.eval(this.expressionContext);
        System.out.println("pour x=" + 3 + " y=" + aExpr + "=" + y);
        //et avec plein de (x,y) on calcule les points d'une courbe à tracer
    }

}
