package tp.interpreter.v2.node;

import tp.interpreter.v2.ExpressionContext;

public class SoustractionExpressionNode extends OperationExpressionNode {
	
	public SoustractionExpressionNode(AbstractExpressionNode leftExpressionNode, AbstractExpressionNode rightExpressionNode) {
		super("-",leftExpressionNode,rightExpressionNode);
	}

	@Override
	public double eval(ExpressionContext context) {
		return this.leftExpressionNode.eval(context) - this.rightExpressionNode.eval(context);
	} 

}
