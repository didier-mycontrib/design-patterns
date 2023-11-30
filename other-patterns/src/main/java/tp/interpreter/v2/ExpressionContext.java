package tp.interpreter.v2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExpressionContext {
	
	private Map<String,Double> mapVars=new HashMap<>(); //map<VarName,VarValue)

	public ExpressionContext(){
		setVarValue("x",0.0); //default entry , useful for parse classic expression with x
	}
	
	
	public void setVarValue(String varName,Double varValue) {
		mapVars.put(varName, varValue);
	}
	
	public Double getVarValue(String varName) {
		return mapVars.get(varName);
	}
	
	public Set<String> getVarNames() {
		return mapVars.keySet();
	}
	
	
}
