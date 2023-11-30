package tp.interpreter.v2.node;

import tp.interpreter.v2.ExpressionContext;

public interface ExpressionNode {
	double eval(ExpressionContext context);//interpret/evaluate expression
}


