package tp.task.v2;

import java.util.Arrays;
import java.util.List;

public class CheckPressureTask extends Task{

	
	public List<Object> execute(Object ...args) {
		System.out.println("... checking pressure ...");
		return Arrays.asList("pressure checked");
	};

}
