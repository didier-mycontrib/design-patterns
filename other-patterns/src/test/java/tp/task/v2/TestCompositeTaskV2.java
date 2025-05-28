package tp.task.v2;

import java.util.List;

import org.junit.jupiter.api.Test;

// V2 = version améliorée avec combinaison de 2 patterns:
// composite et chain of responsibility pour récupérer (de parent en parent) la meilleure description possible

public class TestCompositeTaskV2 {
	
	
	@Test
	public void testCompositeTaskV2() {
		Task checkPressureTask = new CheckPressureTask();
		//checkPressureTask.setDescription("check pressure");
		Task checkTemperatureTask = new CheckTemperatureTask();
		Task checkListTask = new CompositeTask(checkPressureTask,
												checkTemperatureTask);
		checkListTask.setDescription("check list");
		Task prepareCoffeeTask = new PrepareCoffeeTask();
		Task allTasks = new CompositeTask(checkListTask,prepareCoffeeTask);
		allTasks.setDescription("some task(s)");
		List<Object> taskResults = allTasks.execute();
		System.out.println("taskResultsV2="+taskResults);

		System.out.println("meilleur description pour checkPressureTask="
		          + checkPressureTask.recupererDescription());
	}

}
