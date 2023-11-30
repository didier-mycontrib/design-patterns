package tp.interpreter.v2.parser;

import tp.interpreter.v2.ExpressionContext;
import tp.interpreter.v2.node.AbstractExpressionNode;
import tp.interpreter.v2.node.AdditionExpressionNode;
import tp.interpreter.v2.node.DivisionExpressionNode;
import tp.interpreter.v2.node.MultiplicationExpressionNode;
import tp.interpreter.v2.node.NumericExpressionNode;
import tp.interpreter.v2.node.PuissanceExpressionNode;
import tp.interpreter.v2.node.SoustractionExpressionNode;
import tp.interpreter.v2.node.VarExpressionNode;

public class ExpressionParser {
	
	public static ExpressionParser INSTANCE = new ExpressionParser();
	
	//principaux operateurs mathematiques dans l'ordre inverse des priorites mathematiques:
    private static String[] operateurs = { "+" , "-" , "/" , "*" , "^" };  
	
	// build Expression Tree (AST Abstract Syntax Tree)
	public AbstractExpressionNode parse(String expr, ExpressionContext context){
		AbstractExpressionNode noeud = null;
		
		expr=ParentheseUtil.enleverEspace(expr);//si besoin (au cas ou)
    	
    	//expr = expression arithmetique a analyser (comportant potentiellement des parentheses)
    	//exprSansParentese  = expression partielle ou les blocs entre parenthese (a traiter plus tard) sont remplaces par des blancs
    	
    	String exprSansParenthese = ParentheseUtil.sansParenthese(expr);
    	//NB: exprSansParenthese est de meme longueur que expr et caracteres utiles aux memes positions
    	
    	//1.recherche des operateurs dans l'ordre inverse des priorites mathematiques:
    	for(String op : operateurs) {
    	    int pos = exprSansParenthese.indexOf(op);
    	    if(pos>0) {
    	    	//un des operateurs trouve et au moins un caractere avant pour former fg.
    	    	AbstractExpressionNode leftNode = 
    	    			this.parse(ParentheseUtil.sousExpressionGaucheSelonParenthese(expr,exprSansParenthese,pos),context);
    	    	AbstractExpressionNode rightNode = 
    	    			this.parse(ParentheseUtil.sousExpressionDroiteSelonParenthese(expr,exprSansParenthese,pos),context);
    	    	switch(op) {
    	    	  case "+" :	noeud= new AdditionExpressionNode(leftNode,rightNode); break;
    	    	  case "-" :	noeud= new SoustractionExpressionNode(leftNode,rightNode); break;
    	    	  case "*" :	noeud= new MultiplicationExpressionNode(leftNode,rightNode); break;
    	    	  case "/" :	noeud= new DivisionExpressionNode(leftNode,rightNode); break;
    	    	  case "^" :	noeud= new PuissanceExpressionNode(leftNode,rightNode); break;
    	    	}
    	    	break;
    	    }
    	}
    	if(noeud==null) {
        	//2.recherche des noms de variables ("x" , "y" , ...}
    		for(String v : context.getVarNames()) {
        	    int pos = exprSansParenthese.indexOf(v);
        	    if(pos>=0) {
        	    	noeud = new VarExpressionNode(v);
        	    	break;
        	    }
        	 }
    	}
    	if(noeud==null) {
        	//3.recherche des valeurs numeriques:
    		double val = 0;
    		try {
    		  val = Double.parseDouble(exprSansParenthese) ;
    		  noeud= new NumericExpressionNode(val);
    		}catch(NumberFormatException nfe) {
    			//pas numerique, pas grave, on aura au moins essaye 
    		}
    	}
    	return noeud;
	}

}
