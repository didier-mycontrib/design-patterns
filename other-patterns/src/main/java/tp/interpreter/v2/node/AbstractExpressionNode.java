package tp.interpreter.v2.node;

public abstract class AbstractExpressionNode implements ExpressionNode{
	protected String subExpression; //sous expression liée à la branche courante
	public abstract boolean isLeaf();//true if terminalExpressionNode , false if not
	

	public String getSubExpression() {
		return subExpression;
	}

	public void setSubExpression(String subExpression) {
		this.subExpression = subExpression;
	}
	
}
