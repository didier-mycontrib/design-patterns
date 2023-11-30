package tp.interpreter.v2.node;

import tp.interpreter.v2.ExpressionContext;

public class NumericExpressionNode extends AbstractExpressionNode{
	
	private Double numericValue; //2 or 6 or ...
	
	public NumericExpressionNode(Double numericValue) {
		this.numericValue=numericValue;
		this.setSubExpression(String.valueOf(numericValue));
	}
	
	public NumericExpressionNode() {
		this(0.0);//default value
	}

	@Override
	public double eval(ExpressionContext context) {
		return numericValue;
	}

	@Override
	public String toString() {
		return String.valueOf(this.numericValue);
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	public Double getNumericValue() {
		return numericValue;
	}

	public void setNumericValue(Double numericValue) {
		this.numericValue = numericValue;
	}


}
