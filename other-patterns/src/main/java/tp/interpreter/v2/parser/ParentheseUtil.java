package tp.interpreter.v2.parser;
/*
 * ArithmeticExpressionParserUtil = 
 * paquets de fonctions statiques pour analyser une expression arithmetique
 * avec ou sans parentheses .
 */
public class ParentheseUtil {
	
	public static String enleverEspace(String chaine){
    	return chaine.replaceAll(" ", "");
    }
	
	public static String sansParenthese(String expr) {
    	//expr = expression arithmetique a analyser (comportant potentiellement des parentheses)
    	//exprSansParentese  = expression partielle ou les blocs entre parenthese (a traiter plus tard) sont remplaces par des blancs
    	StringBuilder sb = new StringBuilder(expr.length());
    	int nbParenthesesOuvertesEtPasRefermees = 0;
    	for(int i=0;i<expr.length();i++) {
    		char c = expr.charAt(i);
    		if(c=='(')
    			nbParenthesesOuvertesEtPasRefermees++;
    		else if(c==')')
    			nbParenthesesOuvertesEtPasRefermees--;
    		
    		if(nbParenthesesOuvertesEtPasRefermees>0)
    			sb.append(' ');
    		else
    			sb.append(c);
    	}
    	return sb.toString();
    }
    
    public static boolean avecBlocParentheseRemplace(String subExpression) {
    	return subExpression != null && subExpression.length() > 0 && subExpression.charAt(0)==' ' ;
    	//une sousExpression correspond a un bloc de parenthese remplace par un paquet d'espaces
    	//si celle ci comporte au moins un espace sachant que l'expression originale ne comporte aucun espace
    }
    
    public static String sousExpressionGaucheSelonParenthese(String expr, String exprSansParenthese , int pos) {
    	String sousExprGauche= expr.substring(0,pos);
    	String sousExprGaucheSansParenthese = exprSansParenthese.substring(0,pos);
    	if(avecBlocParentheseRemplace(sousExprGaucheSansParenthese)) {
    		return sousExprGauche.substring(1, sousExprGauche.length()-1); //on enleve les parentheses a chaque extremite
    	}else {
    		return sousExprGauche;
    	}
    }
    
    public static String sousExpressionDroiteSelonParenthese(String expr, String exprSansParenthese , int pos) {
    	String sousExprDroite= expr.substring(pos+1);
    	String sousExprDroiteSansParenthese = exprSansParenthese.substring(pos+1);
    	if(avecBlocParentheseRemplace(sousExprDroiteSansParenthese)) {
    		return sousExprDroite.substring(1, sousExprDroite.length()-1); //on enleve les parentheses a chaque extremite
    	}else {
    		return sousExprDroite;
    	}
    }

}
