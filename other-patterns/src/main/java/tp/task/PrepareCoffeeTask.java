package tp.task;

import java.util.Arrays;
import java.util.List;

public class PrepareCoffeeTask implements Task{

	@Override
	public List<Object> execute(Object ...args) {
		System.out.println("... preparing coffee ...");	
		return Arrays.asList("coffee ready");
	}

}
