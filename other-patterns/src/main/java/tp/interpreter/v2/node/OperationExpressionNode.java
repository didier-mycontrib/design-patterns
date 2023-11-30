package tp.interpreter.v2.node;

public abstract class OperationExpressionNode extends AbstractExpressionNode{
	
	protected String opName; //"+" or "*" or ...
	protected AbstractExpressionNode leftExpressionNode;
	protected AbstractExpressionNode rightExpressionNode;


	public OperationExpressionNode(String opName, AbstractExpressionNode leftExpressionNode,
			AbstractExpressionNode rightExpressionNode) {
		this.opName = opName;
		this.leftExpressionNode = leftExpressionNode;
		this.rightExpressionNode = rightExpressionNode;
		this.setSubExpression(leftExpressionNode.getSubExpression()+opName+rightExpressionNode.getSubExpression());
	}

	@Override
	public String toString() {
		return opName;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}
	
	

}
