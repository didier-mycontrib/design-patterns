package tp.task;

import org.junit.jupiter.api.Test;

public class TestCompositeTask {
	
	
	@Test
	public void testCompositeTask() {
		Task checkListTask = new CompositeTask(new CheckPressureTask(),
				                               new CheckTemperatureTask());
		Task allTasks = new CompositeTask(checkListTask,new PrepareCoffeeTask());
		allTasks.execute();
	}

}
