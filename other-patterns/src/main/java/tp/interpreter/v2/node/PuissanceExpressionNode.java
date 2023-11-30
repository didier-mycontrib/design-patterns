package tp.interpreter.v2.node;

import tp.interpreter.v2.ExpressionContext;

public class PuissanceExpressionNode extends OperationExpressionNode {
	
	public PuissanceExpressionNode(AbstractExpressionNode leftExpressionNode, AbstractExpressionNode rightExpressionNode) {
		super("^",leftExpressionNode,rightExpressionNode);
	}

	@Override
	public double eval(ExpressionContext context) {
		return Math.pow(this.leftExpressionNode.eval(context) , this.rightExpressionNode.eval(context));
		
	} 

}
