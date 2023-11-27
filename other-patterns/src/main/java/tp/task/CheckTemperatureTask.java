package tp.task;

import java.util.Arrays;
import java.util.List;

public class CheckTemperatureTask implements Task{

	@Override
	public List<Object> execute(Object ...args) {
		System.out.println("... checking temperature ...");	
		return Arrays.asList("temperature checked");
	}

}
