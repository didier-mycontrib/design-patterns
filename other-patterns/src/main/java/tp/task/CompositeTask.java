package tp.task;

import java.util.ArrayList;
import java.util.List;

public class CompositeTask implements Task{
	
	private List<Task> subTasks = new ArrayList<>();
	
	public CompositeTask(Task...tasks){
		for(Task t : tasks) {
			addTask(t);
		}
	}
	
	public void addTask(Task t) {
		subTasks.add(t);
	}
	
	@Override
	public void execute() {
		for(Task subTask : subTasks) {
			subTask.execute();
		}
	}
}
