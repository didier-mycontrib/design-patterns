package tp.interpreter.v2.node;

import tp.interpreter.v2.ExpressionContext;

public class VarExpressionNode extends AbstractExpressionNode{
	
	private String varName; //"x" or "y" or ...
	
	public VarExpressionNode(String varName) {
		this.varName=varName;
		this.setSubExpression(varName);
	}
	
	public VarExpressionNode() {
		this("?");
	}

	@Override
	public double eval(ExpressionContext context) {
		return context.getVarValue(varName);
	}

	@Override
	public String toString() {
		return varName;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}
	
	

}
