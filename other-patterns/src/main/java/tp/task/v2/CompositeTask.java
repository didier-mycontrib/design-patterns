package tp.task.v2;

import java.util.ArrayList;
import java.util.List;

public class CompositeTask extends Task{
	
	private List<Task> subTasks = new ArrayList<>();
	
	public CompositeTask(Task...tasks){
		for(Task t : tasks) {
			addTask(t);
		}
	}
	
	public void addTask(Task t) {
		subTasks.add(t);
		t.setParentTask(this);
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
