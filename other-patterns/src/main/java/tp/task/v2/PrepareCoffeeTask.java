package tp.task.v2;

import java.util.Arrays;
import java.util.List;

public class PrepareCoffeeTask extends Task{

	@Override
	public List<Object> execute(Object ...args) {
		System.out.println("... preparing coffee ...");	
		return Arrays.asList("coffee ready");
	}

}
