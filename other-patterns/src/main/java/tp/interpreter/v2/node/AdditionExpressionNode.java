package tp.interpreter.v2.node;

import tp.interpreter.v2.ExpressionContext;

public class AdditionExpressionNode extends OperationExpressionNode {
	
	public AdditionExpressionNode(AbstractExpressionNode leftExpressionNode, AbstractExpressionNode rightExpressionNode) {
		super("+",leftExpressionNode,rightExpressionNode);
	}

	@Override
	public double eval(ExpressionContext context) {
		return this.leftExpressionNode.eval(context) + this.rightExpressionNode.eval(context);
	} 

}
