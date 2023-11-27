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
	public List<Object> execute(Object ...args) {
		List<Object> allSubTaskResults = new ArrayList<>();
		for(Task subTask : subTasks) {
			//allSubTaskResults.add(subTask.execute(args));
			allSubTaskResults.addAll(subTask.execute(args));
		}
		return allSubTaskResults;
	}
}
