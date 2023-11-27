package tp.task;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TestCompositeTask {
	
	
	@Test
	public void testCompositeTask() {
		Task checkListTask = new CompositeTask(new CheckPressureTask(),
				                               new CheckTemperatureTask());
		Task allTasks = new CompositeTask(checkListTask,new PrepareCoffeeTask());
		List<Object> taskResults = allTasks.execute();
		System.out.println("taskResults="+taskResults);
	}

}
