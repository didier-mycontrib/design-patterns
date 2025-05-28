package tp.task.v2;

import java.util.Arrays;
import java.util.List;

public class CheckTemperatureTask extends Task{

	@Override
	public List<Object> execute(Object ...args) {
		System.out.println("... checking temperature ...");	
		return Arrays.asList("temperature checked");
	}

}
