package tp.task;

import java.util.Arrays;
import java.util.List;

public class CheckPressureTask implements Task{

	
	public List<Object> execute(Object ...args) {
		System.out.println("... checking pressure ...");
		return Arrays.asList("pressure checked");
	};

}
